package com.guigu.service;

import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;


public interface EmployeeService {
    //登录
    public Employee login(Employee employee);
    //查询所有
    public PageVo<Employee> queryEmployee(Employee employee, int page, int rows);
    //添加
    public int addEmployee(Employee employee);
    //删除
    public int deleteEmployee(int[] ids);
    //删除角色表
    public int deleteEmployeerol(int[] ids);
    //修改
    public int updateEmployee(Employee employee);
    //根据ID查
    public Employee queryEmployeeByempid(int emp_id);
    public Employee loginaddcha(Employee employee);

}
