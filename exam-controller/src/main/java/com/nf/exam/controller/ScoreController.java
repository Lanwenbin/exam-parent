package com.nf.exam.controller;

import com.nf.exam.entity.vo.ScoreVo;
import com.nf.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 11:45
 */
@Controller
@RequestMapping("/admin")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value="/score.html",method = RequestMethod.GET)
    public ModelAndView findUserExamInfo(){
        List<ScoreVo> listScore=scoreService.findUserExamInfo();
        System.out.println("---------------------");
        System.out.println(listScore);
        System.out.println("---------------------");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listScore", listScore);
        modelAndView.setViewName("admin/score");
        return modelAndView;
    }
}
