package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.RmtUserInfo;
import com.shineon.coder.kernel.common.message.MessageFactory;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;

public class MessageBuildTool {


    /**
     * 快速生成mq的消息通道
     */
    public static void main(String[] args) throws Exception {
        MessageFactory factory = new MessageFactory();
        factory.build("privilege123", RmtUserInfoCommonUtil.class, RmtUserInfo.class,null, SysConstant.CURRENT_SYS_NAME);
    }
}
