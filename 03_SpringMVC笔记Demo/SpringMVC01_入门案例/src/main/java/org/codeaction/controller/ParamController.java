package org.codeaction.controller;

import org.codeaction.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ParamController {
    //测试绑定基本类型参数
    @RequestMapping("/testParam")
    public String testParam(String username, Float money) {
        System.out.println(username);
        System.out.println(money);
        return "success";
    }

    //测试绑定POJO类型参数
    @RequestMapping("/testParamPOJO")
    public String testParamPOJO(User user) {
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getBirthday());
        System.out.println(user.getList());
        System.out.println(user.getMap());
        return "success";
    }

    //测试使用ServletAPI
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }
}
