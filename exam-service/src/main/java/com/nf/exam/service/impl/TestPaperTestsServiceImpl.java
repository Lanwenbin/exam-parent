package com.nf.exam.service.impl;

import com.nf.exam.dao.TestPaperTestsDao;
import com.nf.exam.entity.TestPaperTests;
import com.nf.exam.entity.TestPaperTestsList;
import com.nf.exam.entity.vo.TestPaperTestsVo;
import com.nf.exam.service.TestPaperTestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/5 20:23
 */
@Service
public class TestPaperTestsServiceImpl implements TestPaperTestsService {

    @Autowired
    private TestPaperTestsDao testPaperTestsDao;
    @Override
    public List<TestPaperTestsVo> findSelectTestPaperQuesion(int testpaperId) {
       return testPaperTestsDao.findSelectTestPaperQuesion(testpaperId);
    }

    @Override
    public int deleteTestPaperTestById(int testpaperId) {
        return testPaperTestsDao.deleteTestPaperTestById(testpaperId);
    }

    @Override
    public int addTestPaperQuestion(TestPaperTestsList testPaperTestsList) {
        //new一个 List<试卷题目>
        List<TestPaperTests> testPaperTests = new ArrayList<TestPaperTests>();
        //遍历题目id
        for (Integer id : testPaperTestsList.getQuestionBankId()) {
            //每遍历一次就new一个试卷题目对象
            TestPaperTests paperTests = new TestPaperTests();
            //写入题目id
            paperTests.setQuestionBankId(id);
            //写入试卷的id
            paperTests.setTestpaperId(testPaperTestsList.getTestpaperId());
            //把试卷题目添加到试卷里
            testPaperTests.add(paperTests);
        }
        return testPaperTestsDao.addTestPaperQuestion(testPaperTests);

    }
}
