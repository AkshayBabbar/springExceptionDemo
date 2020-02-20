package com.example.springException.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/add")
    public String add() {
        int num = 10 / 0;
        return "add";
    }

    @RequestMapping("/update")
    public String update(){
        String check = null;
        String toLowerCase  = check.toLowerCase();

        return "update";
    }


    @ExceptionHandler(value = {java.lang.NullPointerException.class})
        public ModelAndView handleNullAccess(Exception e){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("Exception",e.toString());
            modelAndView.setViewName("nullAccess");
            return modelAndView;

        }


    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Exception",e.toString());

        modelAndView.setViewName("MathError");
        return modelAndView;

    }

}
