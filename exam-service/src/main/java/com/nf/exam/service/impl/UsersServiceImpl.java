package com.nf.exam.service.impl;

import com.nf.exam.dao.UsersDao;
import com.nf.exam.entity.Role;
import com.nf.exam.entity.Users;
import com.nf.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lwb
 */
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao usersDao;

	//2.2查询用户数据 实现
	@Override
	public List<Users> findUserInfo() {
		List<Users> findUserInfo = usersDao.findUserInfo();
		
		return findUserInfo;
	}

	@Override
	public List<Users> findStudentInfo() {
		return usersDao.findStudentInfo();
	}

	@Override
	public int deleteByPrimaryKey(String userId) {

		return usersDao.deleteByPrimaryKey(userId);
	}

	@Override
	public Users findUser(String userId) {
		return usersDao.findUser(userId);
	}

	@Override
	public Role getRoles(String userId) {
		return usersDao.getRoles(userId);
	}

	@Transactional
	@Override
	public void updateRole(Role user, String roleId) {
		usersDao.deleteRolesByUserId(user.getId());
		usersDao.insertUserRole(user.getId(), roleId);
	}

	@Override
	public void deleteRolesByUserId(String userId) {

	}

	@Override
	public void insertUserRole(String userId, String roleId) {

	}


}
