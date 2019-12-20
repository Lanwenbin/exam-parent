package com.nf.exam.controller;

import com.github.pagehelper.PageInfo;
import com.nf.exam.entity.vo.QuestionBankVo;
import com.nf.exam.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/5 9:21
 */
@Controller
@RequestMapping("/admin")
public class QuestionBankController {
@Autowired
    private QuestionBankService questionBankService;
    /**
     * 映射主页模板
     */
    @RequestMapping(value = "/question-bank.html")
    public ModelAndView questionBank() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin/question-bank");
        return modelAndView;
    }

    @RequestMapping(value = "/judge-bank.html")
    public ModelAndView judgeBank() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin/judge-bank");
        return modelAndView;
    }

    /**
     * 获取所有实体
     * 因为返回json类型，所以加@ResponseBody
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllQuestionBank")
    public PageInfo<QuestionBankVo> getAllQuestionBank(@RequestBody PageInfo<QuestionBankVo> pageInfo) {


        PageInfo<QuestionBankVo> findAllQuestionBank = questionBankService.findAllQuestionBankById(pageInfo,1);

        return findAllQuestionBank;
    }

    /**
     * 获取所有实体
     * 因为返回json类型，所以加@ResponseBody
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllJudgeBank")
    public PageInfo<QuestionBankVo> getAllJudgeBank(@RequestBody PageInfo<QuestionBankVo> pageInfo) {


        PageInfo<QuestionBankVo> findAllQuestionBank = questionBankService.findAllQuestionBankById(pageInfo,0);

        return findAllQuestionBank;
    }

    /**
     * 添加题目
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addquestionbank")
    public boolean addQuestionBank(@RequestBody QuestionBankVo questionBankVo) {

        //添加题目
        boolean addQuestionBank = questionBankService.addQuestionBank(questionBankVo);

        return addQuestionBank;

    }

    /**
     *删除题目
     * @param questionBankVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletequestionbank")
    public boolean deleteQuestionBank(@RequestBody QuestionBankVo questionBankVo) {


        boolean deleteQuestionBankState = questionBankService.deleteQuestionBank(questionBankVo.getQuestionBankId().toString());

        return deleteQuestionBankState;
    }

    /**
     * 修改题目
     * @param questionBankVo
     * @param id 题目id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatequestionbank-{id}")
    public boolean updateQuestionBank(@RequestBody QuestionBankVo questionBankVo, @PathVariable String id) {
        questionBankVo.setQuestionBankId(Integer.parseInt(id));
        boolean updateQuestionBank = questionBankService.updateQuestionBank(questionBankVo);
        return updateQuestionBank;
    }
}
