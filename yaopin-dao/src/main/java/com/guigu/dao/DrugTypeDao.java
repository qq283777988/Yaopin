package com.guigu.dao;

import com.guigu.vo.DrugType;

import java.util.List;

public interface DrugTypeDao {
    //根据药品ID查
    public DrugType queryDrugTypeBydruid(int dru_id);
    public List<DrugType> queryDrugType();
}
