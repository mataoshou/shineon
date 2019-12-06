package com.shineon.coder.action;

import com.shineon.coder.kernel.constant.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerLog {

    @Pointcut("args(com.shineon.coder.service.convert.CommonItem)")
    public void params() {
    }

    @Pointcut("execution(* com.shineon.coder.action..*.*(..))")
    public void methods() {
    }

    @Pointcut("params() && methods()")
    private void actionLog(){

    }

    @Before("actionLog()")
    public void before(JoinPoint point) {
        log.info(String.format("action [%s] [%s] [%s] start execute", SysConstant.CURRENT_SYS_NAME, point.getTarget().getClass().getSimpleName(),point.getSignature().getName()));
    }

    @AfterReturning("actionLog()")
    public void after(JoinPoint point)
    {
        log.info(String.format("action [%s] [%s] [%s] finish execute", SysConstant.CURRENT_SYS_NAME, point.getTarget().getClass().getSimpleName(),point.getSignature().getName()));
    }
}
