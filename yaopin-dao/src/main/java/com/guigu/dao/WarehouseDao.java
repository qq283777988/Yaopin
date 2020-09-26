package com.guigu.dao;

import com.guigu.vo.Drug;
import com.guigu.vo.Supdru;
import com.guigu.vo.Supplier;
import com.guigu.vo.Warehouse;
import net.sf.jsqlparser.statement.select.Wait;

import java.util.List;

public interface WarehouseDao {
    //根据ID查
    public List<Warehouse> queryallWarehouseBydruid(int dru_id);
    //查询所有
    public List<Warehouse> queryWarehouse(Warehouse warehouse);
    //查询所有
    public List<Warehouse> queryWarehousee();
    //查询所有数量
    public int querycountWarehouse(Warehouse warehouse);
    //根据ID查仓库
    public Warehouse queryWarehouseBywarid(int war_id);
    //根据供应商品中间表ID查
    public Warehouse queryWarehouseBywardruid(int id);
    //根据出库表ID查
    public List<Warehouse> queryWarehouseBywid(int wid);
}
