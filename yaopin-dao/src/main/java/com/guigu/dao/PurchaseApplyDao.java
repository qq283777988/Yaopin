package com.guigu.dao;

import com.guigu.vo.Employee;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.PurchaseApplyZhong;
import com.guigu.vo.Supdru;

import java.util.List;

public interface PurchaseApplyDao {
    //添加
    public int addPurchaseApply(PurchaseApply purchaseApply);
    //根据ID查
    public PurchaseApply queryPurchaseApplyBypuaid(int pua_id);
    //通过进货申请中间表ID查
    public PurchaseApply queryPurchaseApplyBypua_sdzhongid(int pua_sdzhongid );
    //查询所有
    public List<PurchaseApply> queryPurchaseApply(PurchaseApply purchaseApply);
    //查询所有数量
    public int querycountPurchaseApply(PurchaseApply purchaseApply);
    //改变状态
    public int updatePurchaseApplyzhuang(int []pua_id );
    public int updatePurchaseApplyzhuangs(int []pua_id );
    //根据进货申请表ID查
    public PurchaseApply queryPurchaseApplyBypid(int pid );
}
