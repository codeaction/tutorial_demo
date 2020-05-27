package org.codeaction.dao.impl;

import org.codeaction.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl1 implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("222222222222222222222222");
    }
}
