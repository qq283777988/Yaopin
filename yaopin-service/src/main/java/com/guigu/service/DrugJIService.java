package com.guigu.service;

import com.guigu.vo.DrugJI;

import java.util.List;

public interface DrugJIService {
    //根据药品ID查
    public DrugJI queryDrugJIBydruid(int dru_id);
    public List<DrugJI> queryDrugJI();
}
