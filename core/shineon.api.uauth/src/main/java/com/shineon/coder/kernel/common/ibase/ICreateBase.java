package com.shineon.coder.kernel.common.ibase;

import com.shineon.coder.kernel.common.CommonTool;
import com.shineon.coder.kernel.util.BaseFileUtil;
import com.shineon.coder.kernel.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 单文件生成类
 */
public abstract class ICreateBase {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public ICreateBase(String actionName, Class toolClass,
                       Class pojoClass, String[] methods, String sysName)
    {
        this.toolClass = toolClass;
        this.pojoClass= pojoClass;
        this.methods = methods;
        this.sysName = sysName;
        this.packageName = getPackageName();

        if(pojoClass!=null) {
            this.pojoClassName = pojoClass.getSimpleName();
        }
        if(toolClass!=null) {
            this.toolClassName = toolClass.getSimpleName();
        }
        if(isExitConstant()) {
            this.constantPackageName = getConstantPackageName();
        }

        isRewrite(false);
        initSys(actionName);

        classInit();
    }

    /**
     * 开始对象的生成
     */
    public void startCreate() throws IOException {
        if(!checkBeforBuild())
        {
            logger.info("生成失败，checkBeforBuild函数检查结果返回false，停止生成文件!!");
            return;
        }

        if(!isFinishInit())
        {
            logger.info("系统初始化失败，请检查是否有参数未完成初始化或生成文件已存在，停止生成文件!!");
            return;
        }

        logger.info("开始生成对象!!");
        createClass();
        createConstant();
        logger.info("完成对象生成!!");
    }

    /**
     * 检查是否结束初始化
     * @return
     */
    protected boolean isFinishInit()
    {
        if(packageName==null||packageName.length()<=0)
        {
            logger.info("packageName未初始化，请设置packageName!!");
            return false;
        }

        if(isExitConstant()&&(constantPackageName==null||constantPackageName.length()<=0))
        {
            logger.info("constantPackageName未初始化，请设置constantPackageName!!");

            return false;
        }

        if(!this.rewrite)
        {
            if(this.classFile.exists())
            {
                logger.info("文件已存在:" + this.classFile.getPath());
                return false;
            }

            if(isExitConstant()&&this.constantFile.exists())
            {
                logger.info("文件已存在:" +this.constantFile.getPath());
                return false;
            }
        }

        return true;
    }

    /**
     * 初始化
     * @param name
     */
    protected void initSys(String name){
        StringUtil stringUtil = new StringUtil();
        this.name = stringUtil.firstUpper(name);
        this.classFile = initFilePath(packageName,getClassName());
        if(isExitConstant()) {
            this.constantFile = initFilePath(constantPackageName, getConstantName());
        }
    }

    /**
     * 构建文件存放位置
     * @param packageName
     * @param fileName
     * @return
     */
    protected File initFilePath(String packageName,String fileName)
    {
        CommonTool tool = new CommonTool();

        File root = tool.getSysPath(packageName);
        if(!fileName.endsWith(getSuffix()))
        {
            fileName +="."+getSuffix();
        }
        return new File(root,fileName);
    }

    /**
     * 文件后缀
     * @return
     */
    protected String getSuffix()
    {
        return "java";
    }


    /**
     * 是否进行覆盖重写
     * @return
     */
    public void isRewrite(boolean rewrite){
        this.rewrite = rewrite;
    }


    /**
     * 删除已生成文件
     */
    public void deleteFile()
    {
        if(this.classFile.exists())
        {
            BaseFileUtil.delete(this.classFile);
        }

        if(isExitConstant()&&this.constantFile.exists())
        {
            BaseFileUtil.delete(this.constantFile);
        }
    }




    //////////////////////////////////抽象函数////////////////////////////////////////

    /**
     * 构建文件
     */
    protected abstract void createClass() throws IOException;

    /**
     * 构建常量文件
     */
    protected abstract void createConstant() throws IOException;

    /**
     * 生成前的检查
     * @return
     */
    protected abstract boolean checkBeforBuild();

    /**
     * 初始化
     */
    protected  abstract void classInit();

    /**
     * 获取类的包名
     * @return
     */
    protected abstract String getPackageName();

    /**
     * 是否使用常量类
     * @return
     */
    protected abstract boolean isExitConstant();

    /**
     * 设置常量类的包名
     * @return
     */
    protected abstract String getConstantPackageName();


    /**
     * 类名称
     * @return
     */
    protected abstract String getClassName();

    /**
     * 常量类名称
     * @return
     */
    protected abstract String getConstantName();


    ////////////////////////////////////全局变量//////////////////////////////////

    //包名
    protected String packageName;
    //常量包名
    protected  String constantPackageName;
    //对象名称
    protected String name;
    //工具类
    protected Class toolClass;
    //pojo类
    protected Class pojoClass;
    //生成方法
    protected String[] methods;
    //系统名称
    protected String sysName;


    //对象文件路径
    protected File classFile;
    //常量对象文件路径
    protected File constantFile;

    //是否允许重写
    boolean rewrite = false;


    protected String pojoClassName;

    protected String toolClassName;

}
