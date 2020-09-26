package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.MenuDao;
import com.guigu.dao.RoleDao;
import com.guigu.service.RoleService;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import com.guigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> queryallRoles() {
        return roleDao.queryallRoles();
    }

    @Override
    public List<Role> queryallRolesByempid(int emp_id) {
        return roleDao.queryallRolesByempid(emp_id);
    }

    @Override
    public PageVo<Role> queryallRole(int page, int rows) {
        PageVo<Role> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(roleDao.queryallRoles());
        //获取总的记录数量
        pageVo.setTotal(roleDao.querycountRole());

        return pageVo;
    }
}
