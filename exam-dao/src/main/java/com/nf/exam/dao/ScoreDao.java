package com.nf.exam.dao;

import com.nf.exam.entity.Score;
import com.nf.exam.entity.vo.ScoreVo;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 11:33
 */
public interface ScoreDao {

    //查询所有考生成绩信息
    List<ScoreVo> findUserExamInfo();
    //添加成绩
    int insertSelective(Score record);
}
