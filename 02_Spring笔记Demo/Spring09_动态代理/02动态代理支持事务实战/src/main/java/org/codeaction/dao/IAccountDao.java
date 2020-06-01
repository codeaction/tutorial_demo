package org.codeaction.dao;

import org.codeaction.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {
    List<Account> findAll() throws SQLException;
    Account findById(Integer id) throws SQLException;
    void save(Account account) throws SQLException;
    void update(Account account) throws SQLException;
    void delete(Integer id) throws SQLException;
}
