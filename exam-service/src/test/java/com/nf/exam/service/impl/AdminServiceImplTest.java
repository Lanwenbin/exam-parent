package com.nf.exam.service.impl;

import com.nf.exam.entity.Users;
import com.nf.exam.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 15:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-spring.xml")
public class AdminServiceImplTest {
    @Autowired
private AdminServiceImpl adminService;
    @Test
    public void findByUser() {
        Users users = new Users();
        users.setUserName("lwb");
        users.setUserPass("123");
       Users user = adminService.findByUser(users);
        System.out.println("user = ---------------------" + user);
    }
}