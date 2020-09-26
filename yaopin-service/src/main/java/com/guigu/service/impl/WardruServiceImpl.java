package com.guigu.service.impl;

import com.guigu.dao.DrugJIDao;
import com.guigu.dao.WardruDao;
import com.guigu.service.WardruService;
import com.guigu.vo.Wardru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WardruServiceImpl  implements WardruService {
    @Autowired
    WardruDao wardruDao;


    @Override
    public List<Wardru> queryallWardru(int dru_id) {
        return wardruDao.queryallWardru(dru_id);
    }

    @Override
    public int deleteWardruBydruid(int[] ids) {
        return wardruDao.deleteWardruBydruid(ids);
    }

    @Override
    public int queryDrugkucun(int dru_id) {
        return wardruDao.queryDrugkucun(dru_id);
    }

    @Override
    public int addWardrulist(Wardru wardru) {
        return wardruDao.addWardrulist(wardru);
    }


    @Override
    public int updateWardru(Wardru wardru) {
        return wardruDao.updateWardru(wardru);
    }

    @Override
    public List<Wardru> queryallWardruu(int war_id, int dru_id) {
        return wardruDao.queryallWardruu(war_id,dru_id);
    }


    @Override
    public List<Wardru> queryallWardruuu() {
        return wardruDao.queryallWardruuu();
    }

    @Override
    public int updateWardrus(Wardru wardru) {
        return wardruDao.updateWardrus(wardru);
    }


    @Override
    public List<Wardru> queryallWardruBywid(int wid) {
        return wardruDao.queryallWardruBywid(wid);
    }

    @Override
    public List<Wardru> queryallWardruBysupdruid(int sup_id, int dru_id) {
        return wardruDao.queryallWardruBysupdruid(sup_id,dru_id);
    }

    @Override
    public Wardru queryallWardruBysupwarid(int supdru_id, int war_id) {
        return wardruDao.queryallWardruBysupwarid(supdru_id,war_id);
    }


}
