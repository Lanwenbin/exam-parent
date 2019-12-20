package com.nf.exam.controller;

import com.nf.exam.entity.Users;
import com.nf.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/4 9:21
 */
@Controller
@RequestMapping("/admin")
public class UsersController {
@Autowired
    private UsersService usersService;
    /**
     * 1.首页访问用户界面 对应下面  /user.html
     * 2.查询页面用户数据
     * @return
     */
    @RequestMapping(value="/user.html",method= RequestMethod.GET)
    public ModelAndView AllUsers(){
        List<Users> allUsers=usersService.findUserInfo();	//2.查询页面用户数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allUsers", allUsers);
        modelAndView.setViewName("admin/user");
        return modelAndView;
    }

    @RequestMapping(value="/student.html",method= RequestMethod.GET)
    public ModelAndView AllStudent(){
        List<Users> allUsers=usersService.findStudentInfo();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allUsers", allUsers);
        modelAndView.setViewName("admin/student");
        return modelAndView;
    }



    @RequestMapping(value="/userDelete",method=RequestMethod.GET)
    @ResponseBody
    public String deleteUsers(String userId){
        System.out.println("---------------------");
        int i=usersService.deleteByPrimaryKey(userId);
        System.out.println("---------------------");
        System.out.println(i);
        if(i>=1){
            return "1";
        }else{
            return "0";
        }

    }

    /**
     * 个人资料的修改
     * @return
     */
    @RequestMapping(value="/personal")
    public ModelAndView Personal(HttpServletRequest request){
        String userId =  request.getParameter("userId");
        Users users = usersService.findUser(userId);
        System.out.println("users = " + users);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("admin/");
        return modelAndView;
    }

    /**
     * 个人资料的修改
     * @return
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public ModelAndView Upload(HttpServletRequest request){
        System.out.println("request = " + request);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("modelAndView ==================== " + modelAndView);
        modelAndView.addObject("users", 1);
        modelAndView.setViewName("admin/user");
        return modelAndView;
    }




}
