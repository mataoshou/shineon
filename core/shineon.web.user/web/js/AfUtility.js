

/* 第一层(外层)使用双引号，第二层使用单引号 */
var Af = {};

/* RESTful 调用的封装 
 *  示例  AfUtil.rest("DraftSave.api", jsReq, onSubmit_Result);	
 */

// rest返回200 OK，但是error值不为0
Af.restErrHandler = function (error, reason) {
    toastr.error(reason);
};
// rest没有返回200 ( 可能返回500等错误，或者网络不可连接)
Af.httpErrHandler = function () {
//  alert("服务器HTTP错误");
};
// serviceUri 服务名, req 请求参象 , dataHandler 应答数据处理函数
Af.rest = function (serviceUri, req, dataHandler, restErrHandler) {
    jQuery.ajax({
        url: serviceUri,
        method: "POST",
        processData: false,
        contentType: 'application/json;charset=utf-8',  
        data: JSON.stringify(req),
        dataType: 'json',
        success: function (ans) {
            if (ans.error != 0) {
                if (restErrHandler != null)
                    restErrHandler(ans.error, ans.reason);
                else
                    Af.restErrHandler(ans.error, ans.reason);
            } else {
                dataHandler(ans);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            Af.httpErrHandler();
        }
    });
}

/* 判断一个字符串是否为空
 *  */
Af.nullstr = function ( v )
{
	return v == null || v.length==0 ;
}


/* 输出日志 */
Af.trace = function(msg)
{
	 try {   console.log(msg);     } catch (err) {}
};


//一个类型
function AfTag (name, pair)
{
	this.name = name;   // 标签名 		
	this.attrList = {}; // 属性
	this.innerHtml = ""; // 内容
	this.pair = pair; // 是否成对标签  		
	
	// 添加attr
	this.a = function(attrName, attrValue)
	{
		this.attrList[attrName] = attrValue;
		return this;
	};
	this.aa = function(attrName, attrValue)
	{
		if(this.attrList[attrName] == null)
			this.attrList[attrName] = attrValue;
		else
			this.attrList[attrName] += (" " + attrValue);
		return this;
	};
	//
	this.t = function ( innerHtml)
	{
		this.innerHtml = innerHtml;
		return this;
	};
	this.tt = function ( innerHtml)
	{		
		this.innerHtml += innerHtml;
		return this;
	};
	// 转成html
	this.toHtml = function()
	{
		var htmlAttr = "";
		for(attrName in this.attrList)
		{
			var attrValue = this.attrList[attrName];
			var str = " " + attrName + "='" + attrValue + "'"  + " ";
			htmlAttr += str;
		}
		
		if(false == this.pair) // 单标签
		{
			return  "<" + name + htmlAttr + "/>" // <img />
	 				;
		}
		else // 成对标签 
		{
			return  "<" + name + htmlAttr + ">" // <div>
 				+ this.innerHtml
 				+ "</" + name + ">" // </div>
 				;
		}
	}; 		
}

/* 以逗号分隔的ID列表 */
function AfIdList ()
{
	this.ids = [];	
	
	this.aa = function (str)
	{
		if(str==null || str.length==0) return this;
		var sss = str.split(",");
		for(var i=0; i<sss.length; i++)
		{
			var it = sss[i];
			if(it.length > 0 && ! this.contains( it ))
			{				
				this.ids.push(it);
			}
		}
		return this;
	};
	this.at = function(index)
	{
		if(this.ids.length == 0) return null;
		return this.ids[index];
	};
	this.contains = function (id)
	{
		for(var i=0; i<this.ids.length; i++)
		{
			if( id == this.ids[i]) return true;
		}
		return false;
	};
	this.size = function ()
	{
		return this.ids.length;
	};
	this.toString = function()
	{
		return this.ids.join(",");
	}
}

/* 可以按ID查询的表 */
function AfMap()
{
	this.array = [];
	
	this.put = function(id, obj)
	{
		/* 检查重复, 如果已经存在直接替换 */
		for(var i=0; i<this.array.length;i++)
		{
			var e = this.array[i];
			if(e.id == id) 
			{
				e.obj = obj;
				return;
			}
		}
		/* 添加新的项 */
		var e = {};
		e.id = id;
		e.obj = obj;
		this.array.push( e );
	};
	
	this.get = function(id)
	{
		for(var i=0; i<this.array.length;i++)
		{
			var e = this.array[i];
			if(e.id == id) 
				return e.obj;
		}
		return null;
	};
	
	/* 遍历 : callback: 如果要continue就return true, 否则返回false */
	this.each = function ( callback )
	{
		for(var i=0; i<this.array.length;i++)
		{
			var e = this.array[i];
			if(false == callback (e.id, e.obj ) ) break;
		}
	};
	
	this.remove = function ( id )
	{
		for(var i=0; i<this.array.length;i++)
		{
			var e = this.array[i];
			if(e.id == id)
				this.array.splice(i, 1);
		}
	};
	
	this.size = function()
	{
		return this.array.length;
	};
	
	this.clear = function()
	{
		this.array = [];
	};
	
	this.values = function()
	{
		var values = [];
		for(var i=0; i<this.array.length;i++)
		{
			var e = this.array[i];
			values.push(e.obj);
		}
		return values;
	};
	this.ids = function()
	{
		var result = [];
		for(var i=0; i<this.array.length;i++)
		{
			var e = this.array[i];
			result.push(e.id);
		}
		return result;
	};
}

Af.indexOf = function(value, array)
{
	for(var i=0; i<array.length; i++)
	{
		if(array[i] == value) return i;
	}
	return -1;
};
Af.indexOf2 = function(value, strlist)
{
	var array = strlist.split(",");
	var v1 = value + ""; // 转成字符串
	for(var i=0; i<array.length; i++)
	{
		var v2 = array[i] + "";
		if(v1 == v2) return i;
	}
	return -1;
};

/* 省略的名称显示 */
Af.shortName = function(title, N)
{
	if(title.length <= N) 
		return title;
	else 
		return title.substr(0,N) + "...";
};

/* 列表的选择 */
/* 显示用户的当前的选项: container:父级窗口, options:数组, 要设置为选中的项 */
Af.set_options = function( container, options)
{
	// 先清空所有选中项
	var boxes = $("[type='checkbox']", container);
	boxes.prop("checked",false);
	
	if(options==null) return;
	//var sss = options.split(",");
	
	var boxes = $("[type='checkbox']", container);
	for( var i=0; i<boxes.length; i++)
	{
		var box = $( boxes[i] );
		var id = box.attr("id1");
		if(Af.indexOf(id, options) >= 0)
		{
			box.prop("checked", true);
		}
	}
};	
/* 取得用户选中的项 */
Af.get_options = function( container)
{
	var options = [];
	var boxes = $("[type='checkbox']", container);
	for( var i=0; i<boxes.length; i++)
	{
		var box = $( boxes[i] );			
		if( box.prop("checked"))
		{
			var id = box.attr("id1");
			options.push (id);
		}
	}
	return options;
};	

Af.key_return = function(event, callback)
{
	if (event.keyCode==13) callback();
}
