package com.nf.exam.controller;

import com.nf.exam.entity.TestPaper;
import com.nf.exam.entity.vo.QuestionBankVo;
import com.nf.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/9 19:35
 */
@Controller
@RequestMapping(value = "/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        List<TestPaper> allTestPaper =  examService.findAllTestPaper();
        modelAndView.addObject("allTestPaper",allTestPaper);
        modelAndView.setViewName("exam/index");
        return modelAndView;
    }
    /**
     * 试卷模板映射
     * @return
     */
    @RequestMapping(value = "/exam-{id}.html", method = RequestMethod.GET)
    public ModelAndView exam(@PathVariable String id, HttpSession session) {


        ModelAndView modelAndView = new ModelAndView();
        examService.findJudgmentQuestionAndChoiceQuestion(modelAndView, id, session);
        return modelAndView;
    }

    /**
     * 提交试卷自动改卷
     * @param questionBankVos
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submitpapers", method = RequestMethod.POST)
    public List<QuestionBankVo> submitPapers(@RequestBody List<QuestionBankVo> questionBankVos, HttpSession session) {

        List<QuestionBankVo> judgmentSystem = examService.JudgmentSystem(questionBankVos, session);

        return judgmentSystem;
    }

    /**
     * 试卷模板映射
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/autoGenerate", method = RequestMethod.POST)
    public boolean autoGenerate(HttpSession session, TestPaper testPaper) {

        boolean autoGenerate = examService.autoGenerate(session, testPaper.getTestpaperId());

        return autoGenerate;
    }


}
