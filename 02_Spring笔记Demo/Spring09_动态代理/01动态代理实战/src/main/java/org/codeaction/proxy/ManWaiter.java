package org.codeaction.proxy;

//表示男服务员
public class ManWaiter implements IWaiter {
    @Override
    public void serve() {
        System.out.println("服务...");
    }
}
