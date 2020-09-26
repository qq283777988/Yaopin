package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.WarehouseoutApplyDao;
import com.guigu.service.WarehouseoutApplyService;
import com.guigu.vo.PageVo;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.WarehouseoutApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseoutApplyServiceImpl  implements WarehouseoutApplyService {
    @Autowired
    WarehouseoutApplyDao warehouseoutApplyDao;
    @Override
    public int addWarehouseoutApply(WarehouseoutApply warehouseoutApply) {
        return warehouseoutApplyDao.addWarehouseoutApply(warehouseoutApply);
    }

    @Override
    public WarehouseoutApply queryWarehouseoutApplyBywoaid(int woa_id) {
        return warehouseoutApplyDao.queryWarehouseoutApplyBywoaid(woa_id);
    }

    @Override
    public PageVo<WarehouseoutApply> queryWarehouseoutApply(WarehouseoutApply warehouseoutApply, int page, int rows) {
        PageVo<WarehouseoutApply> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(warehouseoutApplyDao.queryWarehouseoutApply(warehouseoutApply));
        //获取总的记录数量
        pageVo.setTotal(warehouseoutApplyDao.querycountWarehouseoutApply(warehouseoutApply));

        return pageVo;
    }

    @Override
    public int updateWarehouseoutApplyzhuang(int[] woa_id) {
        return warehouseoutApplyDao.updateWarehouseoutApplyzhuang(woa_id);
    }

    @Override
    public int updateWarehouseoutApplyzhuangs(int[] woa_id) {
        return warehouseoutApplyDao.updateWarehouseoutApplyzhuangs(woa_id);
    }

    @Override
    public WarehouseoutApply queryWarehouseoutApplyBywid(int wid) {
        return warehouseoutApplyDao.queryWarehouseoutApplyBywid(wid);
    }
}
