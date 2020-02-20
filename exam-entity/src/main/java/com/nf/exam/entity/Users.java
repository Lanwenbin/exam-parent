package com.nf.exam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 10:48
 */
@Data
@NoArgsConstructor
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

    public Users(String userId,String userPass, String userPortrait) {
        this.userId = userId;
        this.userPass = userPass;
        this.userPortrait = userPortrait;
    }

    public Users(String userId, String userPass) {
        this.userId = userId;
        this.userPass = userPass;
    }
}
