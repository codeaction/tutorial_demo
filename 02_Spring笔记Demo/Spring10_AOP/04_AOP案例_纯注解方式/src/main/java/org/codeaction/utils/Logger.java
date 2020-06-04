package org.codeaction.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution(* org.codeaction.service.impl.*.*(..))")
    private void pt(){}

    //@Before("pt()")
    public void beforePrintLog() {
        System.out.println("beforePrintLog....");
    }

    //@AfterReturning("pt()")
    public void AfterReturningPrintLog() {
        System.out.println("AfterReturningPrintLog....");
    }

    //@AfterThrowing("pt()")
    public void AfterThrowingPrintLog() {
        System.out.println("AfterThrowingPrintLog....");
    }

    //@After("pt()")
    public void AfterPrintLog() {
        System.out.println("AfterPrintLog....");
    }

    @Around("pt()")
    public Object AroundPrintLog(ProceedingJoinPoint pjt) {
        Object returnValue = null;
        try {
            //获取参数
            Object[] args = pjt.getArgs();
            //调用业务层代码
            System.out.println("前置通知...");
            returnValue = pjt.proceed();
            System.out.println("后置通知...");
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("异常通知...");
        } finally {
            System.out.println("最终通知...");
        }

        return returnValue;
    }
}
