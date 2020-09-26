package com.guigu.dao;

import com.guigu.vo.Menrol;

import java.util.List;

public interface MenrolDao {
    //权限表授权：根据角色ID和菜单ID
    public int deleteMenroluByridmid(int rol_id);
    //授权
    public int addMenurolByridmid(List<Menrol> menrolList);
    //授权中 检测角色ID是否在权限表中->能否删除
    public List<Menrol> queryMenrolByrid(int rol_id);
}
