package org.codeaction.jdbctemplate;


import org.codeaction.bean.Account;
import org.codeaction.dao.IAccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TestDao {
    @Autowired
    private IAccountDao accountDao;

    @Test
    public void testAdd() {
        Account account = new Account();
        account.setName("John");
        account.setMoney(100F);
        Integer result = accountDao.add(account);
        System.out.println(result);
    }

    @Test
    public void testDel() {
        Integer result = accountDao.delete(1);
        System.out.println(result);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(13);
        account.setName("Tom");
        account.setMoney(1000F);
        Integer result = accountDao.update(account);
        System.out.println(result);
    }

    @Test
    public void testFindAll() {
        List<Account> list = accountDao.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testFindById() {
        Account account = accountDao.findById(14);
        System.out.println(account);
    }

    @Test
    public void testFindByName() {
        List<Account> list = accountDao.findByName("%Tom%");
        list.forEach(System.out::println);
    }

    @Test
    public void testCount() {
        Long count = accountDao.count();
        System.out.println(count);
    }
}
