package com.shineon.coder.action;

import com.shineon.coder.kernel.constant.ServerNameConstant;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.CommonItemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ActionExceptionHandler {

    CommonItemUtils utils = new CommonItemUtils(){};

    Logger logger = LoggerFactory.getLogger( ServerNameConstant.CURRENT_SYS);
    @ResponseBody
    @ExceptionHandler
    public CommonItem processEx(Exception ex){

        String errorReason =String.format("[%s]服务异常：%s", ServerNameConstant.CURRENT_SYS,ex.getMessage());

        logger.info(String.format("[%s]服务异常：%s (%s)", ServerNameConstant.CURRENT_SYS,ex.getMessage(), ex.getStackTrace()[0]));
        ex.printStackTrace();

        return utils.fail(errorReason);
    }
}
