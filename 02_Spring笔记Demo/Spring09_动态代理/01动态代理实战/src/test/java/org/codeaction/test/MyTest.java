package org.codeaction.test;


import org.codeaction.proxy.*;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyTest {
    @Test
    public void TestProxy() {
        //目标对象
        IWaiter manWaiter = new ManWaiter();

        /**
         * 三个参数，用来创建代理对象
         */
        ClassLoader loader = this.getClass().getClassLoader();
        Class[] interfaces = {IWaiter.class};
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object resultValue = null;

                System.out.println("你好...");
                resultValue = method.invoke(manWaiter, args);//调用目标对象的目标方法
                System.out.println("再见...");
                return resultValue;
            }
        };
        //得到代理对象，代理对象就是在目标对象的基础上进行了增强的对象
        IWaiter waiter = (IWaiter) Proxy.newProxyInstance(loader, interfaces, handler);
        //前面添加“您好”，　后面添加“再见”
        waiter.serve();
    }

    @Test
    public void testProxyFactory() {
        //创建工厂
        ProxyFactory factory = new ProxyFactory();
        //设置目标对象
        factory.setTargetObject(new ManWaiter());
        //设置前置增强
        factory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("你好...");
            }
        });
        //设置后置增强
        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("再见...");
            }
        });
        //创建代理对象
        IWaiter waiter = (IWaiter) factory.createProxyObject();
        //执行代理对象方法
        waiter.serve();
    }
}
