package com.nf.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/6 12:01
 */
@Controller
public class IndexController {
@RequestMapping(value = "/index.html")
    public ModelAndView index(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
}
}
