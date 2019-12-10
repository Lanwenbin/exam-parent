package com.nf.exam.time;

import com.nf.exam.dao.ExamDao;
import com.nf.exam.dao.ScoreDao;
import com.nf.exam.entity.Score;
import com.nf.exam.entity.Times;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/9 19:29
 */
public class ExamTask {

    @Autowired
    private ExamDao examDao;
    @Autowired
    private ScoreDao scoreDao;

    /**
     * 更新考试时间
     */
    public void updateTime() {
        //所有用户时间
        List<Times> allExamTimes = examDao.findAllExamTimes();
        //更新用户时间-1分钟
        for (Times times : allExamTimes) {
            Double dataMin = times.getDataMin();
            dataMin--;
            times.setDataMin(dataMin);
            examDao.updateExamTimes(times);
            /**
             * 时间到。更新时间如果没成绩设置0分
             */
            if (dataMin == -1) {
                Score score = new Score();
                score.setUsersId(times.getUserId());
                score.setTestpaperId(times.getTestpaperId());
                Score ifExistenceScore = examDao.findIfExistenceScore(score);
                if (ifExistenceScore == null) {//如果空 设置成绩0分
                    Score record = new Score();
                    record.setTestpaperId(times.getTestpaperId());
                    record.setUsersId(times.getUserId());
                    record.setFraction(0.0);
                    scoreDao.insertSelective(record);
                }
                //更新考试时间无效
                times.setTimesState(0);
                examDao.updateExamTimes(times);
            }



        }

    }
}
