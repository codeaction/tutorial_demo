package org.codeaction.bean;

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
