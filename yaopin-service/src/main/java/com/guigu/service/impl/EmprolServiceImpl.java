package com.guigu.service.impl;

import com.guigu.dao.EmployeeDao;
import com.guigu.dao.EmprolDao;
import com.guigu.service.EmprolService;
import com.guigu.vo.Emprol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprolServiceImpl  implements  EmprolService{
    @Autowired
    EmprolDao emprolDao;

    @Override
    public int addEmprolByeidrid(List<Emprol> emprolList) {
        return emprolDao.addEmprolByeidrid(emprolList);
    }

    @Override
    public int deleteEmprol(int emp_id) {
        return emprolDao.deleteEmprol(emp_id);
    }


}

