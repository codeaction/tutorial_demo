package org.codeaction.controller;

import org.codeaction.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @RequestMapping("/testJSON")
    @ResponseBody
    public User testJSON(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
