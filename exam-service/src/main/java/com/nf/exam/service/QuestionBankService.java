package com.nf.exam.service;

import com.github.pagehelper.PageInfo;
import com.nf.exam.entity.vo.QuestionBankVo;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 20:05
 */
public interface QuestionBankService {
    //查询所有试题
    public PageInfo<QuestionBankVo> findAllQuestionBankById(PageInfo<QuestionBankVo> pageInfo,Integer testsType);

    //添加题
    public boolean addQuestionBank(QuestionBankVo questionBankVo);

    //删除题目
    public boolean deleteQuestionBank(String questionBankId);

    //更新题目
    public boolean updateQuestionBank(QuestionBankVo questionBankVo);
}
