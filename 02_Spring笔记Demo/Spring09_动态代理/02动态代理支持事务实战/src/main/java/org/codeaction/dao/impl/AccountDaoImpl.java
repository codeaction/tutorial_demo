package org.codeaction.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.codeaction.dao.IAccountDao;
import org.codeaction.domain.Account;
import org.codeaction.util.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        String sql = "select * from account";
        List<Account> list = queryRunner.query(conn, sql, new BeanListHandler<Account>(Account.class));
        return list;
    }

    @Override
    public Account findById(Integer id) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        String sql = "select * from account where id = ?";
        Account account = queryRunner.query(conn, sql, new BeanHandler<Account>(Account.class), id);
        return account;
    }

    @Override
    public void save(Account account) throws SQLException {
        Object[] params = {account.getName(), account.getMoney()};
        Connection conn = JdbcUtils.getConnection();
        String sql = "insert into account(name, money) values(?, ?)";
        queryRunner.update(conn, sql, params);
    }

    @Override
    public void update(Account account) throws SQLException {
        Object[] params = {account.getName(), account.getMoney(), account.getId()};
        Connection conn = JdbcUtils.getConnection();
        String sql = "update account set name=?, money=? where id=?";
        queryRunner.update(conn, sql, params);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Object[] params = {id};
        Connection conn = JdbcUtils.getConnection();
        String sql = "delete from account where id=?";
        queryRunner.update(conn, sql, id);
    }
}
