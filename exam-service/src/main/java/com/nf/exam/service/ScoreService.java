package com.nf.exam.service;

import com.nf.exam.entity.vo.ScoreVo;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 11:41
 */
public interface ScoreService {
    //查询所有考生成绩信息
    List<ScoreVo> findUserExamInfo();


}
