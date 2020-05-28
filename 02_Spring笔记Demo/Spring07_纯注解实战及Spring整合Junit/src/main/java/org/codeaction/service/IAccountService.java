package org.codeaction.service;

import org.codeaction.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(Integer id);
    void save(Account account);
    void update(Account account);
    void delete(Integer id);
}
