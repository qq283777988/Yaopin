package com.guigu.service.impl;

import com.guigu.dao.DrugDao;
import com.guigu.dao.DrugJIDao;
import com.guigu.service.DrugJIService;
import com.guigu.vo.DrugJI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugJIServiceImpl implements DrugJIService {
    @Autowired
    DrugJIDao drugJIDao;
    @Override
    public DrugJI queryDrugJIBydruid(int dru_id) {
        return drugJIDao.queryDrugJIBydruid(dru_id);
    }

    @Override
    public List<DrugJI> queryDrugJI() {
        return drugJIDao.queryDrugJI();
    }
}
