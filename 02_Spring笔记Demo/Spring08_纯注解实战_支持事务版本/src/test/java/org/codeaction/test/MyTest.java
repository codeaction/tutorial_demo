package org.codeaction.test;

import org.codeaction.config.MyConfig;
import org.codeaction.domain.Account;
import org.codeaction.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class MyTest {
    @Autowired
    private IAccountService accountService;

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

    @Test
    public void testTrans() {
        accountService.transfer(1, 2, 10F);
    }
}
