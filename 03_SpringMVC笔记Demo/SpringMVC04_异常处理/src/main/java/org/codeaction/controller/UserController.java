package org.codeaction.controller;

import org.codeaction.exception.MyException;
import org.codeaction.exception.MyJSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    /**
     * 控制器内部异常处理，只能处理本控制器内部的MyException
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public String handleRuntimeException(MyException e) {
        System.out.println("MyException----UserController内部异常处理...");
        return "error";
    }

    //用来测试控制器内部异常处理
    @RequestMapping("/test1")
    public String test1(boolean flag) throws MyException {
        System.out.println("test1...");
        if (flag == false) {
            throw new MyException("test1...");
        }
        return "success";
    }

    //用来测试异常处理，返回JSON数据
    @RequestMapping("/test3")
    public String test3(boolean flag) throws MyJSONException {
        System.out.println("test3..." + flag);
        if (flag == false) {
            throw new MyJSONException("test3...");
        }
        return "success";
    }
}
