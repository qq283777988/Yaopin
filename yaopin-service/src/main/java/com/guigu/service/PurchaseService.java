package com.guigu.service;

import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.PurchaseApply;

import java.util.List;

public interface PurchaseService {
    //添加
    public int addPurchase(List<Purchase> purchases);
    //添加
    public int addPurchases(List<Purchase> purchases);
    //查询所有
    public PageVo<Purchase> queryPurchase(Purchase purchase, int page, int rows);
    public int updatePurchasezhuang(int []pid );
    public int updatePurchasezhuangs(int []pid );
    //根据入库申请表ID查
    public Purchase queryPurchaseBypid(int pid);

}
