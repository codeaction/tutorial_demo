package org.codeaction.dao;

import org.codeaction.domain.Account;
import org.codeaction.domain.AccountUser;
import org.codeaction.domain.User;

import java.util.List;

public interface IAccountDao {
    List<AccountUser> findAll();
    List<Account> findAll1();
}
