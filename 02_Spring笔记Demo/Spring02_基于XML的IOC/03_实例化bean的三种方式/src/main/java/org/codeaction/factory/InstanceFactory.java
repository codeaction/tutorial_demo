package org.codeaction.factory;

import org.codeaction.service.IAccountService;
import org.codeaction.service.impl.AccountServiceImpl;

/**
 * 模拟一个实例工厂，创建业务层实现类
 * 此工厂创建对象，必须现有工厂实例对象，再调用方法
 */
public class InstanceFactory {
    public IAccountService createAccountService(){
        return new AccountServiceImpl();
    }
}
