package com.guigu.controller;

import com.guigu.service.RoleService;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import com.guigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/queryallRole.action")
    @ResponseBody
    public PageVo<Role> queryallRole(
                                          @RequestParam(value = "page",defaultValue = "1") int page,
                                          @RequestParam(value = "rows",defaultValue = "2")int rows){
        return roleService.queryallRole(page,rows);
    }
    //首页显示左边菜单的
    @RequestMapping("/queryallroles.action")
    @ResponseBody
    public List<Role> queryallroles(){
        return roleService.queryallRoles();
    }
    @RequestMapping("/queryallrolesbyempid.action")
    @ResponseBody
    public List<Role> queryallRolesByempid(int emp_id){
        return roleService.queryallRolesByempid(emp_id);
    }
}
