package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.kernel.common.feign.FeignBuild;
import com.shineon.coder.kernel.constant.ServerConstant;

public class AllBuildTool {

    public static void main(String[] args) throws Exception {

//        ConvertBuild tool = new ConvertBuild();
//        tool.buildConvert();

        FeignBuild feignBuild =new FeignBuild();
        feignBuild.build("matao", ServerConstant.SHINEON_DB_USER);

//        ActionBuild build = new ActionBuild();
//        build.build("matao", ShineonUserCommonUtil.class, RmtUserInfo.class);


    }
}
