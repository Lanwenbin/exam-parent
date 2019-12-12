package com.nf.shop.controller.front;

import com.nf.shop.entity.Customer;
import com.nf.shop.service.front.CustomerService;
import com.nf.shop.utils.CustomerVo;
import com.nf.shop.utils.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author:DENG-
 * @Date:2019/12/9 15:08
 */
@Controller
@RequestMapping("/front/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 用户登录
     * @param phone
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("loginByAccount")
    @ResponseBody
    public ResponseVO loginByAccount(String phone, String password, HttpSession session){
        Customer customer=null;
        try {
            customer=customerService.login(phone,password);
            customer.setPassword(null);
            session.setAttribute("customer",customer);
            return ResponseVO.newBuilder().code("200").msg("登录成功").data(customer).build();
        }catch (Exception e){
            return ResponseVO.newBuilder().code("500").msg("登录失败").build();
        }
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public ResponseVO logout(HttpSession session){
        session.invalidate();
        return ResponseVO.newBuilder().msg("成功").code("200").data(null).build();
    }

    /**
     * 验证手机号是否被注册
     * @param phone
     * @return
     */
    @RequestMapping("/checkPhone")
    @ResponseBody
    public ResponseVO checkPhone(String phone){
        boolean flag = customerService.findByPhone(phone);
        if (flag){
            return ResponseVO.newBuilder().code("200").msg("该手机号可用").data(null).build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("改手机号已经被注册").build();
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResponseVO register(String loginName,String password,String address,String phone,int verifyCode,HttpSession session){
        try {
            //System.out.println("loginName = " + loginName);
            Customer customer = new Customer(loginName,password,phone,address,1,new Date());
            int sendVerifyCode = (int) session.getAttribute("sendVerifyCode");
            if (verifyCode == sendVerifyCode){
                Customer customer1 = customerService.register(customer);
                if (customer1 != null){
                    customer1.setPassword(null);
                    session.setAttribute("customer",customer1);
                    return ResponseVO.newBuilder().code("200").msg("注册成功").data(customer1).build();
                }
            }
            return ResponseVO.newBuilder().code("500").msg("注册失败").build();
        }catch (Exception e){
            return ResponseVO.newBuilder().code("500").msg("注册失败").build();
        }
    }
}
