package org.codeaction.ui;

import org.codeaction.dao.IAccountDao;
import org.codeaction.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountUI {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //2.根据id获取Bean对象，这个id是在bean标签中配置的id
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        IAccountDao accountDao = context.getBean("accountDao", IAccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);
        accountService.saveAccount();
    }
}
