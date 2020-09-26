package com.guigu.service;

import com.guigu.vo.PageVo;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.WarehouseoutApply;

import java.util.List;

public interface WarehouseoutApplyService {
    //添加
    public int addWarehouseoutApply(WarehouseoutApply warehouseoutApply);
    //根据ID查
    public WarehouseoutApply queryWarehouseoutApplyBywoaid(int woa_id);
    public PageVo<WarehouseoutApply> queryWarehouseoutApply(WarehouseoutApply warehouseoutApply, int page, int rows);
    public int updateWarehouseoutApplyzhuang(int []woa_id );
    public int updateWarehouseoutApplyzhuangs(int []woa_id );
    //根据出货单ID查
    public WarehouseoutApply queryWarehouseoutApplyBywid(int wid);
}
