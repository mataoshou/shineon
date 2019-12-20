package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.kernel.common.generator.GeneratorFactory;

public class PojoBuildTool {
    public static void main(String[] args) throws Exception {
        GeneratorFactory factory = new GeneratorFactory();
//        sql.build();


//        全部重新生成
        factory.build();
    }

}
