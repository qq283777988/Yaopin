package com.guigu.service.impl;

import com.guigu.dao.WarehouseoutApplyZhongDao;
import com.guigu.service.WarehouseoutApplyZhongService;
import com.guigu.vo.WarehouseoutApply;
import com.guigu.vo.WarehouseoutApplyZhong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseoutApplyZhongServiceImpl implements WarehouseoutApplyZhongService {
    @Autowired
    WarehouseoutApplyZhongDao warehouseoutApplyZhongDao;

    @Override
    public int addWarehouseoutApplyZhong(List<WarehouseoutApplyZhong> warehouseoutApplyZhongs) {
        return warehouseoutApplyZhongDao.addWarehouseoutApplyZhong(warehouseoutApplyZhongs);
    }

    @Override
    public List<WarehouseoutApplyZhong> queryWarehouseoutApplyZhongBywoaid(int woa_id) {
        return warehouseoutApplyZhongDao.queryWarehouseoutApplyZhongBywoaid(woa_id);
    }

    @Override
    public List<WarehouseoutApplyZhong> queryWarehouseoutApplyZhongBywid(int wid) {
        return warehouseoutApplyZhongDao.queryWarehouseoutApplyZhongBywid(wid);
    }

    @Override
    public WarehouseoutApplyZhong queryWarehouseoutApplyZhongBywswid(int wid, int sup_id, int war_id, int dru_id) {
        return warehouseoutApplyZhongDao.queryWarehouseoutApplyZhongBywswid(wid,sup_id,war_id,dru_id);
    }


}
