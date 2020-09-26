package com.guigu.controller;

import com.guigu.service.DrugService;
import com.guigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DrugController {
    @Autowired
    DrugService drugService;
    @RequestMapping("/queryDrug.action")
    @ResponseBody
    public PageVo<Drug> queryDrug(Drug drug, String dru_typename, String dru_jiname, @RequestParam(value = "sup_id",defaultValue = "0") Integer sup_id, @RequestParam(value = "war_id",defaultValue = "0") Integer war_id, @RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "rows",defaultValue = "5")int rows){
            DrugType drugType=new DrugType();
            drugType.setDru_typename(dru_typename);
            DrugJI drugJI=new DrugJI();
            drugJI.setDru_jiname(dru_jiname);
            drug.setDrugJI(drugJI);
            drug.setDrugType(drugType);
            return drugService.queryDrug(drug,sup_id,war_id,page,rows);
    }
    @RequestMapping("/queryDrugg.action")
    @ResponseBody
    public List<Drug> queryDrugg(){

        return drugService.queryDrugg();
    }
    @RequestMapping("/queryDrugBydruidduo.action")
    @ResponseBody
    public List<Drug> queryDrugBydruidduo(String ids){
        String[] idss =ids.split(",");
        int[] idsss = new int[idss.length];
        for (int i = 0; i < idss.length; i++) {
            idsss[i] = Integer.parseInt(idss[i]);
        }
        return  drugService.queryDrugBydruidduo(idsss);
    }
}
