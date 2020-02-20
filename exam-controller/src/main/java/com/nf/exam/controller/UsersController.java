package com.nf.exam.controller;

import com.nf.exam.entity.Users;
import com.nf.exam.entity.vo.ResponseVO;
import com.nf.exam.entity.vo.UsersVO;
import com.nf.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
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
        int i=usersService.deleteByPrimaryKey(userId);
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
    @RequestMapping("/personal")
    @ResponseBody
    public ResponseVO Personal(@RequestBody UsersVO usersVO){
        System.out.println("usersVO = "+usersVO);
       /* Users users = null;
        Users users1 = (Users) session.getAttribute("myUsers");
        if (usersVO.getFinalImg() == null){
            users = new Users(usersVO.getUserPass(),users1.getUserId());
            if (usersService.updateUser(users)){
                return ResponseVO.newBuilder().code("200").msg("修改成功").build();
            }else {
                return ResponseVO.newBuilder().code("500").msg("修改失败").build();
            }
        }else {
            String filePath = "C:\\Users\\小怪兽\\Desktop\\论文\\exam-parent\\exam-controller\\src\\main\\resources\\static\\img";
            String filename = usersVO.getFinalImg().getOriginalFilename();
            String path = filePath + File.separator + filename;

            String newFile = "/static/img/" + filename;
            File file = new File(path);
            try {
                usersVO.getFinalImg().transferTo(file);
                users = new Users(usersVO.getUserPass(),newFile,users1.getUserId());
                usersService.updateUser(users);
                session.setAttribute("myUsers",users);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseVO.newBuilder().code("500").msg("修改失败").build();
            }
            return ResponseVO.newBuilder().code("200").msg("修改成功").build();
        }
*/
        return ResponseVO.newBuilder().code("200").msg("修改成功").build();
    }

    /**
     * 个人资料的修改
     * @return
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public ModelAndView Upload(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", 1);
        modelAndView.setViewName("admin/user");
        return modelAndView;
    }


}
