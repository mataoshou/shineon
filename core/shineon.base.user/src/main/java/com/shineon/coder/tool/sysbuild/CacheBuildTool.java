package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.MqMessage;
import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.common.cache.CacheBuild;
import com.shineon.coder.service.convert.util.MqMessageCommonUtil;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;

import java.io.IOException;

public class CacheBuildTool {

    public static void main(String[] args) throws IOException {
        CacheBuild cacheBuild = new CacheBuild();
        cacheBuild.build("UserById", RmtUserInfoCommonUtil.class, RmtUserInfo.class);
    }
}
