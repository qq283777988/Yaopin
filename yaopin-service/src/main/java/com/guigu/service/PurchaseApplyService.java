package com.guigu.service;

import com.guigu.vo.PageVo;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.PurchaseApplyZhong;

import java.util.List;

public interface PurchaseApplyService {
    //添加
    public int addPurchaseApply(PurchaseApply purchaseApply);
    //根据ID查
    public PurchaseApply queryPurchaseApplyBypuaid(int pua_id);
    //通过进货申请中间表ID查
    public PurchaseApply queryPurchaseApplyBypua_sdzhongid(int pua_sdzhongid );
    //查询所有
    //查询所有
    public PageVo<PurchaseApply> queryPurchaseApply(PurchaseApply purchaseApply, int page, int rows);
    public int updatePurchaseApplyzhuang(int []pua_id );
    public int updatePurchaseApplyzhuangs(int []pua_id );
    //根据进货申请表ID查
    public PurchaseApply queryPurchaseApplyBypid(int pid );
}
