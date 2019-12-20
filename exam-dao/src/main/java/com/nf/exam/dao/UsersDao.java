package com.nf.exam.dao;

import com.nf.exam.entity.Role;
import com.nf.exam.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 9:43
 */
public interface UsersDao {

    List<Users>findUserInfo();

    List<Users>findStudentInfo();

    int deleteByPrimaryKey(String userId);

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
