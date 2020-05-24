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
        IAccountService accountService1 = (IAccountService) context.getBean("accountService1");
        IAccountService accountService2 = (IAccountService) context.getBean("accountService2");
        IAccountService accountService3 = (IAccountService) context.getBean("accountService3");

        System.out.println(accountService1);
        System.out.println(accountService2);
        System.out.println(accountService3);
    }
}
