package com.nf.exam.service.impl;

import com.nf.exam.dao.PrivilegeDao;
import com.nf.exam.entity.Menu;
import com.nf.exam.entity.Role;
import com.nf.exam.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/16 20:56
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeDao privilegeDao;

    /**
     * 修改角色的权限，简单操作：把此角色的所有权限删除，然后再添加需要的权限
     * @param role
     * @param privileges
     */
    @Override
    @Transactional
    public void updateRolePrivilege(Role role, List<Menu> privileges) {
        privilegeDao.deleteRolePrivilege(role.getId());
        privilegeDao.insertRolePrivilege(role.getId(), privileges);
    }

    @Override
    public void deleteRolePrivilege(String roleId) {

    }

    @Override
    public void insertRolePrivilege(String roleId, List<Menu> privileges) {

    }
}
