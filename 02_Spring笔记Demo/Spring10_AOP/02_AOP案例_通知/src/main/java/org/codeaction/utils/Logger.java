package org.codeaction.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的类，这些都是公共代码
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("beforePrintLog....");
    }

    /**
     * 后置通知
     */
    public void AfterReturningPrintLog() {
        System.out.println("AfterReturningPrintLog....");
    }

    /**
     * 异常通知
     */
    public void AfterThrowingPrintLog() {
        System.out.println("AfterThrowingPrintLog....");
    }

    /**
     * 最终通知
     */
    public void AfterPrintLog() {
        System.out.println("AfterPrintLog....");
    }

    /**
     * 环绕通知
     */
    public Object AroundPrintLog(ProceedingJoinPoint pjt) {
        Object returnValue = null;
        try {
            System.out.println("前置通知...");
            //获取参数
            Object[] args = pjt.getArgs();
            //调用业务层代码
            returnValue = pjt.proceed(args);
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
