package com.guigu.service;

import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.Warehousing;

import java.util.List;

public interface WarehousingService {
    //添加
    public int addWarehousing(List<Warehousing> warehousings);
    //查询所有
    public PageVo<Warehousing> queryWarehousing(Warehousing warehousing, int page, int rows);
    //更改状态
    public int updateWarehousingstate(int []wah_id );
    public int updateWarehousingstates(int []wah_id );
}
