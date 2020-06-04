package org.codeaction.service.impl;

import org.codeaction.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    @Override
    public void save() {
        System.out.println("save...");
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
