package org.codeaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    //转发
    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("testForward...");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    //重定向
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("testRedirect");
        return "redirect:/testString";
    }
}
