package com.guigu.service;

import com.guigu.vo.PageVo;
import com.guigu.vo.Supplier;
import com.guigu.vo.Warehouse;

import java.util.List;

public interface SupplierService {
    //根据ID查
    public List<Supplier> queryallSupplierBydruid(int dru_id);
    //查询所有
    public PageVo<Supplier> querySupplier(Supplier supplier, int page, int rows);
    //普通查询所有
    //查询所有
    public List<Supplier> querySupplierr( );
    //根据ID查供应商
    public Supplier querySupplierBysupid(int sup_id);
    //根据供应商品中间表ID查
    public Supplier querySupplierBysupdruid(int id);

}
