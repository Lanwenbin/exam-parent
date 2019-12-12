package com.nf.exam.entity;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 10:48
 */
@Data
public class Users {
    private String userId;
@Size(min = 2,max = 25)
    private String userName;
@Size(min = 2,max = 25)
    private String userPass;

    private String userPhone;

    private  String userPortrait;

//    private String code;

    private Integer permission;

}
