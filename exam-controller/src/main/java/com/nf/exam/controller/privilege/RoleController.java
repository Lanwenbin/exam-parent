package com.nf.exam.controller.privilege;

import com.nf.exam.entity.Menu;
import com.nf.exam.entity.Role;
import com.nf.exam.service.MenuService;
import com.nf.exam.service.PrivilegeService;
import com.nf.exam.service.RoleService;
import com.nf.exam.service.impl.PrivilegeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/18 10:37
 */
@Controller
@RequestMapping("/admin")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PrivilegeService privilegeService;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/role.html")
    protected ModelAndView roleList() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> role = roleService.getAllRole();
        modelAndView.addObject("role",role);
        modelAndView.setViewName("admin/role");
        return modelAndView;
    }


    @RequestMapping("/role-privilege/insert")
    @ResponseBody
    protected Object service(String[] privilege_id,String role_id) {

        Role role = roleService.findRole(role_id);

        List<Menu> list = new ArrayList<Menu>();
        for(String pid:privilege_id) {
            Menu privilege = menuService.findMenuById(pid);
            list.add(privilege);
        }
        privilegeService.updateRolePrivilege(role,list);
        return true;

    }


    @RequestMapping(value="/roleDelete",method= RequestMethod.GET)
    @ResponseBody
    public String deleteUsers(String roleId){
        System.out.println("---------------------");
        boolean i=roleService.deleteRole(roleId);
        System.out.println("---------------------");
        System.out.println(i);
        if(i){
            return "1";
        }else{
            return "0";
        }

    }



}
