package org.codeaction.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这个类用来生成代理对象
 * 需要的参数：
 *  * 目标对象
 *  * 增强
 * 怎么用？
 *  1.创建代理工厂
 *  2.给工厂设置三样东西：
 *      * 目标对象：setTargetObject(xxx);
 *      * 前置增强：setBeforeAdvice(该接口的实现)
 *      * 后置增强：setAfterAdvice(该接口的实现)
 *  3.调用createProxy()得到代理对象
 *      * 执行代理对象方法时：
 *          > 执行BeforeAdvice的before()
 *          > 目标对象的目标方法
 *          > 执行AfterAdvice的after()
 */
public class ProxyFactory {
    private Object targetObject;//目标对象
    private BeforeAdvice beforeAdvice;//前置增强
    private AfterAdvice afterAdvice;//后置增强

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }

    //用来生成代理对象
    public Object createProxyObject() {
        //三大参数
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class[] interfaces = this.targetObject.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            //在调用代理对象的方法时会执行这里的内容
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object resultValue = null;

                if(beforeAdvice != null) {
                    //执行前置增强
                    beforeAdvice.before();
                }
                //执行目标对象的目标方法
                resultValue = method.invoke(targetObject, args);
                if(afterAdvice != null) {
                    //执行后置增强
                    afterAdvice.after();
                }
                //返回目标对象的返回值
                return resultValue;
            }
        };

        //得到代理对象
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
