package org.codeaction.service.impl;

import org.codeaction.bean.Account;
import org.codeaction.dao.IAccountDao;
import org.codeaction.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void trans(Integer srcId, Integer dstId, Float money) {
        Account src = accountDao.findById(srcId);
        Account dst = accountDao.findById(dstId);

        if(src == null) {
            throw new RuntimeException("转出用户不存在");
        }

        if(dst == null) {
            throw new RuntimeException("转入用户不存在");
        }

        if(src.getMoney() < money) {
            throw new RuntimeException("转出账户余额不足");
        }

        src.setMoney(src.getMoney() - money);
        dst.setMoney(dst.getMoney() + money);

        accountDao.update(src);

        //int x = 1/0;

        accountDao.update(dst);
    }
}
