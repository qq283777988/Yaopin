package com.guigu.service;

import com.guigu.vo.DrugType;

import java.util.List;

public interface DrugTypeService {
    //根据药品ID查
    public DrugType queryDrugTypeBydruid(int dru_id);
    public List<DrugType> queryDrugType();
}
