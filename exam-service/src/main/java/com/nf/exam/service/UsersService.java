package com.nf.exam.service;

import com.nf.exam.entity.Role;
import com.nf.exam.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lwb
 */
public interface UsersService {
    //查询所有用户
    List<Users> findUserInfo();
    
    //删除用户信息
   int deleteByPrimaryKey(String userId);
    //查询自己
    Users findUser(String userId);


    //得到某用户的角色
    Role getRoles(String userId);
    //修改用户的角色
    void updateRole(Role user, String roleId);
    //删除用户的角色
    void deleteRolesByUserId(String userId);
    //添加用户的角色
    void insertUserRole(@Param("userId") String userId, @Param("roleId") String roleId);


}
