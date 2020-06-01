package org.codeaction.service;

import org.codeaction.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    List<Account> findAll() throws Exception;
    Account findById(Integer id) throws Exception;
    void save(Account account) throws Exception;
    void update(Account account) throws Exception;
    void delete(Integer id) throws Exception;
    void transfer(Integer srcId, Integer dstId, Float money) throws Exception;
}
