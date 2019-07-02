package com.shineon.coder.tool.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class BuildApi {

	String tab ="	";


	public void buildUtil(String packageName,String className,File root,String baseName) throws Exception
	{

		System.out.println(String.format("开始构建路径 %s 的 基础文件 %s",root.getPath(),className));
		String fileName = className +".java";

		String content = "";
		int tab_no=0;

		////////添加packagename;
		content += getContent(tab_no,tab, String.format("package %s ;",packageName));
		content += getContent(tab_no,tab, String.format(""));
		/////////添加import
		content += getContent(tab_no,tab, String.format("import com.shineon.coder.tool.convert.base.%s;",baseName));

		content += getContent(tab_no,tab, String.format(""));
		////////构建class内容
		content += getContent(tab_no,tab, String.format("public class %s extends %s {",className,baseName));

		content += getContent(--tab_no,tab, String.format("}"));

		File classFile = new File(root,fileName);
		FileOutputStream out = new FileOutputStream(classFile);
		out.write(content.getBytes("UTF-8"));
		out.close();
		System.out.println("构建完成");
	}


	public void buildBase(String packageName,String className,File root,String pojo,List<MapperItem> items) throws Exception
	{
		
		System.out.println(String.format("开始构建路径 %s 的 基础文件 %s",root.getPath(),className));
		String fileName = className +".java";

		String content = "";
		int tab_no=0;

		////////添加packagename;
		content += getContent(tab_no,tab, String.format("package %s ;",packageName));
		content += getContent(tab_no,tab, String.format(""));
		/////////添加import
		content += getContent(tab_no,tab, String.format("import java.util.Date;"));
		content += getContent(tab_no,tab, String.format("import com.shineon.coder.db.pojo.%s;",pojo));
		content += getContent(tab_no,tab, String.format("import com.shineon.coder.tool.convert.CommonItem;"));

		content += getContent(tab_no,tab, String.format(""));
		////////构建class内容
		content += getContent(tab_no,tab, String.format("public class %s {",className));
		content += getContent(tab_no,tab, String.format(""));


		tab_no++;
		content+=baseToCommon(pojo,items,tab_no);

		content+=commonToBase(pojo,items,tab_no);
		tab_no--;

		content += getContent(tab_no,tab, String.format(""));
		content += getContent(--tab_no,tab, String.format("}"));
		
		File classFile = new File(root,fileName);
		FileOutputStream out = new FileOutputStream(classFile);
		out.write(content.getBytes("UTF-8"));
		out.close();
		System.out.println("构建完成");
	}
	
	public String baseToCommon(String pojoName, List<MapperItem> items , int tab_no)
	{
		String content ="";

		String methodName = getLName(pojoName) +"ToCommon";

		content += getContent(tab_no,tab, String.format("public CommonItem %s( %s item) {" ,methodName,pojoName));

		tab_no++;

		content += getContent(tab_no,tab, String.format("CommonItem result = new CommonItem();" ));

		for(MapperItem item:items)
		{
			String getMehod = getGetMethodName(item.pojoName);
			String setMethod = getSetMethodName(item.commonName);

			String str = String.format("result.%s(item.%s());",setMethod,getMehod);
			content +=getContent(tab_no,tab,str);
		}

		content +=getContent(tab_no,tab,"return result;");

		tab_no--;

		content += getContent(tab_no,tab, String.format("}"));

		return  content;
	}


	public String commonToBase(String pojoName, List<MapperItem> items , int tab_no)
	{
		String content ="";

		String methodName = "commonTo"+pojoName;

		content += getContent(tab_no,tab, String.format("public %s %s( CommonItem item) {" ,pojoName,methodName));

		tab_no++;

		content += getContent(tab_no,tab, String.format("%s result = new %s();",pojoName,pojoName ));

		for(MapperItem item:items)
		{
			String getMehod = getGetMethodName(item.commonName);
			String setMethod = getSetMethodName(item.pojoName);

			String str = String.format("result.%s(item.%s());",setMethod,getMehod);
			content +=getContent(tab_no,tab,str);
		}

		content +=getContent(tab_no,tab,"return result;");

		tab_no--;

		content += getContent(tab_no,tab, String.format("}"));

		return  content;
	}


	//获取属性的get方法
	public String getGetMethodName(String valueName)
	{
		char first = Character.toUpperCase(valueName.charAt(0));
		StringBuffer methodName = new StringBuffer("get" + valueName);
		methodName.setCharAt(3, first);

		return methodName.toString();
	}
	//获取属性的set方法
	public String getSetMethodName(String valueName)
	{
		char first = Character.toUpperCase(valueName.charAt(0));
		StringBuffer methodName = new StringBuffer("set" + valueName);
		methodName.setCharAt(3, first);

		return methodName.toString();
	}

	public String getLName(String name)
	{
		char first = Character.toLowerCase(name.charAt(0));
		StringBuffer rName = new StringBuffer(name);
		rName.setCharAt(0, first);
		return  rName.toString();
	}
	
	private String getContent(int tab_no,String tab,String content)
	{
		String tabs="";
		for(int i=0;i<tab_no;i++)
		{
			tabs+=tab;
		}
		return tabs+content+"\r\n";
	}
}
