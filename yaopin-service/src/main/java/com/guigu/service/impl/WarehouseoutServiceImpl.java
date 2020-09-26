package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.WarehouseoutDao;
import com.guigu.service.WarehouseoutService;
import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.Warehouseout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseoutServiceImpl  implements WarehouseoutService {
    @Autowired
    WarehouseoutDao warehouseoutDao;

    @Override
    public int addWarehouseout(List<Warehouseout> warehouseouts) {
        return warehouseoutDao.addWarehouseout(warehouseouts);
    }

    @Override
    public PageVo<Warehouseout> queryWarehouseout(Warehouseout warehouseout, int page, int rows) {
        PageVo<Warehouseout> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(warehouseoutDao.queryWarehouseout(warehouseout));
        //获取总的记录数量
        pageVo.setTotal(warehouseoutDao.querycountWarehouseout(warehouseout));

        return pageVo;
    }

    @Override
    public int updateWarehouseoutzhuang(int wid) {
        return warehouseoutDao.updateWarehouseoutzhuang(wid);
    }

    @Override
    public int updateWarehouseoutzhuangs(int wid) {
        return warehouseoutDao.updateWarehouseoutzhuangs(wid);
    }


}
