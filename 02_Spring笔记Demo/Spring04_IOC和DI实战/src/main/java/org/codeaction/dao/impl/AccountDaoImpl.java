package org.codeaction.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.codeaction.dao.IAccountDao;
import org.codeaction.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = null;
        try {
            list = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Account findById(Integer id) {
        Account account = null;
        try {
            account = queryRunner.query("select * from account where id = ?",
                    new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void save(Account account) {
        Object[] params = {account.getName(), account.getMoney()};
        try {
            queryRunner.update("insert into account(name, money) values(?, ?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        Object[] params = {account.getName(), account.getMoney(), account.getId()};
        try {
            queryRunner.update("update account set name=?, money=? where id=?", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        Object[] params = {id};
        try {
            queryRunner.update("delete from account where id=?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
