package com.guigu.service;

import com.guigu.vo.Emprol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmprolService {
    //多个角色
    public int addEmprolByeidrid(List<Emprol> emprolList);
    //删除
    public int deleteEmprol(int emp_id);
}
