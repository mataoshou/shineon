package com.shineon.coder.kernel.common;

import java.io.File;

public class CommonTool {

    public File getSysPath(String packageName)
    {
        String sys = System.getProperty("user.dir");
        File coder = new File(sys, "src\\main\\java\\");

        File root = new File(coder,packageName.replace(".","\\"));

        return root;
    }
}
