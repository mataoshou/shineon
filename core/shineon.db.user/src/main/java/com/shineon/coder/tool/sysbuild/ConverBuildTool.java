package com.shineon.coder.tool.sysbuild;


import com.shineon.coder.kernel.common.convert.ConvertFactory;

public class ConverBuildTool {

    /**
     * 快速生成 公共对象和pojo的转换
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ConvertFactory factory = new ConvertFactory();
        factory.build();
//        tool.buildConvert();


        //全部重新生成
//        tool.overrideBuild();
    }
}
