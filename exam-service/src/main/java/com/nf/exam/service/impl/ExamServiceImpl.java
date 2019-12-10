package com.nf.exam.service.impl;

import com.nf.exam.dao.ExamDao;
import com.nf.exam.dao.ScoreDao;
import com.nf.exam.entity.Score;
import com.nf.exam.entity.TestPaper;
import com.nf.exam.entity.Times;
import com.nf.exam.entity.Users;
import com.nf.exam.entity.vo.QuestionBankVo;
import com.nf.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/9 11:29
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;
    @Autowired
    private ScoreDao scoreDao;
    @Override
    public List<TestPaper> findAllTestPaper() {

        List<TestPaper> allTestPaper = examDao.findAllTestPaper();
        return allTestPaper;
    }

    /**
     * 查询所有选择题判断题
     * @param modelAndView
     * @param id
     * @param session
     */
    @Override
    public void findJudgmentQuestionAndChoiceQuestion(ModelAndView modelAndView, String id, HttpSession session) {
        /**
         * 查询当前用户是否存在成绩，如果有成绩则返回 null
         */
        Score score = new Score();
        score.setTestpaperId(Integer.parseInt(id));
        Users users = (Users) session.getAttribute("myUser");
        score.setUsersId(users.getUserId());
        Score ifExistenceScore = examDao.findIfExistenceScore(score);
        if (ifExistenceScore != null) {
            modelAndView.addObject("Fraction", ifExistenceScore.getFraction());
            modelAndView.setViewName("exam/score");
            return;
        }
        //写入试卷的id
        session.setAttribute("testpaperId", id);

        //循环遍历判断题
        List<QuestionBankVo> findAllJudgmentQuestion = examDao.findAllJudgmentQuestion(Integer.parseInt(id));
        for (QuestionBankVo questionBankVo : findAllJudgmentQuestion) {
            //把题目答案存入session，用题目的id保存
            session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
        }
        //循环遍历选择题题
        List<QuestionBankVo> findAllChoiceQuestion = examDao.findAllChoiceQuestion(Integer.parseInt(id));
        for (QuestionBankVo questionBankVo : findAllChoiceQuestion) {
            //把题目答案存入session，用题目的id保存
            session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
        }

        //设置当前用户当前试卷的考试时间
        Times times = new Times();
        //用户id
        times.setUserId(users.getUserId());
        //试卷id
        times.setTestpaperId(Integer.parseInt(id));
        //考试时间
        Times ifExamTimes = examDao.findExamTimes(times);
        //如果考试时间未设置则进行设置
        if (ifExamTimes == null){
            times.setDataMin(60.0);
            examDao.addExamTimes(times);
            session.setAttribute("ExamTime","60");
        } else {
            session.setAttribute("ExamTime", String.valueOf(ifExamTimes.getDataMin().intValue()));
        }
        //选择判断题
        modelAndView.addObject("JudgmentQuestion", findAllJudgmentQuestion);
        modelAndView.addObject("ChoiceQuestion", findAllChoiceQuestion);
        modelAndView.setViewName("exam/exam");

    }

    /**
     * 自动改卷，得出成绩
     * @param questionBankVos
     * @param session
     * @return
     */
    @Override
    public List<QuestionBankVo> JudgmentSystem(List<QuestionBankVo> questionBankVos, HttpSession session) {
        double fraction = 0;
        //循环试卷题目
        for (QuestionBankVo questionBankVo : questionBankVos) {
            //如果答案不为空而且在session里的答案和字段里的一致就加10分(表示答对一题)
            if (questionBankVo.getAnswer() != null) {
                if (session.getAttribute(questionBankVo.getQuestionBankId().toString())
                        .equals(questionBankVo.getAnswer())) {
                    fraction = fraction + 10;
                    questionBankVo.setIfCorrect(true);
                } else {
                    //否则false并且把所选选项保存
                    questionBankVo.setIfCorrect(false);
                    questionBankVo
                            .setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
                }
            } else {
                questionBankVo.setIfCorrect(false);
                questionBankVo
                        .setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
            }
        }

        /**
         * 写入成绩
         */
        Score score = new Score();
        score.setTestpaperId(Integer.parseInt(session.getAttribute("testpaperId").toString()));
        score.setUsersId(((Users) session.getAttribute("myUser")).getUserId());
        score.setFraction(fraction);
        int insertSelective = scoreDao.insertSelective(score);
        // 设置分数是否成功
        if (insertSelective == 0) {
            return null;
        }
        // 返回状态
        return questionBankVos;

    }

    /**
     * 生成试卷
     * @param session
     * @param id
     * @return
     */
    @Override
    public boolean autoGenerate(HttpSession session, Integer id) {
        // 得到试卷的判断题
        List<QuestionBankVo> findAllJudgmentQuestion = examDao.findAllJudgmentQuestion(id);

        // 得到试卷的选择题
        List<QuestionBankVo> findAllChoiceQuestion = examDao.findAllChoiceQuestion(id);
        //如果选择判断题的题目数量大于等于5
        if (findAllJudgmentQuestion.size() >= 5 && findAllChoiceQuestion.size() >= 5) {
            HashMap<String, List<QuestionBankVo>> hashMap = new HashMap<String, List<QuestionBankVo>>();
            hashMap.put("JudgmentQuestion", findAllJudgmentQuestion);
            hashMap.put("ChoiceQuestion", findAllChoiceQuestion);
            session.setAttribute("question", hashMap);
          //  session.setAttribute("XiaoBing", "XiaoBingBy");
            session.setAttribute("JudgmentQuestion", findAllJudgmentQuestion);
            session.setAttribute("ChoiceQuestion", findAllChoiceQuestion);
            // 存入时间
            // 初始化成绩
            return true;
        }

        return false;
    }
}
