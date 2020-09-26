package com.guigu.dao;


import com.guigu.vo.Employee;
import com.guigu.vo.Role;

import java.util.List;

public interface RoleDao {
    //查询所有角色信息
    public List<Role> queryallRoles();
   //查询所有角色信息数量
    public int querycountRole();
    //根据员工ID查询角色信息
    public List<Role> queryallRolesByempid(int emp_id);

}
