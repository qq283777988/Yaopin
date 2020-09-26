package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.EmployeeDao;
import com.guigu.service.EmployeeService;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Employee login(Employee employee) {
        try {
            return employeeDao.login(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }


    @Override
    public PageVo<Employee> queryEmployee(Employee employee, int page, int rows) {
        PageVo<Employee> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(employeeDao.queryEmployee(employee));
        //获取总的记录数量
        pageVo.setTotal(employeeDao.querycountEmployee(employee));

        return pageVo;
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public int deleteEmployee(int[] ids) {
        return employeeDao.deleteEmployee(ids);
    }

    @Override
    public int deleteEmployeerol( int[] ids) {
        return employeeDao.deleteEmployeerol( ids);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee queryEmployeeByempid(int emp_id) {
        return employeeDao.queryEmployeeByempid(emp_id);
    }

    @Override
    public Employee loginaddcha(Employee employee) {
        return employeeDao.loginaddcha(employee);
    }


}
