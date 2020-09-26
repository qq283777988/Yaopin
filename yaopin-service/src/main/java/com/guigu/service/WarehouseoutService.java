package com.guigu.service;

import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.Warehouseout;

import java.util.List;

public interface WarehouseoutService {
    //添加
    public int addWarehouseout(List<Warehouseout> warehouseouts);
    //查询所有
    public PageVo<Warehouseout> queryWarehouseout(Warehouseout warehouseout, int page, int rows);
    //改变状态
    public int updateWarehouseoutzhuang(int wid );
    public int updateWarehouseoutzhuangs(int wid );
}
