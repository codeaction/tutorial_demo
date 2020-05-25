package org.codeaction.test;

import org.codeaction.domain.Account;
import org.codeaction.service.IAccountService;
import org.codeaction.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    private IAccountService accountService;
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        accountService = context.getBean("accountService", AccountServiceImpl.class);
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        Account account = accountService.findById(3);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("abc");
        account.setMoney(10000F);

        accountService.save(account);

        System.out.println(account);
    }

    @Test
    public void testDelete() {
        accountService.delete(4);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(5);
        account.setName("ab111111111c111");
        account.setMoney(10000F);
        accountService.update(account);
    }
}
