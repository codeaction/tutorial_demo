package org.codeaction.controller;

import org.codeaction.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ResultController {
    @RequestMapping("/testString")
    public String testString() {
        System.out.println("hello...");
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("void...");
        //1.转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //2.重定向
        //response.sendRedirect(request.getContextPath() + "/testString");
        //3.向浏览器返回数据
        PrintWriter out = response.getWriter();
        out.println("hahahahaha....");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        //创建User对象
        User user = new User();
        user.setName("Tom");
        user.setAge(10);

        //在request域中存放名为user的对象
        mv.addObject("user", user);
        //设置逻辑视图名称
        mv.setViewName("success");

        //返回ModelAndView
        return mv;
    }
}
