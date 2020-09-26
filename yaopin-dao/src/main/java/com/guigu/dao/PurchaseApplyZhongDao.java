package com.guigu.dao;

import com.guigu.vo.PurchaseApplyZhong;

import java.util.List;

public interface PurchaseApplyZhongDao {
    //添加
    public int addPurchaseApplyZhong(List<PurchaseApplyZhong> purchaseApplyZhongs);
   /* //查询所有
    public List<PurchaseApplyZhong> queryPurchaseApplyZhong(PurchaseApplyZhong purchaseApplyZhong);
    //查询所有数量
    public int querycountPurchaseApplyZhong(PurchaseApplyZhong purchaseApplyZhong);*/
    //根据订单ID查
   public List<PurchaseApplyZhong> queryPurchaseApplyZhongBypuaid(int pua_id);
   //根据入库申请表查药品数量
   public List<PurchaseApplyZhong> queryPurchaseApplyZhongBywahid(int wah_id);
}
