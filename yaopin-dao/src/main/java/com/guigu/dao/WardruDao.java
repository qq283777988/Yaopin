package com.guigu.dao;


import com.guigu.vo.Employee;
import com.guigu.vo.Emprol;
import com.guigu.vo.Supdru;
import com.guigu.vo.Wardru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WardruDao {
    //查询所有
    public List<Wardru> queryallWardru(int dru_id);
    //删除仓库药品
    public int deleteWardruBydruid(int[] ids);
    //添加仓库药品
    //修改仓库药品Drug
    //查询总库存
    public int queryDrugkucun(int dru_id);
    //入库添加
    public int addWardrulist(Wardru wardru);
    //修改
    public int updateWardru(Wardru wardru);
    //查询所有
    public List<Wardru> queryallWardruu(@Param("war_id") int war_id,@Param("dru_id") int dru_id);
    //查询所有
    public List<Wardru> queryallWardruuu(  );
    //出库
    public int updateWardrus(Wardru wardru);
    //出库根据订单ID查询
    public List<Wardru> queryallWardruBywid(int wid);
    //根据供应商ID查
    public List<Wardru> queryallWardruBysupdruid(@Param("sup_id") int sup_id,@Param("dru_id") int dru_id);
    //同上
    public Wardru queryallWardruBysupwarid(@Param("supdru_id") int supdru_id,@Param("war_id") int war_id);
}
