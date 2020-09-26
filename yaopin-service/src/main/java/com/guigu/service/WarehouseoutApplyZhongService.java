package com.guigu.service;

import com.guigu.vo.WarehouseoutApply;
import com.guigu.vo.WarehouseoutApplyZhong;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseoutApplyZhongService {
    //添加
    public int addWarehouseoutApplyZhong(List<WarehouseoutApplyZhong> warehouseoutApplyZhongs);
    //根据订单ID查
    public List<WarehouseoutApplyZhong> queryWarehouseoutApplyZhongBywoaid(int woa_id);
    //根据出库申请表ID查
    public List<WarehouseoutApplyZhong> queryWarehouseoutApplyZhongBywid(int wid);
    //根据出库表ID以及供应商ID 仓库ID查
    public WarehouseoutApplyZhong queryWarehouseoutApplyZhongBywswid(
            @Param("wid") int wid,
            @Param("sup_id") int sup_id,
            @Param("war_id") int war_id,
            @Param("dru_id") int dru_id);
}
