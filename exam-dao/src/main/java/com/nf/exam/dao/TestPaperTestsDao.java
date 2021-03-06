package com.nf.exam.dao;

import com.nf.exam.entity.TestPaperTests;
import com.nf.exam.entity.vo.TestPaperTestsVo;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/5 20:06
 */
public interface TestPaperTestsDao {
    //根据试卷id查询试卷试题

    List<TestPaperTestsVo> findSelectTestPaperQuesion(Integer testpaperId);

    //根据试卷id删除试卷试题表信息

    int deleteTestPaperTestById(int testpaperId);

    //添加试卷试题
    int addTestPaperQuestion(List<TestPaperTests> list);
}
