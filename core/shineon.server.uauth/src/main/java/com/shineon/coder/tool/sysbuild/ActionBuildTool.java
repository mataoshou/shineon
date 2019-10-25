package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.kernel.common.action.ActionBuild;
import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;

import java.io.IOException;

public class ActionBuildTool {

    public static void main(String[] args) throws IOException {
        ActionBuild build = new ActionBuild();
        build.build("matao", ShineonUserCommonUtil.class, ShineonUser.class);
    }
}
