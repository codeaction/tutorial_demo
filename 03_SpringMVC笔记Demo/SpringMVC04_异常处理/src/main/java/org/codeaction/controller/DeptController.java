package org.codeaction.controller;

import org.codeaction.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController {

    //用来测试全局异常处理
    @RequestMapping("/test2")
    public String test2(boolean flag) throws MyException {
        System.out.println("test2...");
        if (flag == false) {
            throw new MyException("test2...");
        }
        return "success";
    }
}
