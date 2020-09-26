package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.MenuDao;
import com.guigu.dao.PurchaseApplyDao;
import com.guigu.service.PurchaseApplyService;
import com.guigu.vo.PageVo;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.PurchaseApplyZhong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseApplyServiceImpl implements PurchaseApplyService {
    @Autowired
    PurchaseApplyDao purchaseApplyDao;

    @Override
    public int addPurchaseApply(PurchaseApply purchaseApply) {
        return purchaseApplyDao.addPurchaseApply(purchaseApply);
    }

    @Override
    public PurchaseApply queryPurchaseApplyBypuaid(int pua_id) {
        return purchaseApplyDao.queryPurchaseApplyBypuaid(pua_id);
    }

    @Override
    public PurchaseApply queryPurchaseApplyBypua_sdzhongid(int pua_sdzhongid) {
        return purchaseApplyDao.queryPurchaseApplyBypua_sdzhongid(pua_sdzhongid);
    }

    @Override
    public PageVo<PurchaseApply> queryPurchaseApply(PurchaseApply purchaseApply, int page, int rows) {
        PageVo<PurchaseApply> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(purchaseApplyDao.queryPurchaseApply(purchaseApply));
        //获取总的记录数量
        pageVo.setTotal(purchaseApplyDao.querycountPurchaseApply(purchaseApply));

        return pageVo;
    }

    @Override
    public int updatePurchaseApplyzhuang(int[] pua_id) {
        return purchaseApplyDao.updatePurchaseApplyzhuang(pua_id);
    }

    @Override
    public int updatePurchaseApplyzhuangs(int[] pua_id) {
        return purchaseApplyDao.updatePurchaseApplyzhuangs(pua_id);
    }

    @Override
    public PurchaseApply queryPurchaseApplyBypid(int pid) {
        return purchaseApplyDao.queryPurchaseApplyBypid(pid);
    }


}
