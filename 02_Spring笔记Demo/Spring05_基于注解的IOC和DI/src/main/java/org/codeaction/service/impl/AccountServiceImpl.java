package org.codeaction.service.impl;

import org.codeaction.dao.IAccountDao;
import org.codeaction.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Value("hello world")
    private String test;
    @Value("100")
    private int num;

    //@Autowired
    //@Qualifier("accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;
    @Override
    public void saveAccount() {
        System.out.println(this.test);
        System.out.println(this.num);
        accountDao.saveAccount();
    }
}
