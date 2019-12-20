package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.sql.pojo.RmtOrganizationInfo;
import com.shineon.coder.kernel.common.action.ActionFactory;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtOrganizationInfoCommonUtil;

public class ActionBuildTool {

    public static void main(String[] args) throws Exception {
        ActionFactory factory = new ActionFactory();
        factory.delete("matao", RmtOrganizationInfoCommonUtil.class,
                RmtOrganizationInfo.class,ActionConstant.ACTION_METHOD, SysConstant.CURRENT_SYS_NAME);


    }
}
