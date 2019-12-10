package com.nf.exam.entity;

import lombok.Data;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 10:44
 */
@Data
public class Score {
    private Integer scoreId;

    private String usersId;

    private Integer testpaperId;

    private Double fraction;

}
