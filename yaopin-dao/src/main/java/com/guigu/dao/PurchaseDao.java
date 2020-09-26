package com.guigu.dao;

import com.guigu.vo.Purchase;

import java.util.List;

public interface PurchaseDao {
    //添加
    public int addPurchase(List<Purchase> purchases);
    //添加
    public int addPurchases(List<Purchase> purchases);
    //查询所有
    public List<Purchase> queryPurchase(Purchase purchase);
    //查询所有数量
    public int querycountPurchase(Purchase purchase);
    //改变状态
    public int updatePurchasezhuang(int []pid );
    public int updatePurchasezhuangs(int []pid );
    //根据入库申请表ID查
    public Purchase queryPurchaseBypid(int pid);

}
