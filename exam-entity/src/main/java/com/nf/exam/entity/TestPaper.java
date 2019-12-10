package com.nf.exam.entity;

import lombok.Data;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 10:45
 */
@Data
public class TestPaper {
    private Integer testpaperId;

    private String testpaperName;

    private Integer testpaperState;

    private String startDate;

    private String endDate;

    private Integer isStart;
}
