package com.guigu.service.impl;

import com.guigu.dao.DrugDao;
import com.guigu.dao.DrugTypeDao;
import com.guigu.service.DrugTypeService;
import com.guigu.vo.DrugType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugTypeServiceImpl implements DrugTypeService {
    @Autowired
    DrugTypeDao drugTypeDao;

    @Override
    public DrugType queryDrugTypeBydruid(int dru_id) {
        return drugTypeDao.queryDrugTypeBydruid(dru_id);
    }

    @Override
    public List<DrugType> queryDrugType() {
        return drugTypeDao.queryDrugType();
    }
}
