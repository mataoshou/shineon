package com.shineon.coder.action;

import com.shineon.coder.db.common.ApiResultItem;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.BasicCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ActionExceptionHandler {

    @Autowired
    BasicCommonUtil utils;

    Logger logger = LoggerFactory.getLogger(SysConstant.CURRENT_SYS_NAME);
    @ResponseBody
    @ExceptionHandler
    public ApiResultItem processEx(Exception ex) throws Exception {

        String errorReason =String.format("[%s]异常：[%s]", SysConstant.CURRENT_SYS_NAME,ex.getMessage());

        logger.info(String.format("[%s]异常：[%s] (%s)", SysConstant.CURRENT_SYS_NAME,ex.getMessage(), ex.getStackTrace()[0]));
        ex.printStackTrace();

        return new ApiResultItem(utils.fail(errorReason),null);
    }
}
