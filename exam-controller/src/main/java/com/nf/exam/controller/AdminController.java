package com.nf.exam.controller;

import com.nf.exam.entity.Users;
import com.nf.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/2 19:21
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginJson(HttpSession session, Users users) {
//        String sessionCode = (String) session.getAttribute("code");// session中验证码
//        String code = users.getCode();// 用户code
//        if (!sessionCode.equals(code)) {// 验证码错误返回提示信息
//            return "0";
//        }
        Users user = adminService.findByUser(users);
        if (user != null) {
            session.setAttribute("myUser", user);// 存SESSION
            Integer permission = user.getPermission();// 权限 0 普通用户 1管理员
            if (permission == 1) {
                // 跳转管理员
                return "2";
            } else {
                // 跳转用户考试选题界面
                return "3";
            }
        }
        return "1";// 账号密码错误
    }

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }


}
