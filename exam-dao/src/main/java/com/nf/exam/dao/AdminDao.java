package com.nf.exam.dao;

import com.nf.exam.entity.Users;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 11:36
 */
public interface AdminDao {
     Users findByUser(Users users);

     Integer register(Users users);
}
