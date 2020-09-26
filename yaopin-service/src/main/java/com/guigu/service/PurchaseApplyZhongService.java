package com.guigu.service;

import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import com.guigu.vo.PurchaseApplyZhong;

import java.util.List;

public interface PurchaseApplyZhongService  {
    //添加
    public int addPurchaseApplyZhong(List<PurchaseApplyZhong> purchaseApplyZhongs);
    //根据订单ID查
    public List<PurchaseApplyZhong> queryPurchaseApplyZhongBypuaid(int pua_id);
/*    //查询所有
    public PageVo<PurchaseApplyZhong> queryPurchaseApplyZhong(PurchaseApplyZhong purchaseApplyZhong, int page, int rows);*/
//根据入库申请表查药品数量
public List<PurchaseApplyZhong> queryPurchaseApplyZhongBywahid(int wah_id);
}
