package com.nf.exam.dao;

import com.nf.exam.entity.Options;
import com.nf.exam.entity.vo.QuestionBankVo;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 19:28
 */
public interface QuestionBankDao {
    //查询所有题库
    public List<QuestionBankVo> findAllQuestionBank();

    //添加题目
    public int addQuestionBank(QuestionBankVo questionBankVo);

    //添加题目选项
    public int addOptions(List<Options> options);

    public int updateQuestionBankState(String value);

    //更新题目
    public int updateQuestionBank(QuestionBankVo questionBankVo);

    //删除题目的选项
    public int deleteQuestionBankOptions(String value);


}
