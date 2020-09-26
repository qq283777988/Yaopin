package com.guigu.dao;

import com.guigu.vo.Employee;

import java.util.List;

public interface EmployeeDao {
    //登录
    public Employee login(Employee employee);
    //查询所有
    public List<Employee> queryEmployee(Employee employee);
    //查询所有数量
    public int querycountEmployee(Employee employee);
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
    //登录
    public Employee loginaddcha(Employee employee);
}
