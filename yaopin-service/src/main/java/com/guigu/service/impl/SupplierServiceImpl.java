package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.SupplierDao;
import com.guigu.dao.WarehouseDao;
import com.guigu.service.SupplierService;
import com.guigu.vo.PageVo;
import com.guigu.vo.Supplier;
import com.guigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl  implements SupplierService {
    @Autowired
    SupplierDao supplierDao;
    @Override
    public List<Supplier> queryallSupplierBydruid(int dru_id) {
        return supplierDao.queryallSupplierBydruid(dru_id);
    }

    @Override
    public PageVo<Supplier> querySupplier(Supplier supplier, int page, int rows) {
        PageVo<Supplier> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(supplierDao.querySupplier(supplier));
        //获取总的记录数量
        pageVo.setTotal(supplierDao.querycountSupplier(supplier));
        return pageVo;
    }

    @Override
    public List<Supplier> querySupplierr() {
        return supplierDao.querySupplierr();
    }

    @Override
    public Supplier querySupplierBysupid(int sup_id) {
        return supplierDao.querySupplierBysupid(sup_id);
    }

    @Override
    public Supplier querySupplierBysupdruid(int id) {
        return supplierDao.querySupplierBysupdruid(id);
    }


}
