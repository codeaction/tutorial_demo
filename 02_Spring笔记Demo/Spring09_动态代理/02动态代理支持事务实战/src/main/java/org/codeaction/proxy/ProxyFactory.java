package org.codeaction.proxy;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class ProxyFactory {
    private Object targetObject;
    private BeforeAdvice beforeAdvice;
    private AfterAdvice afterAdvice;
    private ActAdvice actAdvice;

    public ActAdvice getActAdvice() {
        return actAdvice;
    }

    public void setActAdvice(ActAdvice actAdvice) {
        this.actAdvice = actAdvice;
    }

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

    public Object createProxyObject() {

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class[] interfaces = this.targetObject.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object resultValue = null;

                try {
                    if(beforeAdvice != null) {
                        beforeAdvice.before();
                    }
                    resultValue = method.invoke(targetObject, args);
                    if(afterAdvice != null) {
                        afterAdvice.after();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if(actAdvice != null) {
                        actAdvice.act();
                    }
                }
                return resultValue;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
