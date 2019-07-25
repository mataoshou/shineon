package com.shineon.coder.common.convert;

import com.shineon.coder.common.util.ClassBuildUtil;
import com.shineon.coder.constant.ConvertsConstant;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class BuildClass {

	String tab ="	";

	ClassBuildUtil buildUtil = new ClassBuildUtil();




	public void buildUtil(String className,File root,String baseName) throws Exception
	{

		System.out.println(String.format("开始构建路径 %s 的 基础文件 %s",root.getPath(),className));
		String fileName = className +".java";

		ClassBuildUtil classBuildUtil = new ClassBuildUtil();

		String[] annos =new String[]{"Component"};

		String fileConent = classBuildUtil.classInit(className,baseName, ConvertsConstant.UTIL_PACKAGE,annos,true,
				String.format("%s.%s;",ConvertsConstant.BASE_PACKAGE,baseName),"org.springframework.stereotype.Component");

		String content ="";
		fileConent = fileConent.replace("##1",content);

		File classFile = new File(root,fileName);
		FileOutputStream out = new FileOutputStream(classFile);
		out.write(fileConent.getBytes("UTF-8"));
		out.close();
		System.out.println("构建完成");
	}


	public void buildBase(String className,File root,String pojo,List<MapperItem> items) throws Exception
	{
		
		System.out.println(String.format("开始构建路径 %s 的 基础文件 %s",root.getPath(),className));
		String fileName = className +".java";



		ClassBuildUtil classBuildUtil = new ClassBuildUtil();

		String fileConent = classBuildUtil.classInit(className,null,ConvertsConstant.BASE_PACKAGE,null,true,
				"java.util.Date;", String.format("%s.%s;",ConvertsConstant.POJO_PACKAGE,pojo),ConvertsConstant.CONVERT_PACKAGE+".CommonItem;");

		////////添加packagename;


        String content = "";
        int tab_no=1;
		tab_no++;
		content+=baseToCommon(pojo,items,tab_no);

		content+=commonToBase(pojo,items,tab_no);
		tab_no--;


		fileConent = fileConent.replace("##1",content);
		File classFile = new File(root,fileName);
		classFile.getParentFile().mkdirs();
		FileOutputStream out = new FileOutputStream(classFile);
		out.write(fileConent.getBytes("UTF-8"));
		out.close();
		System.out.println("构建完成");
	}
	
	public String baseToCommon(String pojoName, List<MapperItem> items , int tab_no)
	{
		String content ="";

		String methodName = buildUtil.getLName(pojoName) +"ToCommon";

		content += buildUtil.getContent(tab_no,tab, String.format("public CommonItem %s( %s item) {" ,methodName,pojoName));

		tab_no++;

		content += buildUtil.getContent(tab_no,tab, String.format("CommonItem result = new CommonItem();" ));

		for(MapperItem item:items)
		{
			if(item.commonName.length()>0) {
				String getMehod = buildUtil.getGetMethodName(item.pojoName);
				String setMethod = buildUtil.getSetMethodName(item.commonName);

				String str = String.format("result.%s(item.%s());", setMethod, getMehod);
				content += buildUtil.getContent(tab_no, tab, str);
			}
		}

		content +=buildUtil.getContent(tab_no,tab,"return result;");

		tab_no--;

		content += buildUtil.getContent(tab_no,tab, String.format("}"));

		return  content;
	}


	public String commonToBase(String pojoName, List<MapperItem> items , int tab_no)
	{
		String content ="";

		String methodName = "commonTo"+pojoName;

		content += buildUtil.getContent(tab_no,tab, String.format("public %s %s( CommonItem item) {" ,pojoName,methodName));

		tab_no++;

		content += buildUtil.getContent(tab_no,tab, String.format("%s result = new %s();",pojoName,pojoName ));

		for(MapperItem item:items)
		{
			if(item.commonName.length()>0) {
				String getMehod = buildUtil.getGetMethodName(item.commonName);
				String setMethod = buildUtil.getSetMethodName(item.pojoName);

				String str = String.format("result.%s(item.%s());", setMethod, getMehod);
				content += buildUtil.getContent(tab_no, tab, str);
			}
		}

		content +=buildUtil.getContent(tab_no,tab,"return result;");

		tab_no--;

		content += buildUtil.getContent(tab_no,tab, String.format("}"));

		return  content;
	}



}
