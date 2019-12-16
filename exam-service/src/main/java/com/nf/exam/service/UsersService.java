package com.nf.exam.service;

import com.nf.exam.entity.Users;

import java.util.List;

/**
 * @author lwb
 */
public interface UsersService {
    //查询所有用户
	//2.1查询用户数据 接口
    List<Users> findUserInfo();
    
    //删除用户信息
   int deleteByPrimaryKey(String userId);
//查询自己
    Users findUser(String userId);

}
