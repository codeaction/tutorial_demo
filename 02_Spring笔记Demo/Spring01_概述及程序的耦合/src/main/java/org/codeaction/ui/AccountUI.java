package org.codeaction.ui;

import org.codeaction.factory.BeanFactory;
import org.codeaction.service.IAccountService;

public class AccountUI {
    public static void main(String[] args) {
        IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }
}
