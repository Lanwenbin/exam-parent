package com.nf.exam.service;

import com.nf.exam.entity.Users;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 15:04
 */
public interface AdminService {

     Users findByUser(Users users);
     Integer register(Users users);
}
