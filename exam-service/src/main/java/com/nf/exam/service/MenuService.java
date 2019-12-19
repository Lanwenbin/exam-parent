package com.nf.exam.service;

import com.nf.exam.dao.MenuDao;
import com.nf.exam.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/16 20:49
 */
public interface MenuService {
    //查找树菜单
    Menu findMenuById(String id);
    //得到添加菜单
    List<Menu> getAllMenus();
}
