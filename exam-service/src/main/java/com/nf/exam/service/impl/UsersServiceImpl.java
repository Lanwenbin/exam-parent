package com.nf.exam.service.impl;

import com.nf.exam.dao.UsersDao;
import com.nf.exam.entity.Users;
import com.nf.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		//2.3查询用户数据Dao（数据持久层）
		List<Users> findUserInfo = usersDao.findUserInfo();
		
		return findUserInfo;
	}

	@Override
	public int deleteByPrimaryKey(String userId) {

		return usersDao.deleteByPrimaryKey(userId);
	}

	@Override
	public Users findUser(String userId) {
		return usersDao.findUser(userId);
	}

}
