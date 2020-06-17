package org.codeaction.controller;

import org.codeaction.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello...");
        return "success";
    }
}
