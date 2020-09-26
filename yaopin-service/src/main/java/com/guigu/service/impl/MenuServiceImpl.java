package com.guigu.service.impl;


import com.github.pagehelper.PageHelper;
import com.guigu.dao.MenuDao;
import com.guigu.service.MenuService;
import com.guigu.vo.Employee;
import com.guigu.vo.Menu;

import com.guigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;


    @Override
    public List<Menu> queryMenuByPidEmpid(int id, int emp_id) {
        List<Menu> menus =  menuDao.queryMenuByPidEmpid(id,emp_id);

        //将url的值 存入attributes属性中
        for (Menu menu: menus ) {
            if(menu.getUrl()!=null && menu.getUrl()!=""){
                menu.getAttributes().put("url",menu.getUrl());
            }
        }

        return menus;
    }

    @Override
    public List<Menu> queryMenuByrid(int rol_id) {
        //获取当前角色id所拥有的菜单信息
        List<Menu> privmenus = menuDao.queryMenuByrid(rol_id);

        //获取所有的父菜单
        List<Menu> parentmenus = menuDao.queryMenuByPid(0);

        //循环  每一个父菜单 根据id，查询出所有的子菜单
        for (Menu pmenu : parentmenus) {
            List<Menu> childmenus = menuDao.queryMenuByPid(pmenu.getId());
            //循环  查询该菜单 是否选中
            for (Menu child : childmenus) {
                //循环权限菜单
                for (Menu privmenu : privmenus) {
                    if (child.getId().equals(privmenu.getId())) {  //子菜单id  == 权限表 菜单id
                        child.setChecked(true);
                        break;
                    }
                }
            }

            pmenu.setChildren(childmenus);
        }
        return parentmenus;
    }

    @Override
    public List<Menu> queryMenuByPid(int id) {
        List<Menu> menus =  menuDao.queryMenuByPid(id);
        //将url的值 存入attributes属性中
        for (Menu menu: menus ) {
            if(menu.getUrl()!=null && menu.getUrl()!=""){
                menu.getAttributes().put("url",menu.getUrl());
            }
        }
        return menus;
    }

    @Override
    public PageVo<Menu> queryMenu( int page, int rows) {
        PageVo<Menu> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(menuDao.queryMenu());
        //获取总的记录数量
        pageVo.setTotal(menuDao.querycountMenu());

        return pageVo;
    }
}
