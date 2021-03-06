<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>


	<body>
		<script src="jquery"></script>


		<div class="sys-top-oper" style="background: #00F7DE; height: 100px; width: 700px;margin-left: 400px;margin-bottom:5px;padding: 30px;padding-top: 10px;;">
			<div style="background: #C0C4CC;width: 690px;height: 30px;; padding-left: 20px;margin-bottom: 10px;padding-top: 4px;;">选择生成内容</div>
			<span style="width: 200px;display: inline-block;height: 30px;"> 选择操作类型:  </span>
			<select class="sys-type" style="width: 150px;height: 30px;">
				<option value="1">api接口</option>
				<option value="2">Feign</option>
				<option value="3">数据库构建</option>
				<option value="4">convert构建</option>
				<option value="5">缓存构建</option>
			</select>
		</div>

		<div class="sys-center-show" style="background: #00F7DE;height: 180px; width: 700px;margin-left: 400px;margin-bottom:5px;padding: 30px;padding-top: 10px;">
			<div style="background: #C0C4CC;width: 690px;height: 30px;; padding-left: 20px;margin-bottom: 10px;padding-top: 4px;">选择生成参数</div>


			<div class="dto-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> dto类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-dto">


				</select>
			</div>


			<div class="util-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> commonUtils类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-util">


				</select>
			</div>


			<div class="pojo-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> pojo类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo">


				</select>
			</div>


			<div class="sys-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 系统名称选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-name">


				</select>
			</div>

			<div class="method-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 函数列表:  </span>

				<input  style="width: 350px;height: 30px;" class="class-method" value="get,edit,list"/>

			</div>
		</div>

		<div class="sys-center-oper" style="background:#00F7DE;height: 200px; width: 700px;margin-left: 400px;margin-bottom:5px;padding: 30px;padding-top: 10px;">
			<div style="background: #C0C4CC;width: 690px;height: 30px;; padding-left: 20px;margin-bottom: 10px;padding-top: 4px;">生成对象</div>

			<label>名称：</label>
			<input class = "build-name" style="width: 150px; height: 30px;;" />
			<input type="button" value="生成" onclick="MT.sys_build()" />

		</div>

		<script>
			$(function(){
				MT.init_center(1);
				$(".sys-type").change(function(){
					var val = $(".sys-type").val();
					MT.change_center(val);
				})
			})


			MT={};

			MT.init_center = function(val)
			{
				MT.init_center_show(val);
				MT.init_center_oper(val);
				MT.change_center(val);
			}

			MT.selects = [".sys-dto",".sys-util",".sys-pojo",".sys-name"];
			MT.urls = ["/sys/list/dto","/sys/list/commonUtil","/sys/list/pojo","/sys/list/sysName"];
			MT.build_urls = ["/sys/oper/api","/sys/oper/feign","/sys/oper/db","/sys/oper/convert","/sys/oper/cache"]

			MT.init_center_show = function(val)
			{
				for(var j=0;j<MT.selects.length;j++)
				{
					MT.api(MT.urls[j],function(data,carrys){
						var vals = data.datas;
						//alert(selects[carrys]  + ".." +carrys);
						for(var i=0;i<vals.length;i++)
						{
							$(MT.selects[carrys]).append("<option value='" + vals[i].id + "'>"+vals[i].title+"</option>");
						}

					},{},j);
				}
			}


			MT.sys_build = function()
			{
				var val = $(".sys-type").val();

				var req ={};
				req.name = $(".build-name").val();
				req.commonName = $(".sys-util").val();
				req.pojoName = $(".sys-pojo").val();
				req.sysName = $(".sys-name").val();
				req.methods = $(".class-method").val();
				req.dtoName = $(".sys-dto").val();

				MT.api(MT.build_urls[val/1-1],function(data){

					if(data.errorStatus==0)
					{
						alert("生成成功！！")
					}
					else
					{
						alert(data.errorReason)
					}


				},req);
			}

			MT.init_center_oper = function(val)
			{


			}


			MT.change_center = function(val)
			{
				if(val==1)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","none");
					$(".method-content").css("display","block");
					$(".dto-content").css("display","none");
				}
				else  if(val==2)
				{
					$(".util-content").css("display","none");
					$(".pojo-content").css("display","none");
					$(".sys-content").css("display","block");
					$(".method-content").css("display","none");
					$(".dto-content").css("display","none");
				}
				else  if(val==3)
				{
					$(".util-content").css("display","none");
					$(".pojo-content").css("display","none");
					$(".sys-content").css("display","none");
					$(".method-content").css("display","none");
					$(".dto-content").css("display","none");
				}
				else  if(val==4)
				{
					$(".util-content").css("display","none");
					$(".pojo-content").css("display","none");
					$(".sys-content").css("display","none");
					$(".method-content").css("display","none");
					$(".dto-content").css("display","none");
				}
				else  if(val==5)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","none");
					$(".method-content").css("display","none");
					$(".dto-content").css("display","none");
				}
			}
			
			MT.build_center_show = function(val)
			{
				//$(".sys-center-show").html("");
				
			}
			
			
			
			MT.build_center_oper = function(val)
			{
				//$(".sys-center-oper").html("");
				
			}
			
			MT.api =function(url,success,data,carrys){
				$.ajax({
		            type: "post",
		            url: url,
		            data : JSON.stringify(data),
		            contentType : "application/json",
		            success: function(result) {
		                success(result,carrys);
		            },error:function(xmlcontent,reason,e)
		            {
		            	alert(reason)
		            }
		        });
			}
		</script>
	</body>

	
</html>