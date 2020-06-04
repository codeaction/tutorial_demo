package org.codeaction.service.impl;

import org.codeaction.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Override
    public void save() {
        System.out.println("save...");
        //int i = 100 / 0;
    }

    @Override
    public void update(int i) {
        System.out.println("update...");
    }

    @Override
    public int delete() {
        System.out.println("delete...");
        return 0;
    }
}
