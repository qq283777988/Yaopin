package com.guigu.dao;

import com.guigu.vo.Employee;
import com.guigu.vo.Emprol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmprolDao {
    //授权
    public int addEmprolByeidrid(List<Emprol> emprolList);
    //删除
    public int deleteEmprol(int emp_id);
    //修改

}
