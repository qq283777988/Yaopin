package com.guigu.service;

import com.guigu.vo.Drug;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;

import java.util.List;

public interface DrugService {
    //查询所有
    public PageVo<Drug> queryDrug(Drug drug,int sup_id,int war_id, int page, int rows);
    public List<Drug> queryDrugg();
    //添加
    public int addDrug(Drug drug);
    //删除
    public int deleteDrug(int[] ids);
    //修改
    public int updateDrug(Drug drug);
    //根据ID查
    public Drug queryDrugBydruid(int dru_id);
    //根据供应商ID查
    public List<Drug> queryDrugBysupid(int sup_id);
    //根据仓库ID查
    public List<Drug> queryDrugBywarid(int war_id);
    //根据仓库中间表ID查
    public Drug queryDrugBywardruid(int id);
    //根据供应商中间表ID查
    public Drug queryDrugBysupdruid(int id);
    //根据入库申请表ID查药品ID
    public List<Drug> queryDrugBywahid(int wah_id);
    //根据多个药品id查
    public List<Drug> queryDrugBydruidduo(int []dru_id);
    //根据出库表ID查
    public List<Drug> queryDrugBywid(int wid);
}
