package com.nf.exam.service;

import com.nf.exam.entity.Menu;
import com.nf.exam.entity.Role;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/16 20:54
 */
public interface RoleService {
    //添加角色

    boolean addRole(Role role);
    boolean deleteRole(String roleId);
    //查找角色
    Role findRole(String id);
    //查找所有角色
    List<Role> getAllRole();
    //查找 某角色可用的菜单
    List<Menu> getMenusByRoleId(String roleId);
}
