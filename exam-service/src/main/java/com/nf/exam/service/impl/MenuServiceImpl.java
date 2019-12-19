package com.nf.exam.service.impl;

import com.nf.exam.dao.MenuDao;
import com.nf.exam.entity.Menu;
import com.nf.exam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/16 20:55
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired(required = false)
    private MenuDao menuDao;

    @Override
    public Menu findMenuById(String id) {
        return menuDao.findMenuById(id);
    }


    @Override
    public List<Menu> getAllMenus() {
        return menuDao.getAllMenus();
    }
}
