package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.kernel.common.feign.FeignBuild;
import com.shineon.coder.kernel.constant.ServerConstant;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;

import java.io.IOException;

public class FeignBuildTool {

    public static void main(String[] args) throws IOException {

        FeignBuild feignBuild =new FeignBuild();
        feignBuild.build("matao", ServerConstant.SHINEON_DB_USER);



    }
}
