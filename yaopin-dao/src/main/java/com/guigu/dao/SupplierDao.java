package com.guigu.dao;



import com.guigu.vo.Supplier;

import java.util.List;

public interface SupplierDao {
    //根据ID查
    public List<Supplier> queryallSupplierBydruid(int dru_id);
    //查询所有
    public List<Supplier> querySupplier(Supplier supplier);
    //查询所有
    public List<Supplier> querySupplierr( );
    //查询所有数量
    public int querycountSupplier(Supplier supplier);
    //根据ID查供应商
    public Supplier querySupplierBysupid(int sup_id);
    //根据供应商品中间表ID查
    public Supplier querySupplierBysupdruid(int id);
}
