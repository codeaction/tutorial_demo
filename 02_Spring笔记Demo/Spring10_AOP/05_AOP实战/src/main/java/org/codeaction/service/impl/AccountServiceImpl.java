package org.codeaction.service.impl;

import org.codeaction.dao.IAccountDao;
import org.codeaction.domain.Account;
import org.codeaction.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() throws Exception {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) throws Exception {
        return accountDao.findById(id);
    }

    @Override
    public void save(Account account) throws Exception {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) throws Exception {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer id) throws Exception {
        accountDao.delete(id);
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, Float money) throws Exception {
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
