package build.sys.rebuild;

import java.io.File;

public class ReBuild {

    public static void main(String[] args) {
        String[] source = {"shineon.api.uauth","shineon.base.user","shineon.db.user","shineon.empty","shineon.eurake","shineon.server.uauth","shineon.web","shineon.zuul"};
        String[] dst    = {"mt.api.uauth","mt.base.user","mt.db.user","mt.empty","mt.eurake","mt.server.uauth","mt.web","mt.zuul"};


        String[] reSource ={"shineon","SHINEON"};
        String[] reDst    ={"mt","MT"};

        BuildNewProject newProject = new BuildNewProject();

        ReplaceProject replaceProject = new ReplaceProject();

        File rootSource =  new File("E:\\shineon.frame\\core\\");
        File rootDst =  new File("E:\\shineon.frame\\core\\");

        for(int i=0;i<source.length;i++)
        {
            try {
                newProject.buildNewSys(source[i],dst[i],rootSource,rootDst);
                replaceProject.replaceName(reSource,reDst,dst[i],rootDst);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
