package com.nf.exam.service;

import com.nf.exam.dao.PrivilegeDao;
import com.nf.exam.entity.Menu;
import com.nf.exam.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/16 20:50
 */
public interface PrivilegeService {
    //删除功能
    void deleteRolePrivilege(String roleId);
    //添加角色的功能
    void insertRolePrivilege(@Param("roleId") String roleId, @Param("privileges") List<Menu> privileges);
     void updateRolePrivilege(Role role, List<Menu> privileges);
}
