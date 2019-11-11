package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.kernel.common.feign.FeignBuild;
import com.shineon.coder.kernel.constant.ServerConstant;

import java.io.IOException;

public class FeignBuildTool {

    public static void main(String[] args) throws IOException {

        FeignBuild feignBuild =new FeignBuild();
        feignBuild.build("user", ServerConstant.SHINEON_SERVER_UAUTH);



    }
}
