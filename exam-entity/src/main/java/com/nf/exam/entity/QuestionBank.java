package com.nf.exam.entity;

import lombok.Data;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 10:42
 */
@Data
public class QuestionBank {
    private Integer questionBankId;

    private String answer;

    private Integer testsType;

    private Integer state;

    private String stem;
}
