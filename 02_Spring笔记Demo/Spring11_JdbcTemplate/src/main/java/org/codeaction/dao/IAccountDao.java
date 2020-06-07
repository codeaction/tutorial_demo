package org.codeaction.dao;

import org.codeaction.bean.Account;

import java.util.List;

public interface IAccountDao {
    Integer add(Account account);
    Integer delete(Integer id);
    Integer update(Account account);
    List<Account> findAll();
    Account findById(Integer id);
    List<Account> findByName(String name);
    Long count();
}
