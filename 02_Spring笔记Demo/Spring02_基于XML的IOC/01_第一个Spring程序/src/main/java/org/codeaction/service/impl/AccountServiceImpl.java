package org.codeaction.service.impl;

import org.codeaction.dao.IAccountDao;
import org.codeaction.dao.impl.AccountDaoImpl;
import org.codeaction.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
