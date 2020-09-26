package com.guigu.dao;

import com.guigu.vo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    //根据父id员工角色ID 查询菜单
    public List<Menu> queryMenuByPidEmpid(@Param("id") int id,@Param("emp_id") int emp_id);
    //根据父id 查询菜单
    public List<Menu> queryMenuByPid(@Param("id") int id);

    //根据角色id，去权限表 查询 拥有的菜单列表
    public  List<Menu> queryMenuByrid(int rol_id);
    public  List<Menu> queryMenu();
    public  int querycountMenu();
}
