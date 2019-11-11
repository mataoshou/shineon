package com.shineon.coder.action;

import com.shineon.coder.kernel.constant.SysConstant;
import com.shineon.coder.service.convert.BasicCommonUtil;
import com.shineon.coder.service.convert.CommonItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ActionExceptionHandler {

    @Autowired
    BasicCommonUtil commonUtil;

    Logger logger = LoggerFactory.getLogger(SysConstant.CURRENT_SYS_NAME);
    @ResponseBody
    @ExceptionHandler
    public CommonItem processEx(Exception ex){

        String errorReason =String.format("[%s]服务异常：%s", SysConstant.CURRENT_SYS_NAME,ex.getMessage());

        logger.info(String.format("[%s]服务异常：%s (%s)", SysConstant.CURRENT_SYS_NAME,ex.getMessage(), ex.getStackTrace()[0]));
        ex.printStackTrace();

        return commonUtil.fail(errorReason);
    }
}
