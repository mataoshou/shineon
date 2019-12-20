package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.common.cache.CacheFactory;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;

public class CacheBuildTool {

    public static void main(String[] args) throws Exception {
        CacheFactory factory = new CacheFactory();
        factory.delete("matao", RmtUserInfoCommonUtil.class, RmtUserInfo.class,null, SysConstant.CURRENT_SYS_NAME);
    }
}
