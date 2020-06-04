package org.codeaction.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的类，这些都是公共代码
 */
public class Logger {
    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog() {
        System.out.println("printLog....");
    }
}
