package com.guigu.service;

import com.guigu.vo.Employee;
import com.guigu.vo.Menu;
import com.guigu.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {
    //根据父id 查询菜单
    public List<Menu> queryMenuByPidEmpid(int id,int emp_id);
    //根据角色id，去权限表 查询 拥有的菜单列表
    public  List<Menu> queryMenuByrid(int rol_id);
    //根据父id 查询菜单
    public List<Menu> queryMenuByPid(@Param("id") int id);
    //查询所有
    public PageVo<Menu> queryMenu( int page, int rows);
}
