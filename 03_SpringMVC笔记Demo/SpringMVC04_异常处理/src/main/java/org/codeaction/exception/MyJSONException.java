package org.codeaction.exception;

/**
 * 自定义异常
 */
public class MyJSONException extends Exception{

    public MyJSONException() {
    }

    public MyJSONException(String message) {
        super(message);
    }
}
