package com.guigu.controller;

import com.guigu.service.SupdruService;
import com.guigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SupdruController {
    @Autowired
    SupdruService supdruService;
    @RequestMapping("/queryallSupdruBydruid.action")
    @ResponseBody
    public List<Supdru> queryallSupdruBydruid( @RequestParam(value = "dru_id")Integer dru_id){
        System.out.println("-----"+dru_id);
        return supdruService.queryallSupdruBydruid(dru_id);
    }
    @RequestMapping("/queryallSupdru.action")
    @ResponseBody
    public PageVo<Supdru> querySupdru(Supdru supdru,
                                      @RequestParam(value = "sup_id",defaultValue = "0")Integer sup_id,
                                      @RequestParam(value = "dru_id",defaultValue = "0")Integer dru_id,
                                          @RequestParam(value = "page",defaultValue = "1") int page,
                                          @RequestParam(value = "rows",defaultValue = "5")int rows){
        Supplier supplier=new Supplier();
        supplier.setSup_id(sup_id);
        Drug drug=new Drug();
        drug.setDru_id(dru_id);
        supdru.setDrug(drug);
        supdru.setSupplier(supplier);
        return supdruService.querySupdru(supdru,page,rows);
    }
    @RequestMapping("/querySupdruBylistsupdruid.action")
    @ResponseBody
    public List<Supdru> querySupdruBylistsupdruid(String ids){
        String[] idss =ids.split(",");
        int[] idsss = new int[idss.length];
        for (int i = 0; i < idss.length; i++) {
            idsss[i] = Integer.parseInt(idss[i]);
        }
        return  supdruService.querySupdruBylistsupdruid(idsss);
    }
}
