package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.WarehouseDao;
import com.guigu.dao.WarehousingDao;
import com.guigu.service.WarehousingService;
import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.Warehousing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehousingServiceImpl implements WarehousingService {
    @Autowired
    WarehousingDao warehousingDao;
    @Override
    public int addWarehousing(List<Warehousing> warehousings) {
        return warehousingDao.addWarehousing(warehousings);
    }

    @Override
    public PageVo<Warehousing> queryWarehousing(Warehousing warehousing, int page, int rows) {
        PageVo<Warehousing> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(warehousingDao.queryWarehousing(warehousing));
        //获取总的记录数量
        pageVo.setTotal(warehousingDao.querycountWarehousing(warehousing));

        return pageVo;
    }

    @Override
    public int updateWarehousingstate(int[] wah_id) {
        return warehousingDao.updateWarehousingstate(wah_id);
    }

    @Override
    public int updateWarehousingstates(int[] wah_id) {
        return warehousingDao.updateWarehousingstates(wah_id);
    }
}
