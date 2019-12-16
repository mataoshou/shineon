package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.sql.pojo.RmtOrganizationInfo;
import com.shineon.coder.kernel.common.action.ActionBuild;
import com.shineon.coder.service.convert.util.RmtOrganizationInfoCommonUtil;

import java.io.IOException;

public class ActionBuildTool {

    public static void main(String[] args) throws IOException {
        ActionBuild build = new ActionBuild();
        build.build("organization", RmtOrganizationInfoCommonUtil.class, RmtOrganizationInfo.class);
    }
}
