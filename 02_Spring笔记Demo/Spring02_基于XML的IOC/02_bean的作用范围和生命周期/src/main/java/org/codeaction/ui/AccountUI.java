package org.codeaction.ui;

import org.codeaction.dao.IAccountDao;
import org.codeaction.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountUI {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //2.根据id获取Bean对象，这个id是在bean标签中配置的id
        IAccountService accountService1 = (IAccountService) context.getBean("accountService");
        IAccountDao accountDao1 = (IAccountDao) context.getBean("accountDao");
        IAccountService accountService2 = (IAccountService) context.getBean("accountService");
        IAccountDao accountDao2 = (IAccountDao) context.getBean("accountDao");

        System.out.println("accountDao1 == accountDao2 ? " + (accountDao1 == accountDao2));
        System.out.println("accountService1 == accountService2 ? " + (accountService1 == accountService2));
        //容器销毁
        context.close();
    }
}
