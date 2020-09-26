package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.MenuDao;
import com.guigu.dao.PurchaseApplyZhongDao;
import com.guigu.service.PurchaseApplyZhongService;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import com.guigu.vo.PurchaseApplyZhong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseApplyZhongServiceImpl  implements PurchaseApplyZhongService {
    @Autowired
    PurchaseApplyZhongDao purchaseApplyZhongDao;

    @Override
    public int addPurchaseApplyZhong(List<PurchaseApplyZhong> purchaseApplyZhongs) {
        return purchaseApplyZhongDao.addPurchaseApplyZhong(purchaseApplyZhongs);
    }

    @Override
    public List<PurchaseApplyZhong> queryPurchaseApplyZhongBypuaid(int pua_id) {
        return purchaseApplyZhongDao.queryPurchaseApplyZhongBypuaid(pua_id);
    }

    @Override
    public List<PurchaseApplyZhong> queryPurchaseApplyZhongBywahid(int wah_id) {
        return purchaseApplyZhongDao.queryPurchaseApplyZhongBywahid(wah_id);
    }



    /*@Override
    public PageVo<PurchaseApplyZhong> queryPurchaseApplyZhong(PurchaseApplyZhong purchaseApplyZhong, int page, int rows) {
        PageVo<PurchaseApplyZhong> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(purchaseApplyZhongDao.queryPurchaseApplyZhong(purchaseApplyZhong));
        //获取总的记录数量
        pageVo.setTotal(purchaseApplyZhongDao.querycountPurchaseApplyZhong(purchaseApplyZhong));

        return pageVo;
    }*/
}
