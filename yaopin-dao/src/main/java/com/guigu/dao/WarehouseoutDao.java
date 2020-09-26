package com.guigu.dao;

import com.guigu.vo.Purchase;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.Warehouseout;
import com.guigu.vo.WarehouseoutApply;

import java.util.List;

public interface WarehouseoutDao {
    //添加
    public int addWarehouseout(List<Warehouseout> warehouseouts);
    //查询所有
    public List<Warehouseout> queryWarehouseout(Warehouseout warehouseout);
    //查询所有数量
    public int querycountWarehouseout(Warehouseout warehouseout);
    //改变状态
    public int updateWarehouseoutzhuang(int wid );
    public int updateWarehouseoutzhuangs(int wid );
}
