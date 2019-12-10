package com.nf.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nf.exam.dao.QuestionBankDao;
import com.nf.exam.entity.Options;
import com.nf.exam.entity.vo.QuestionBankVo;
import com.nf.exam.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 20:07
 */
@Service
public class QuestionBankServiceImpl implements QuestionBankService {
    @Autowired
    private QuestionBankDao questionBankDao;

    /**
     * 查看题目
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo<QuestionBankVo> findAllQuestionBank(PageInfo<QuestionBankVo> pageInfo) {
        //初始化分页
        PageHelper.startPage(pageInfo.getPageNum()==0?1:pageInfo.getPageNum(), 40);

        List<QuestionBankVo> AllQuestionBank = questionBankDao.findAllQuestionBank();
            //限制条数
        PageInfo<QuestionBankVo> pageInfoQuestionBank = new PageInfo<QuestionBankVo>(AllQuestionBank);

        return pageInfoQuestionBank;
    }
    /**
     * 添加题目
     * @param questionBankVo
     * @return
     */

    @Override
    @Transactional

    public boolean addQuestionBank(QuestionBankVo questionBankVo) {
        //1有效，0删除
        questionBankVo.setState(1);
        int questionBankState = questionBankDao.addQuestionBank(questionBankVo);
        //0是判断题，1是选择题
        if (questionBankVo.getTestsType() == 0){
            if (questionBankState>=1){
                return true;
            }
        }
        //如果有数据
        if(questionBankState >= 1){
            //遍历options对象，写入选择题的questionBankId,
        for(Options options: questionBankVo.getOptions()){
            options.setQuestionBankId(questionBankVo.getQuestionBankId());
            }
        //先插入选择题options，再返回true,否则返回false
           int optionsState = questionBankDao.addOptions(questionBankVo.getOptions());
            if (optionsState >= 1){
                return true;
            }
        }
        return false;
    }

    /**
     * 删除题目
     * @param questionBankId
     * @return
     */

    @Override
    public boolean deleteQuestionBank(String questionBankId) {

        int questionBanKState = questionBankDao.deleteQuestionBankOptions(questionBankId);

        return questionBanKState>=1 ? true:false;

    }

    /**
     * 修改题目
     * @param questionBankVo
     * @return
     */
    @Transactional
    @Override
    public boolean updateQuestionBank(QuestionBankVo questionBankVo) {
        //获得成功条数
        int questionBanKState = questionBankDao.updateQuestionBank(questionBankVo);
        //大于等于1则先删除options的记录
        if(questionBanKState >=1){
            questionBankDao.deleteQuestionBankOptions(questionBankVo.getQuestionBankId().toString());
            //获得题目类型如果为1则遍历写入options选择题
            Integer testsType = questionBankVo.getTestsType();
            if (testsType == 1) {
                for (Options option : questionBankVo.getOptions()) {
                    option.setQuestionBankId(questionBankVo.getQuestionBankId());
                }
                questionBankDao.addOptions(questionBankVo.getOptions());
            }
            return true;
        }

        return false;
    }
}
