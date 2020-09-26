package com.guigu.service;

import com.guigu.vo.Drug;
import com.guigu.vo.PageVo;
import com.guigu.vo.Warehouse;

import java.util.List;

public interface WarehouseServive {
    //根据ID查
    public List<Warehouse> queryallWarehouseBydruid(int dru_id);
    //查询所有
    public PageVo<Warehouse> queryWarehouse(Warehouse warehouse, int page, int rows);
    //查询所有
    public List<Warehouse> queryWarehousee( );
    //根据ID查仓库
    public Warehouse queryWarehouseBywarid(int war_id);
    //根据供应商品中间表ID查
    public Warehouse queryWarehouseBywardruid(int id);
    //根据出库表ID查
    public List<Warehouse> queryWarehouseBywid(int wid);
}
