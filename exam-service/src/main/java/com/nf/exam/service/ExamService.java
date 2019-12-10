package com.nf.exam.service;

import com.nf.exam.entity.TestPaper;
import com.nf.exam.entity.vo.QuestionBankVo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/9 11:08
 */
public interface ExamService {
    //查询所有开始考试试卷到前端
    public List<TestPaper> findAllTestPaper();

    //查询选择判断题
    public void findJudgmentQuestionAndChoiceQuestion(ModelAndView modelAndView, String id, HttpSession session);

    //判题系统
    public List<QuestionBankVo> JudgmentSystem(List<QuestionBankVo> questionBankVos, HttpSession session);

    //自动生成试卷
    public boolean autoGenerate(HttpSession session, Integer id);
}
