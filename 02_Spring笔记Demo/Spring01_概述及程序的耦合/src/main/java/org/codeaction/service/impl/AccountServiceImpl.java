package org.codeaction.service.impl;

import org.codeaction.dao.IAccountDao;
import org.codeaction.factory.BeanFactory;
import org.codeaction.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
