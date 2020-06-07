package org.codeaction.dao.impl;

import org.codeaction.bean.Account;
import org.codeaction.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public Integer add(Account account) {
        Object[] args = {account.getName(), account.getMoney()};
        return template.update("insert into account(name, money) values(?, ?)", args);
    }

    @Override
    public Integer delete(Integer id) {
        return template.update("delete from account where id=?", id);
    }

    @Override
    public Integer update(Account account) {
        Object[] args = {account.getName(), account.getMoney(), account.getId()};
        return template.update("update account set name=?, money=? where id=?", args);
    }

    @Override
    public List<Account> findAll() {
        return template.query("select * from account",
                new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findById(Integer id) {
        List<Account> list = template.query("select * from account where id=?",
                new BeanPropertyRowMapper<Account>(Account.class), id);
        return list.size() != 0 ? list.get(0) : null;
    }

    @Override
    public List<Account> findByName(String name) {
        return template.query("select * from account where name like ?",
                new BeanPropertyRowMapper<Account>(Account.class), name);
    }

    @Override
    public Long count() {
        return template.queryForObject("select count(*) from account", Long.class);
    }
}
