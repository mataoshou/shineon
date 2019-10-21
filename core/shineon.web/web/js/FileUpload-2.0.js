
/* 文件上传 V2.0.3 20160923
 *   注意：外部容器<div>不要放在<form>里，否则会造成嵌套
 * 
 */

function createFL( parent , settings)
{
	// 在父元素<div>里创建内容
	var html = 
		"<form role='form'  method='post' enctype='multipart/form-data'>"
		+ "<input type='file' style='display:none;' name='fileUpload' role='fileButton' />"
		+ " </form> "
		+ " <img width='120' height='80' role='preview' /> "		
		+ " <div> "
		+ " <button type='button' style='display:none;' role='btnChoose'> 选择文件 </button>"
		+ " <span role='fileName' class='fileName'> </span> "
		+ " <span style='display:none;' role='fileSize'></span> " 
		+ " <span role='fileProgress' class='fileProgress'></span> "
		+ " <span role='result'> </span> "
		+ " </div> ";
	$(parent).html (html);
	
	// 创建相应的对象
	var fl = new Object();
	fl.settings = settings;
	fl.status = 0;	
	fl.objectUrl = "";
	fl.objectKey = "";
	fl.readonly = false; // 是否可以编辑
	fl.UPLOAD_URL = "CommonFileUpload?type=picture";	
	fl.fl_panel = $(parent); // 父面板 
	//fl.fl_form = $("form", fl.fl_panel); // form表单
    fl.fl_form = $("[role='form']", fl.fl_panel); // form表单
	fl.fl_fileButton = $("[role='fileButton']", fl.fl_panel); // 文件选择按钮
	fl.fl_chooseButton = $("[role='btnChoose']", fl.fl_panel); // 文件选择按钮
	fl.fl_fileName =  $("[role='fileName']", fl.fl_panel); 
	fl.fl_fileSize =  $("[role='fileSize']", fl.fl_panel); 
	fl.fl_fileProgress =  $("[role='fileProgress']", fl.fl_panel); 
	fl.fl_result =  $("[role='result']", fl.fl_panel); 
	fl.fl_image =  $("[role='preview']", fl.fl_panel); 	
	fl.preview = true; // 显示预览
	fl.filter = ""; // 后件后缀过滤
	fl.filelist = new Array(); // 记录所有新上传的objectKeys, 所有的objectKey应该与属主关联
	
	if(typeof settings != "undefined")
	{
		var s = settings;
		if(s.width != null) fl.fl_image.attr("width", s.width);
		if(s.height != null) fl.fl_image.attr("height", s.height);
		if(s.url != null) fl.UPLOAD_URL = s.url;
		if(s.filter != null) fl.filter = s.filter;
		if(s.preview != null && s.preview == false) 
		{
			fl.preview = false;
			fl.fl_image.hide();
			fl.fl_chooseButton.show();
		}
		
	}
	
	// 设置文件按钮的点击回调
	fl.fl_fileButton.change( function(){
		if(fl.readonly) return; // 只读模式
		var e_fileButton = fl.fl_fileButton.get(0);
		var fileInfo = e_fileButton.files[0]; // 文件信息
		fl.onFileSelected (fileInfo);		
	});
	
	fl.fl_image.click( function(){		
		fl.fl_fileButton.click();		
	});
	fl.fl_chooseButton.click( function(){
		fl.fl_fileButton.click();		
	});
	
	
	// 设置url	
	fl.setObjectUrl = function(objectKey, objectUrl)
	{
		this.objectKey = objectKey;
		this.objectUrl = objectUrl;
		if(fl.preview && objectUrl != null && objectUrl.length > 0)
			this.fl_image.attr("src", objectUrl);
	};
	// 清空图片及URL属性的值 
	fl.clear = function()
	{
		this.objectKey = "";
		this.objectUrl = "";
		this.fl_image.attr("src", this.objectUrl);
        this.fl_fileName.html("");
        this.fl_fileProgress.html("");
	};
	
	// 设置只读
	fl.setReadonly = function ( yes )
	{
		this.readonly = yes;
		if(yes)
		{
			this.fl_fileName.html("只读模式,禁止编辑");
		}
	};
	
	// 取得文件名后缀
	fl.getSuffix = function (fileName)
	{
		var p = fileName.lastIndexOf(".");
		if(p >= 0)
			return fileName.substr(p+1);
		return ""; // 无后缀
	}
	
	// 当文件被选中时
	fl.onFileSelected = function (fi)
	{
		this.fl_result.html ("");
		this.fl_fileName.html(fi.name);
		this.fl_fileSize.html(",大小" + fi.size);
		var suffix = this.getSuffix(fi.name);
		if(this.filter.length != 0) // 无后缀
		{
			if (suffix.length == 0 || this.filter.indexOf(suffix) < 0)
			{
				fl.gotError("不支持的文件后缀!");
				fl.fl_form.get(0).reset(); // 重置表单,以便可以选择同一图片
				return;
			}
		}

		// 开始上传
   		this.startUpload(this.fl_form.get(0));
	}
	
	// 显示进度
	fl.showProgress = function ( percent )
	{		
	    this.fl_fileProgress.html(percent + "%");
	}
	
	// 显示错误
	Af.trace = function( text )
	{
		this.status = -1;
		this.fl_result.html (text);
	}

	// 是否成功
	fl.ok = function()
	{
		return this.status == 100;
	}
	
	// API出口, 完成时的回调
	fl.onComplete = function ( ans)
	{
	 	if (ans.errorCode != 0) 
	 	{
	        this.gotError("上传失败!" + ans.reason);
	        return;
	    }	
	    
	    this.status = 100;
	    fl.objectKey = ans.result.objectKey;
	    fl.objectUrl = ans.result.objectUrl;
	    fl.setObjectUrl(fl.objectKey, fl.objectUrl);
	    fl.filelist.push(ans.result.objectKey); // 记录每一个新上传的objectKey
	}
	
	// 开始上传
	fl.startUpload = function ( form )
	{	
	    var vFD = new FormData(form);
	    var oXHR = new XMLHttpRequest();
	    oXHR.upload.addEventListener("progress", this.onUploadProgress, false);
	    oXHR.addEventListener("load", this.onUploadComplete, false);
	    oXHR.addEventListener("error", this.onUploadFailed, false);
	    oXHR.addEventListener("abort", this.onUploadCanceled, false);
	    oXHR.context = this; // 把fl本身传入
	    oXHR.open("POST", this.UPLOAD_URL);
	    oXHR.send(vFD);
	};
	
	fl.onUploadProgress = function (evt, arg2, arg3, arg4) 
	{
	    if (evt.lengthComputable)
	    {
	    	var percent = Math.round(evt.loaded * 100 / evt.total);
	    	fl.showProgress (percent);
	    }	        
	    else 
	    {
	    	fl.gotError("浏览器不支持上传进度的显示！");
	    }
	};
	fl.onUploadComplete = function (evt)
	{
	    var ans = JSON.parse(evt.target.responseText);
	    fl.onComplete(ans);
	    fl.fl_form.get(0).reset(); // 重置表单,以便可以选择同一图片
	};
	fl.onUploadFailed = function (evt) 
	{
		fl.gotError("上传失败！");
	};
	fl.onUploadCanceled = function (evt) 
	{
		fl.gotError("上传取消!");
	};
	
	// 返回结果
	return fl;
}


