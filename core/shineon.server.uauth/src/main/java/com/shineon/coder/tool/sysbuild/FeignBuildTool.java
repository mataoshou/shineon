package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.RmtPrivilegeInfo;
import com.shineon.coder.kernel.common.feign.FeignFactory;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtPrivilegeInfoCommonUtil;

public class FeignBuildTool {

    public static void main(String[] args) throws Exception {
        FeignFactory factory =new FeignFactory("matao", RmtPrivilegeInfoCommonUtil.class, RmtPrivilegeInfo.class, FeignConstant.FEIGN_METHOD, SysConstant.CURRENT_SYS_NAME);
        factory.delete();
    }
}
