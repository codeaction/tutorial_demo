package org.codeaction.service.impl;

import org.codeaction.dao.IAccountDao;
import org.codeaction.domain.Account;
import org.codeaction.service.IAccountService;
import org.codeaction.util.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = null;

        try {
            //1.开启事务
            JdbcUtils.beginTransaction();
            //2.操作
            list = accountDao.findAll();
            //3.提交事务
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public Account findById(Integer id) {
        Account account = null;

        try {
            //1.开启事务
            JdbcUtils.beginTransaction();
            //2.操作
            account = accountDao.findById(id);
            //3.提交事务
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return account;
    }

    @Override
    public void save(Account account) {
        try {
            //1.开启事务
            JdbcUtils.beginTransaction();
            //2.操作
            accountDao.save(account);
            //3.提交事务
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void update(Account account) {
        try {
            //1.开启事务
            JdbcUtils.beginTransaction();
            //2.操作
            accountDao.update(account);
            //3.提交事务
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            //1.开启事务
            JdbcUtils.beginTransaction();
            //2.操作
            accountDao.delete(id);
            //3.提交事务
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, Float money) {
        try {
            //1.开启事务
            JdbcUtils.beginTransaction();
            //2.操作
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
            //3.提交事务
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
