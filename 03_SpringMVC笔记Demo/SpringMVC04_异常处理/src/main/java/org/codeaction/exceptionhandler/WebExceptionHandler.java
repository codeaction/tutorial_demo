package org.codeaction.exceptionhandler;

import org.codeaction.bean.Resp;
import org.codeaction.exception.MyException;
import org.codeaction.exception.MyJSONException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class WebExceptionHandler {
    /**
     * 全局异常处理，处理MyException
     * @param e
     * @return 返回ModelAndView
     */
    @ExceptionHandler(MyException.class)
    public ModelAndView handleRuntimeException(MyException e) {
        System.out.println("MyException----全局异常处理...");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("msg", e.getMessage());

        return mv;
    }

    /**
     * 全局异常处理，处理MyJSONException
     * @param e
     * @return 返回JSON
     */
    @ExceptionHandler(MyJSONException.class)
    @ResponseBody
    public Resp handleMyJSONException(MyJSONException e) {
        Resp resp = new Resp();
        resp.setMsg(e.getMessage());

        return resp;
    }
}
