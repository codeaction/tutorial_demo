package org.codeaction.exception;

/**
 * 自定义异常
 */
public class MyException extends Exception{

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
    }
}
