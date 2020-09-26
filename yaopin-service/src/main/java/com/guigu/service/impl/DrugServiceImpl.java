package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.DrugDao;
import com.guigu.dao.EmployeeDao;
import com.guigu.service.DrugService;
import com.guigu.vo.Drug;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugServiceImpl  implements DrugService {
    @Autowired
    DrugDao drugDao;

    @Override
    public PageVo<Drug> queryDrug(Drug drug,int sup_id,int war_id, int page, int rows) {
        PageVo<Drug> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(drugDao.queryDrug(drug,sup_id,war_id));
        //获取总的记录数量
        pageVo.setTotal(drugDao.querycountDrug(drug,sup_id,war_id));
        return pageVo;
    }

    @Override
    public List<Drug> queryDrugg() {
        return drugDao.queryDrugg();
    }

    @Override
    public int addDrug(Drug drug) {
        return drugDao.addDrug(drug);
    }

    @Override
    public int deleteDrug(int[] ids) {
        return drugDao.deleteDrug(ids);
    }

    @Override
    public int updateDrug(Drug drug) {
        return drugDao.updateDrug(drug);
    }

    @Override
    public Drug queryDrugBydruid(int dru_id) {
        return drugDao.queryDrugBydruid(dru_id);
    }

    @Override
    public List<Drug> queryDrugBysupid(int sup_id) {
        return drugDao.queryDrugBysupid(sup_id);
    }

    @Override
    public List<Drug> queryDrugBywarid(int war_id) {
        return drugDao.queryDrugBywarid(war_id);
    }

    @Override
    public Drug queryDrugBywardruid(int id) {
        return drugDao.queryDrugBywardruid(id);
    }

    @Override
    public Drug queryDrugBysupdruid(int id) {
        return drugDao.queryDrugBysupdruid(id);
    }

    @Override
    public List<Drug> queryDrugBywahid(int wah_id) {
        return drugDao.queryDrugBywahid(wah_id);
    }

    @Override
    public List<Drug> queryDrugBydruidduo(int[] dru_id) {
        return drugDao.queryDrugBydruidduo(dru_id);
    }

    @Override
    public List<Drug> queryDrugBywid(int wid) {
        return drugDao.queryDrugBywid(wid);
    }


}
