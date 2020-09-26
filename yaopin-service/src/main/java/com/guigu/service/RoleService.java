package com.guigu.service;

import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import com.guigu.vo.Role;

import java.util.List;

public interface RoleService {
    //查询所有角色信息
    public List<Role> queryallRoles();
    //根据员工ID查询角色信息
    public List<Role> queryallRolesByempid(int emp_id);
    //查询所有
    public PageVo<Role> queryallRole(  int page, int rows);
}
