package com.nf.exam.service.impl;

import com.nf.exam.dao.QuestionBankDao;
import com.nf.exam.dao.TestPaperDao;
import com.nf.exam.entity.TestPaper;
import com.nf.exam.entity.vo.QuestionBankVo;
import com.nf.exam.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/5 20:23
 */
@Service
public class TestPaperServiceImpl implements TestPaperService {

    @Autowired
    private TestPaperDao testPaperDao;
    @Autowired
    private QuestionBankDao questionBankDao;


    @Override
    public List<TestPaper> findTestPaperInfo() {
       return testPaperDao.findTestPaperInfo();
    }

    @Override
    public int updateTestPaperState(int testpaperId) {
        return testPaperDao.updateTestPaperState(testpaperId);
    }

    @Override
    public TestPaper selectByPrimaryKey(Integer testpaperId) {
        return testPaperDao.selectByPrimaryKey(testpaperId);
    }


    @Override
    public int updateTestPaperInfo(TestPaper testPaper) {
       return testPaperDao.updateTestPaperInfo(testPaper);
    }

    @Override
    public List<QuestionBankVo> findAllQuestionBank() {
        return questionBankDao.findAllQuestionBank();
    }
}
