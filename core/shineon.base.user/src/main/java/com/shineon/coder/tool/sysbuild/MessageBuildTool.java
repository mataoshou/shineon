package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.kernel.common.message.MessageBuild;

public class MessageBuildTool {


    /**
     * 快速生成mq的消息通道
     */
    public static void main(String[] args) throws Exception {
        MessageBuild messageBuild = new MessageBuild();
        messageBuild.buildMessage("privilege");
    }
}
