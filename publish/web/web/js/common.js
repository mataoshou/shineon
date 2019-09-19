var m_path = "/files/store/";

var COMMON = {};
var COM = COMMON;

/* 审核相关 */
COMMON.censor={};
COMMON.censor.statusText = function ( status )
{
	if(status == null) status = 0;
	if(status == 0) return "编辑中";
	if(status < 0) return "不通过";
	if(status >0 && status < 100) return status + "审中";
	if(status == 100) return "通过";
};

/* 显示整体状态 */

/* 显示审核结果 */
COMMON.censor.result = function(it, LL)
{	
	var result = it.censor1result;
	var name = it.censor1name;
	var time = it.censor1time;
	var comment = it.censor1comment;
	if(LL==2)
	{
		result = it.censor2result;
		name = it.censor2name;
		time = it.censor2time;
		comment = it.censor2comment;		
	}
	
	var tag = new AfTag("button");
	tag.aa("class", "censor-result");
	tag.t(COMMON.censor.statusText(result));
	
	if(result<0)
		tag.aa("class", "censor-status-bad"); // 颜色显示
	if(result==100)
		tag.aa("class", "censor-status-ok"); // 颜色显示
	if(result<0 || result== 100)
	{
		tag.a("censor-result", COMMON.censor.statusText(result))
		.a("by", name)
		.a("time", time)
		.a("comment", comment);
	}
	return tag.toHtml();
};

/* 显示审核结果提示 */
COMMON.censor.popover = function ( container)
{
	$("[censor-result]", container).each ( function (i, e ){
		var result = $(e).attr("censor-result");
		var by = $(e).attr("by");
		var time = $(e).attr("time");
		var comment = $(e).attr("comment");
		var content = "审核人: " + by + "<br>"
			+ "审核时间: " + time + "<br>" 
			+ "<span style='color:red'> " + comment + "</span><br>";
			
		$(e).popover({
			placement: "right",
			trigger: "hover | focus",
			html: true,				
			title: result,
			content:content
		})
	});	
	
	//$(".popover", container).click( function (e){
	//	$(this).hide();
	//});
}

COMMON.doc = {};
COMMON.doc.finalStatus = function(status)
{
	if(status == null) status = 0;
	if(status == 0) return "编辑中";
	if(status == 0) return "审核中";
	if(status == 100) return "完成";
	return "NA";
};

/* 生成locatime控件的日期格式  yyyy-MM-ddThh:mm */
COM.h5LocalTime = function()
{ 		  
	var curTime = "";		  
	var now=new Date(); 		  
	var year=now.getFullYear();   //年 		  
	var month=now.getMonth()+1;   //月 		  
	var day=now.getDate();      //日 		  
	var hh=now.getHours();      //时 		  
	var mm=now.getMinutes();     //分 		  
	var sc=now.getSeconds();     //秒 		  
	curTime += year; 
	curTime += "-";
	curTime += month<10?'0'+month:month; 	
	curTime += "-";
	curTime += day<10?'0'+day:day; 
	curTime += "T";
	curTime += hh<10?'0'+hh:hh; 
	curTime += ":";
	curTime += mm<10?'0'+mm:mm; 		  
	//curTime += sc<10?'0'+sc:sc; 		
	return curTime;
} 

COM.h5LocalDate = function()
{ 		  
	var curTime = "";		  
	var now=new Date(); 		  
	var year=now.getFullYear();   //年 		  
	var month=now.getMonth()+1;   //月 		  
	var day=now.getDate();      //日 		  
	
	curTime += year; 
	curTime += "-";
	curTime += month<10?'0'+month:month; 	
	curTime += "-";
	curTime += day<10?'0'+day:day; 	  
	//curTime += sc<10?'0'+sc:sc; 		
	return curTime;
} 


// 把秒化为时分秒
COM.timestr = function ( N )
{
	var ss = N % 60;
	N = Math.floor( N / 60 );
	var mm = N % 60;
	N = Math.floor( N / 60 );
	var hh = N;
	
	var str = "";
	str += hh<10?'0'+hh:hh; 
	str += ":";
	str += mm<10?'0'+mm:mm; 	
	str += ":";
	str += ss<10?'0'+ss:ss; 	
	return str;
};


// 码率转换
COM.bit = function ( N )
{
	var kb =  (N / 1000);  //kb
    var Mb = (kb/1000);
    var str = "";
    
    str += Mb.toFixed(1);	
    str += ' Mbps'; 	
	return str;
};

COM.timestr2 = function ( N )
{
	var ss = Math.round( (N % 60)*100)/100;
	N = Math.floor( N / 60 );
	var mm = N % 60;
	N = Math.floor( N / 60 );
	var hh = N;
	
	var str = "";
	str += mm<10?'0'+mm:mm; 	
	str += ":";
	str += ss<10?'0'+ss:ss; 	
	return str;
};

COM.date_yyyyMM = function ()
{
	var curTime = "";		  
	var now=new Date(); 		  
	var year=now.getFullYear();   //年 		  
	var month=now.getMonth()+1;   //月 		  
	var day=now.getDate();      //日 		  
	
	curTime += year; 
	curTime += "-";
	curTime += month<10?'0'+month:month; 	
	//curTime += "-";
	//curTime += day<10?'0'+day:day; 	  
	//curTime += sc<10?'0'+sc:sc; 		
	return curTime;
};
COM.date_yyyyMMdd = function ()
{
	var curTime = "";		  
	var now=new Date(); 		  
	var year=now.getFullYear();   //年 		  
	var month=now.getMonth()+1;   //月 		  
	var day=now.getDate();      //日 		  
	
	curTime += year; 
	curTime += "-";
	curTime += month<10?'0'+month:month; 	
	curTime += "-";
	curTime += day<10?'0'+day:day; 	  
	//curTime += sc<10?'0'+sc:sc; 		
	return curTime;
};

// 当月第1天
COM.date_yyyyMMdd_1st = function ()
{
	var curTime = "";		  
	var now=new Date(); 		  
	var year=now.getFullYear();   //年 		  
	var month=now.getMonth()+1;   //月 		  
	var day=1;      //日 		  
	
	curTime += year; 
	curTime += "-";
	curTime += month<10?'0'+month:month; 	
	curTime += "-";
	curTime += day<10?'0'+day:day; 	  
	//curTime += sc<10?'0'+sc:sc; 		
	return curTime;
};

COM.tooltip = function( container)
{
	/* tooltip提示 */
	$("[tooltip]", container).each ( function (i, e ){
		$(e).tooltip({				
			placement: "top",
			delay: { "show": 500, "hide": 100 },
			title: $(e).attr("tooltip")
		})
	});		
}



COM.censor_get = function(it, level)
{
	var obj = {};
	obj.by = it["censor" + level + "name"];
	obj.result =it["censor" + level + "result"]; //拼凑变量名		
	obj.time = it["censor" + level + "time"];
	obj.reason = it["censor" + level + "reason"];
	if(obj.by == null || obj.by == undefined)
		obj.by = "-";
	return obj;
}

COMMON.censor_status = function ( status )
{
	if(status == null) status = 0;
	if(status == 0) return "编辑中";
	if(status < 0) return "<span class='m-failed'>不通过</span>";
	if(status >0 && status < 100) return "<span class='m-waiting'>审核中</span>";
	if(status == 100) return "<span class='m-success'> 审核完成 </span>";
};

COM.censor_substatus = function (it, level)
{
	var c = this.censor_get (it, level);

	if(c.result == 100) 
		return "<span class='m-success'>" + c.by + "</span>";
	else if(c.result < 0) 
		return "<span class='m-failed'>" + c.by + "</span>";	
	else return "-";
}

COM.censor_substatus_icon = function(it, level)
{
	var c = this.censor_get (it, level);

	if(c.result == 100) 
		return "<img src='images/pass.png' />";
	else if(c.result < 0) 
		return "<img src='images/fail.png' />";	
	else 
		return "<img src='images/forbidden.png' />";
}

COM.test = function(value, str)
{
	return value?value:str;
}

COM.dark = function(str)
{
	return "<a  class='m-disable'>" + str + "</a>";
}


//转化为kb
COM.fileSize = function (size) {
    //1KB=1024字节
    //1MB=1024K
    var it = "";
    if (size <= 1000) {
        if (size == 0) {
            it += size;
        } else {
            it += size + "字节";
        }
    } else if (1000 < size && size < 1000000) {
        var K = Math.floor(size / 1000);
        var B = (size % 1000);
        it += Math.floor(K + (B / 1000)) + " KB";
    } else {
        var M = Math.floor(size / 1000 / 1000);
        var K = Math.floor(size / 1000);
        it += Math.floor(M + (K / 1000 / 1000)) + " MB";
    }
    return (it);
}


COM.mediaType = function( type )
{
	if(type==100) return "视频";
	if(type==101) return "音频";
	if(type==102) return "图片";
	if(type==103) return "文档";	
	return "普通";
}

COM.get_image_src=function(content)
{
	var html=$(content);
	var imgs=$("img",html);
	var array_src=[];
	for(var i=0;i<imgs.length;i++)
	{
		array_src.push($(imgs[i]).attr("src"));
	}
	return array_src;
}

COM.str_padding = function(str, N)
{
	var len = str.length;
	for(var i=len; i<N; i++)
	{
		str += " ";
	}
	return str;
}


