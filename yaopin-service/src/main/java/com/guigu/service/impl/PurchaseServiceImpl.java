package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.PurchaseApplyZhongDao;
import com.guigu.dao.PurchaseDao;
import com.guigu.service.PurchaseService;
import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.PurchaseApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseDao purchaseDao;

    @Override
    public int addPurchase(List<Purchase> purchases) {
        return purchaseDao.addPurchase(purchases);
    }

    @Override
    public int addPurchases(List<Purchase> purchases) {
        return purchaseDao.addPurchases(purchases);
    }

    @Override
    public PageVo<Purchase> queryPurchase(Purchase purchase, int page, int rows) {
        PageVo<Purchase> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(purchaseDao.queryPurchase(purchase));
        //获取总的记录数量
        pageVo.setTotal(purchaseDao.querycountPurchase(purchase));

        return pageVo;
    }

    @Override
    public int updatePurchasezhuang(int[] pid) {
        return purchaseDao.updatePurchasezhuang(pid);
    }

    @Override
    public int updatePurchasezhuangs(int[] pid) {
        return purchaseDao.updatePurchasezhuangs(pid);
    }

    @Override
    public Purchase queryPurchaseBypid(int pid) {
        return purchaseDao.queryPurchaseBypid(pid);
    }
}
