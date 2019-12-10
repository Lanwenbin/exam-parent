package com.nf.exam.dao;

import com.nf.exam.entity.TestPaper;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/5 19:36
 */
public interface TestPaperDao {
    //添加试卷
    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    //删除试卷
    int deleteByPrimaryKey(Integer testpaperId);
    //查询所有有效试卷
    List<TestPaper> findTestPaperInfo();

    TestPaper selectByPrimaryKey(Integer testpaperId);

    //更改试卷状态
    int updateTestPaperState(int testpaperId);
    //编辑试卷信息
    int updateTestPaperInfo(TestPaper testPaper);
}
