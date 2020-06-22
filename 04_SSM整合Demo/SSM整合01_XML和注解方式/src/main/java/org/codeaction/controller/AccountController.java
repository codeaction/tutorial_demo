package org.codeaction.controller;

import org.codeaction.bean.Account;
import org.codeaction.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/accounts")
    public String findAll(Model m) {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
        m.addAttribute("accounts", accounts);
        return "success";
    }

    @RequestMapping("/postTest")
    public String postTest(String username) {
        System.out.println(username);
        return "success";
    }
}
