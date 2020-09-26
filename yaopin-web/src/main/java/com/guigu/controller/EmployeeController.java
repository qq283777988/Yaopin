package com.guigu.controller;

import com.guigu.service.EmployeeService;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

   @RequestMapping(value = "/login.action",produces = "text/json;charset=utf-8")
   @ResponseBody
   public String login(Employee employee, HttpSession session){
       //调用service
       Employee employee1 = employeeService.login(employee);
       //返回数据
       if(employee1!=null){
           //保存  登录成功用户信息
           session.setAttribute("employee",employee1);

           return "登录成功";
       }

       return  "登录失败";

   }

    @RequestMapping("/queryEmployee.action")
    @ResponseBody
    public PageVo<Employee> queryEmployee(Employee employee,
                                         @RequestParam(value = "page",defaultValue = "1") int page,
                                         @RequestParam(value = "rows",defaultValue = "2")int rows){
        return employeeService.queryEmployee(employee,page,rows);
    }

   /* @RequestMapping(value ="/addemp.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addemp(Employee employee,int rol_id){
      *//*  int num=employeeService.addEmployee(employee);*//*
        String msg="";
       *//* if(num==1){
            msg="添加成功";
        }else{
            msg="添加失败";
        }*//*
        System.out.println("角色名称"+rol_id);
        return  msg;
    }*/

    @RequestMapping("/queryempByempid.action")
    @ResponseBody  //通知框架   返回的集合，vo，map  转成json格式  jackson.jar
    public Employee queryempByempid(int emp_id)
    {
        return employeeService.queryEmployeeByempid(emp_id);
    }

   /* @RequestMapping(value ="/updateemp.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updateemp(Employee employee){
        int num=employeeService.updateEmployee(employee);
        String msg="";
      if(num==1){
            msg="修改成功";
        }else{
            msg="修改失败";
        }

        return  msg;
    }*/

    @RequestMapping("/deleteemp.action")
    @ResponseBody
    public Map deleteemp(String ids){
        String[] idss =ids.split(",");
        int[] idsss = new int[idss.length];
        for (int i = 0; i < idss.length; i++) {
            idsss[i] = Integer.parseInt(idss[i]);
        }
        Map<String,String> map =new HashMap<String, String>() ;
        int num=employeeService.deleteEmployee(idsss);
        //num返回的是影响行数！！！！！！！
        if(num==idss.length){
            employeeService.deleteEmployeerol(idsss);
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }
        return  map;
    }
}
