package org.codeaction.test;

import org.codeaction.bean.User1;
import org.codeaction.bean.User2;
import org.codeaction.bean.User3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //User1 user1 = (User1) context.getBean("user1");
        //System.out.println(user1);

        //User2 user2 = (User2) context.getBean("user2");
        //System.out.println(user2);

        User3 user3 = (User3)context.getBean("user3");
        user3.show();
    }
}
