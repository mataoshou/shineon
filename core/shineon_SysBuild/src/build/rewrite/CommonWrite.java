package build.rewrite;

import build.tool.BaseFileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonWrite {


    String sourcePath = "E:\\IdeaProjects\\shineon\\core\\shineon_db_user";


    List<String> m_list =new ArrayList(){
        {
            add("E:\\IdeaProjects\\shineon\\core\\shineon_api_uauth");
            add("E:\\IdeaProjects\\shineon\\core\\shineon_db_user");
            add("E:\\IdeaProjects\\shineon\\core\\shineon_server_uauth");

        }
    };

    String replacePath = "src\\main\\java\\com\\shineon\\coder\\common\\util";

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
        write.replace();;
    }
}
