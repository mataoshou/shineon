package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.sql.pojo.RmtPrivilegeGroupInfo;
import com.shineon.coder.kernel.common.bo.BOFactory;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtPrivilegeGroupInfoCommonUtil;

public class BOBuildTool {

    public static void main(String[] args) throws Exception {
        BOFactory factory = new BOFactory();
        factory.delete("matao", RmtPrivilegeGroupInfoCommonUtil.class, RmtPrivilegeGroupInfo.class,null, SysConstant.CURRENT_SYS_NAME);
//        factory.build("matao", RmtPrivilegeGroupInfoCommonUtil.class, RmtPrivilegeGroupInfo.class,null, SysConstant.CURRENT_SYS_NAME);
    }
}
