package org.codeaction.service;

import org.codeaction.bean.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
}
