package org.codeaction.dao.impl;

import org.codeaction.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("账户保存成功");
    }
}
