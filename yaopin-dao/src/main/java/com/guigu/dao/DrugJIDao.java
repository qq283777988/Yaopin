package com.guigu.dao;

import com.guigu.vo.DrugJI;

import java.util.List;

public interface DrugJIDao {
    //根据药品ID查
    public DrugJI queryDrugJIBydruid(int dru_id);
    public List<DrugJI> queryDrugJI();
}
