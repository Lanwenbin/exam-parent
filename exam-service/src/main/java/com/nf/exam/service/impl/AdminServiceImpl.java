package com.nf.exam.service.impl;

import com.nf.exam.dao.AdminDao;
import com.nf.exam.entity.Users;
import com.nf.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 15:06
 */
@Service
public class AdminServiceImpl implements AdminService {
@Autowired
private AdminDao adminDao;

    @Override
    public Users findByUser(Users users) {
        Users user =adminDao.findByUser(users);
        return user;
    }
    @Override
    public Integer register(Users users) {
        return adminDao.register(users);
    }
}
