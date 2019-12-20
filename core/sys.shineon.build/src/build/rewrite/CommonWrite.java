package build.rewrite;

import build.tool.BaseFileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonWrite {


    String sourcePath = "E:\\shineon.frame\\shineon\\core\\shineon.db.user";


    List<String> m_list =new ArrayList(){
        {
            add("E:\\shineon.frame\\shineon\\core\\shineon.db.user");
            add("E:\\shineon.frame\\shineon\\core\\shineon.base.user");
            add("E:\\shineon.frame\\shineon\\core\\shineon.server.uauth");
            add("E:\\shineon.frame\\shineon\\core\\shineon.api.uauth");

        }
    };

    String replacePath = "src\\main\\java\\com\\shineon\\coder\\kernel\\util\\BaseFileUtil.java";

    public void replace() throws IOException {

        File source = new File(sourcePath,replacePath);
        for(String root : m_list)
        {
            if(!root.equals(sourcePath))
            {
                File dst = new File(root,replacePath);
                BaseFileUtil.delete(dst);

                if(source.isDirectory()) {
                    FileUtils.copyDirectory(source,dst);
                }
                else {
                    FileUtils.copyFile(source,dst);
                }
                System.out.println("完成替换" + dst.getParent());
            }

        }

    }


    public static  void  main(String[] args) throws IOException {
        CommonWrite write = new CommonWrite();
        write.replace();
    }
}
