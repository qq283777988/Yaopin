package com.guigu.dao;




import com.guigu.vo.PurchaseApply;
import com.guigu.vo.WarehouseoutApply;

import java.util.List;

public interface WarehouseoutApplyDao {
    //添加
    public int addWarehouseoutApply(WarehouseoutApply warehouseoutApply);
    //根据ID查
    public WarehouseoutApply queryWarehouseoutApplyBywoaid(int woa_id);
    //查询所有
    //查询所有
    public List<WarehouseoutApply> queryWarehouseoutApply(WarehouseoutApply warehouseoutApply);
    //查询所有数量
    public int querycountWarehouseoutApply(WarehouseoutApply warehouseoutApply);
    //改变状态
    public int updateWarehouseoutApplyzhuang(int []woa_id );
    public int updateWarehouseoutApplyzhuangs(int []woa_id );
    //根据出货单ID查
    public WarehouseoutApply queryWarehouseoutApplyBywid(int wid);
}

