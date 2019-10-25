package com.shineon.coder.tool.sysbuild;

public class MessageBuild {


    /**
     * 快速生成mq的消息通道
     */
    public static void main(String[] args) throws Exception {
        com.shineon.coder.kernel.common.message.MessageBuild messageBuild = new com.shineon.coder.kernel.common.message.MessageBuild();
        messageBuild.buildMessage("userNotice");
    }
}
