package com.guigu.dao;

import com.guigu.vo.Purchase;
import com.guigu.vo.Warehousing;

import java.util.List;

public interface WarehousingDao {
    //添加
    public int addWarehousing(List<Warehousing> warehousings);
    //更改状态
    public int updateWarehousingstate(int []wah_id );
    public int updateWarehousingstates(int []wah_id );
    //查询所有
    public List<Warehousing> queryWarehousing(Warehousing warehousing);
    //查询所有数量
    public int querycountWarehousing(Warehousing warehousing);

}
