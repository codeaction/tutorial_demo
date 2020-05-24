package org.codeaction.factory;

import org.codeaction.service.IAccountService;
import org.codeaction.service.impl.AccountServiceImpl;

/**
 * 模拟一个静态工厂，创建业务层实现类
 */
public class StaticFactory {
    public static IAccountService  createAccountService() {
        return new AccountServiceImpl();
    }
}
