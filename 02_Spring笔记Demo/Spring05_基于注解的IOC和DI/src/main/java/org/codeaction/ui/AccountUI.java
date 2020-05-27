package org.codeaction.ui;

import org.codeaction.dao.IAccountDao;
import org.codeaction.service.IAccountService;
import org.codeaction.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountUI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        IAccountDao accountDao = (IAccountDao) context.getBean("accountDao");

        System.out.println(accountService);
        System.out.println(accountDao);

        accountService.saveAccount();
    }
}
