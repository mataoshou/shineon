package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.common.action.ActionBuild;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;

import java.io.IOException;

public class ActionBuildTool {

    public static void main(String[] args) throws IOException {
        ActionBuild build = new ActionBuild();
        build.build("user", RmtUserInfoCommonUtil.class, RmtUserInfo.class);
    }
}
