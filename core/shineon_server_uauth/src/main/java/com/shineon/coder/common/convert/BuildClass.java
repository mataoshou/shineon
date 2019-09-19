package com.shineon.coder.common.convert;

import com.shineon.coder.common.util.ClassBuildUtil;
import com.shineon.coder.constant.ConvertsConstant;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class BuildClass {

	String tab ="	";


	public void buildUtil(String className,File root,String baseName) throws Exception
	{

		System.out.println(String.format("开始构建路径 %s 的 基础文件 %s",root.getPath(),className));
		String fileName = className +".java";

		ClassBuildUtil classBuildUtil = new ClassBuildUtil();

		String[] annos =new String[]{"Component"};

		classBuildUtil.classInit(className,baseName, ConvertsConstant.UTIL_PACKAGE ,annos,true,
				String.format("%s.%s;", ConvertsConstant.BASE_PACKAGE,baseName),"org.springframework.stereotype.Component");


		File classFile = new File(root,fileName);

		classBuildUtil.finish(classFile);
		System.out.println("构建完成");
	}


	public void buildBase(String className,File root,String pojo,List<MapperItem> items) throws Exception
	{
		
		System.out.println(String.format("开始构建路径 %s 的 基础文件 %s",root.getPath(),className));
		String fileName = className +".java";



		ClassBuildUtil classBuildUtil = new ClassBuildUtil();

		classBuildUtil.classInit(className,null, ConvertsConstant.BASE_PACKAGE,null,true,
				"java.util.Date;", String.format("%s.%s;", ConvertsConstant.POJO_PACKAGE,pojo), ConvertsConstant.CONVERT_PACKAGE+".CommonData;");

		////////添加packagename;


		baseToCommon(pojo,items,classBuildUtil);

		commonToBase(pojo,items,classBuildUtil);


		File classFile = new File(root,fileName);
		classFile.getParentFile().mkdirs();
		classBuildUtil.finish(classFile);

		System.out.println("构建完成");
	}
	
	public void baseToCommon(String pojoName, List<MapperItem> items , ClassBuildUtil classBuildUtil)
	{
		String content ="";

		String methodName = classBuildUtil.getLName(pojoName) +"ToCommon";

		classBuildUtil.addTabContent(String.format("public CommonData %s( %s item) {" ,methodName,pojoName));

		classBuildUtil.addTabRightContent(String.format("CommonData result = new CommonData();" ));

		for(MapperItem item:items)
		{
			if(item.commonName.length()>0) {
				String getMehod = classBuildUtil.getGetMethodName(item.pojoName);
				String setMethod = classBuildUtil.getSetMethodName(item.commonName);

				String str = String.format("result.%s(item.%s());", setMethod, getMehod);
				classBuildUtil.addTabContent(str);
			}
		}

		classBuildUtil.addTabContent("return result;");


		classBuildUtil.addTabLeftContent(String.format("}"));

	}


	public void commonToBase(String pojoName, List<MapperItem> items , ClassBuildUtil classBuildUtil)
	{
		String content ="";

		String methodName = "commonTo"+pojoName;

		classBuildUtil.addTabContent(String.format("public %s %s( CommonData item) {" ,pojoName,methodName));

		classBuildUtil.addTabRightContent(String.format("%s result = new %s();",pojoName,pojoName ));

		for(MapperItem item:items)
		{
			if(item.commonName.length()>0) {
				String getMehod = classBuildUtil.getGetMethodName(item.commonName);
				String setMethod = classBuildUtil.getSetMethodName(item.pojoName);

				String str = String.format("result.%s(item.%s());", setMethod, getMehod);
				classBuildUtil.addTabContent( str);
			}
		}

		classBuildUtil.addTabContent("return result;");


		classBuildUtil.addTabLeftContent(String.format("}"));
	}



}
