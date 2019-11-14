package build.sys.rebuild;

import build.tool.FileStore;
import org.apache.commons.io.FileUtils;

import java.io.File;


/**
 * 快速  生成新项目
 *包括  公共区域代码拷贝  参数预配置
 * 尽量做到最少修改
 */
public class BuildNewProject {



    public static void main(String[] args) throws Exception {
        System.out.println("....................begin");
        BuildNewProject buildEmptyProject = new BuildNewProject();
//        buildEmptyProject.initPath();

        String[] source = {"shineon.api.uauth","shineon.base.user","shineon.db.user","shineon.empty","shineon.eurake","shineon.server.uauth","shineon.web","shineon.zuul"};
        String[] dst    = {"mg.api.uauth","mg.base.user","mg.db.user","mg.empty","mg.eurake","mg.server.uauth","mg.web","mg.zuul"};

        File root =  new File("E:\\mg.frame\\core\\");
        buildEmptyProject.buildNewSys(source,dst,root,root);

        System.out.println("....................success");
    }


    public void buildNewSys(String[] sourceName,String[] dstName,File rootSource,File rootDst) throws Exception {
        for(int i=0;i<sourceName.length;i++)
        {
            buildNewSys(sourceName[i],dstName[i],rootSource,rootDst);
        }
    }


    public void buildNewSys(String sourceName,String dstName,File rootSource,File rootDst) throws Exception {
        if(!rootSource.exists())
        {
            throw new Exception(rootSource.getPath() + "根路径不存在，请检查！！");
        }

        File source = new File(rootSource,sourceName);

        if(!source.exists())
        {
            throw new Exception(sourceName +"基础包不存在！！");
        }

        File dst = new File(rootDst,dstName);
        createNewSys(source,dst,sourceName,dstName);
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
}
