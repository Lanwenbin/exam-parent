package com.nf.exam.entity.vo;

import com.nf.exam.entity.Options;
import com.nf.exam.entity.QuestionBank;
import lombok.Data;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 11:31
 */
@Data
public class QuestionBankVo  extends QuestionBank{
    private List<Options> options;
    private boolean ifCorrect;
}
