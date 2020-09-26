package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.EmployeeDao;
import com.guigu.dao.WarehouseDao;
import com.guigu.service.WarehouseServive;
import com.guigu.vo.Drug;
import com.guigu.vo.PageVo;
import com.guigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehouseServiveImpl implements WarehouseServive {
    @Autowired
    WarehouseDao warehouseDao;
    @Override
    public List<Warehouse> queryallWarehouseBydruid(int dru_id) {
        return warehouseDao.queryallWarehouseBydruid(dru_id);
    }

    @Override
    public PageVo<Warehouse> queryWarehouse(Warehouse warehouse, int page, int rows) {
        PageVo<Warehouse> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(warehouseDao.queryWarehouse(warehouse));
        //获取总的记录数量
        pageVo.setTotal(warehouseDao.querycountWarehouse(warehouse));
        return pageVo;
    }

    @Override
    public List<Warehouse> queryWarehousee( ) {
        return warehouseDao.queryWarehousee();
    }

    @Override
    public Warehouse queryWarehouseBywarid(int war_id) {
        return warehouseDao.queryWarehouseBywarid(war_id);
    }

    @Override
    public Warehouse queryWarehouseBywardruid(int id) {
        return warehouseDao.queryWarehouseBywardruid(id);
    }

    @Override
    public List<Warehouse> queryWarehouseBywid(int wid) {
        return warehouseDao.queryWarehouseBywid(wid);
    }


}
