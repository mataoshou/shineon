package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.kernel.common.rebuild.RebuildSys;

import java.io.IOException;

public class RebuildSysTool {

    public static void main(String[] args) throws IOException {
        RebuildSys rebuildSys = new RebuildSys();


        rebuildSys.rebuild("shineon.db.user");
    }
}
