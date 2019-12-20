package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.common.feign.FeignFactory;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;

public class FeignBuildTool {

    public static void main(String[] args) throws Exception {
        FeignFactory factory =new FeignFactory();
        factory.delete("matao", RmtUserInfoCommonUtil.class, RmtUserInfo.class, FeignConstant.FEIGN_METHOD, SysConstant.CURRENT_SYS_NAME);
    }
}
