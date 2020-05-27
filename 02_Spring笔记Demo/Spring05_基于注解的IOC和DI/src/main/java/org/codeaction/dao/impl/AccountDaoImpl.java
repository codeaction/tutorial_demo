package org.codeaction.dao.impl;

import org.codeaction.dao.IAccountDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("11111111111111111111111111111");
    }
}
