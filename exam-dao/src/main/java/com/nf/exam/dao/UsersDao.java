package com.nf.exam.dao;

import com.nf.exam.entity.Users;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 9:43
 */
public interface UsersDao {

    List<Users>findUserInfo();

    int deleteByPrimaryKey(String userId);
}
