package com.guigu.controller;

import com.guigu.service.EmployeeService;
import com.guigu.service.EmprolService;
import com.guigu.vo.Employee;
import com.guigu.vo.Emprol;
import com.guigu.vo.Menrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmprolController {
    @Autowired
    EmprolService emprolService;
    @Autowired
    EmployeeService employeeService;
  /*  @RequestMapping(value ="/addemp.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addemp(Employee employee, int rol_id ){
        int num=employeeService.addEmployee(employee);
        Employee employee1=employeeService.login(employee);
        String msg="";
        if(num==1){
            System.out.println("角色名称----"+rol_id);
            System.out.println("员工id-----"+employee1.getEmp_id());
          *//* emprolService.addEmprolByeidridyi(employee1.getEmp_id(),rol_id);*//*
            msg="添加成功";
        }else{
            msg="添加失败";
        }

        return  msg;
    }*/
  @RequestMapping(value ="/addemp.action",produces = {"application/json;charset=utf-8"})
  @ResponseBody
  public String addemp(Employee employee, String mids){
      System.out.println("aaaaaaaaaa--");
      System.out.println("员工"+employee);
      System.out.println("分:"+mids);
      String msg="";
      int num=employeeService.addEmployee(employee);
      System.out.println("num"+num);
      List<Emprol> emprolList=new ArrayList<>();
      String[] midss = mids.split(",");
      if(num==1){
          System.out.println("employee = " + employee);
          Employee employee1=employeeService.loginaddcha(employee);
          System.out.println("添加后的"+employee1);
          for(String s:midss){
              Emprol emprol=new Emprol();
              emprol.setEmp_id(employee1.getEmp_id());
              emprol.setRol_id(Integer.parseInt(s));
              emprolList.add(emprol);
              System.out.println("---角色中的"+emprol);
          }
       int numm=emprolService.addEmprolByeidrid(emprolList);
          if(numm==midss.length){
              msg="添加成功";
          }else{
              msg="添加失败";
          }
      }
      return  msg;
  }

    @RequestMapping(value ="/updateemp.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updateemp(Employee employee, String mids){
        System.out.println("aaaaaaaaaaaaaaa-s"+employee);
        String msg="";

        int num=employeeService.updateEmployee(employee);
        System.out.println("修改Num "+num);
        List<Emprol> emprolList=new ArrayList<>();
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        if(num==1){
            for(String s:midss){
                Emprol emprol=new Emprol();
                emprol.setEmp_id(employee.getEmp_id());
                emprol.setRol_id(Integer.parseInt(s));
                emprolList.add(emprol);
                System.out.println("---修改角色中的"+emprol);
            }
            int nummd=emprolService.deleteEmprol(employee.getEmp_id());
            System.out.println(nummd+"hahaha");
     /*       if(nummd==midss.length){*/
                int numm=emprolService.addEmprolByeidrid(emprolList);
                if(numm==midss.length){
                    msg="修改成功";
                }else{
                    msg="修改失败";
                }
          /*  }*/

        }
        return  msg;
    }
}
