package org.codeaction.bean;

/**
 * 自定义响应类，用于响应JSON数据
 */
public class Resp {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Resp{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
