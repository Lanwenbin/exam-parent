package com.nf.exam.dao;

import com.nf.exam.entity.Users;
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
 * @Date 2019/12/2 12:03
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dao-spring.xml")
public class AdminDaoTest {
@Autowired
private AdminDao adminDao;
    @Test
    public void findByUser() {
        Users user = new Users();
        user.setUserName("lwb");
        user.setUserPass("123");
       Users users = adminDao.findByUser(user);
        System.out.println("users = " + users);
    }
}