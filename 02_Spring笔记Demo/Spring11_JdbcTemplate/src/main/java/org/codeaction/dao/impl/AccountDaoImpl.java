package org.codeaction.dao.impl;

import org.codeaction.bean.Account;
import org.codeaction.dao.IAccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    @Override
    public Integer add(Account account) {
        Object[] args = {account.getName(), account.getMoney()};
        return getJdbcTemplate().update("insert into account(name, money) values(?, ?)", args);
    }

    @Override
    public Integer delete(Integer id) {
        return getJdbcTemplate().update("delete from account where id=?", id);
    }

    @Override
    public Integer update(Account account) {
        Object[] args = {account.getName(), account.getMoney(), account.getId()};
        return getJdbcTemplate().update("update account set name=?, money=? where id=?", args);
    }

    @Override
    public List<Account> findAll() {
        return getJdbcTemplate().query("select * from account",
                new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findById(Integer id) {
        List<Account> list = getJdbcTemplate().query("select * from account where id=?",
                new BeanPropertyRowMapper<Account>(Account.class), id);
        return list.size() != 0 ? list.get(0) : null;
    }

    @Override
    public List<Account> findByName(String name) {
        return getJdbcTemplate().query("select * from account where name like ?",
                new BeanPropertyRowMapper<Account>(Account.class), name);
    }

    @Override
    public Long count() {
        return getJdbcTemplate().queryForObject("select count(*) from account", Long.class);
    }
}
//public class AccountDaoImpl implements IAccountDao {
//    private JdbcTemplate template;
//
//    public void setTemplate(JdbcTemplate template) {
//        this.template = template;
//    }
//
//    @Override
//    public Integer add(Account account) {
//        Object[] args = {account.getName(), account.getMoney()};
//        return template.update("insert into account(name, money) values(?, ?)", args);
//    }
//
//    @Override
//    public Integer delete(Integer id) {
//        return template.update("delete from account where id=?", id);
//    }
//
//    @Override
//    public Integer update(Account account) {
//        Object[] args = {account.getName(), account.getMoney(), account.getId()};
//        return template.update("update account set name=?, money=? where id=?", args);
//    }
//
//    @Override
//    public List<Account> findAll() {
//        return template.query("select * from account",
//                new BeanPropertyRowMapper<Account>(Account.class));
//    }
//
//    @Override
//    public Account findById(Integer id) {
//        List<Account> list = template.query("select * from account where id=?",
//                new BeanPropertyRowMapper<Account>(Account.class), id);
//        return list.size() != 0 ? list.get(0) : null;
//    }
//
//    @Override
//    public List<Account> findByName(String name) {
//        return template.query("select * from account where name like ?",
//                new BeanPropertyRowMapper<Account>(Account.class), name);
//    }
//
//    @Override
//    public Long count() {
//        return template.queryForObject("select count(*) from account", Long.class);
//    }
//}
