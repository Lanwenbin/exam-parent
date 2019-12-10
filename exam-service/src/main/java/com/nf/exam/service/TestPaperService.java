package com.nf.exam.service;

import com.nf.exam.entity.TestPaper;
import com.nf.exam.entity.vo.QuestionBankVo;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/5 20:21
 */

public interface TestPaperService {
    //查询所有有效试卷
    List<TestPaper> findTestPaperInfo();
    //更改试卷状态
    int updateTestPaperState(int testpaperId);
    //根据id查询试卷信息
    TestPaper selectByPrimaryKey(Integer testpaperId);

    //编辑试卷信息
    int updateTestPaperInfo(TestPaper testPaper);

    //查询所有题库
    public List<QuestionBankVo> findAllQuestionBank();
}
