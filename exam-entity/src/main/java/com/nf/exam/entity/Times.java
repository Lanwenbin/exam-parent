package com.nf.exam.entity;

import lombok.Data;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 10:48
 */
@Data
public class Times {
    private Integer timesId;

    private Integer testpaperId;

    private String userId;

    private Double dataMin;

    private Integer timesState;
}
