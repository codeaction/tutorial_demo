package org.codeaction.controller;

import org.codeaction.bean.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnnotiationController {
    /**
     * 测试RequestParam注解，有两个请求参数
     * username从浏览器传过来的名称为name
     * 可以没有age参数
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username, @RequestParam(value = "age", required = false) Integer age) {
        System.out.println(username);
        System.out.println(age);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String accountStr) {
        System.out.println(accountStr);
        return "success";
    }

    @RequestMapping("/testRequestBody1")
    public String testRequestBody1(@RequestBody Account account) {
        System.out.println(account);
        return "success";
    }

    @RequestMapping(value = "/testPathVariable/account/{id}", method = RequestMethod.GET)
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "success";
    }
}
