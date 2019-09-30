package build.empty;

import build.tool.FileStore;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


/**
 * 快速  生成新项目
 *包括  公共区域代码拷贝  参数预配置
 * 尽量做到最少修改
 */
public class BuildEmptyProject {



    public static void main(String[] args) throws Exception {
        System.out.println("....................begin");
        BuildEmptyProject buildEmptyProject = new BuildEmptyProject();
//        buildEmptyProject.initPath();

        buildEmptyProject.buildNewSys("shineon_web_user");
    }


    String baseName = "shineon_api_empty";
    private  File root =  new File("E:\\IdeaProjects\\shineon\\core\\");

    public void buildNewSys(String sysName) throws Exception {
        if(!root.exists())
        {
            throw new Exception(root.getPath() + "根路径不存在，请检查！！");
        }

        File base = new File(root,baseName);

        if(!base.exists())
        {
            throw new Exception(baseName +"基础包不存在！！");
        }

        File dst = new File(root,sysName);
        createNewSys(base,dst,baseName,sysName);
    }

    public void createNewSys(File base,File dst,String baseName,String sysName) throws Exception {

        if(dst.exists())
        {
            throw new Exception(dst.getPath() + "目标目录已存在,请检查系统名称，是否正确！！");
        }
        FileUtils.copyDirectory(base,dst);

        File srcIml = new File(dst,baseName+".iml");
        File dstIml = new File(dst,sysName+".iml");

        if(srcIml.exists())
        {
            FileUtils.moveFile(srcIml,dstIml);
            System.out.println("修改iml文件！！");
        }

        String [] fileNames = new String[]{"compiler.xml","modules.xml","workspace.xml"};

        File idea = new File(dst,".idea");

        for(String str : fileNames)
        {
            File file = new File(idea,str);
            if(file.exists())
            {
                String content = FileStore.getContent(file,"UTF-8");
                content = content.replace(baseName,sysName);

                FileStore.putString(file,content,"UTF-8");

            }
        }
    }

    public void initPath()
    {
        File file = new File("shineon_base_empty");

        showPath(file);

    }

    public void showPath(File file)
    {
        System.out.println(file.getPath());
        if(file.isDirectory()) {

            File[] fs = file.listFiles();
            for(File f:fs)
            {
                showPath(f);
            }
        }
    }
}
