package com.nf.exam.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 10:47
 */
@Data
public class TestPaperTestsList {

    private Integer testpaperId;

    private List<Integer> questionBankId;
}
