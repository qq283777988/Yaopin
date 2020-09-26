package com.guigu.controller;

import com.guigu.service.DrugJIService;
import com.guigu.service.DrugTypeService;
import com.guigu.vo.DrugJI;
import com.guigu.vo.DrugType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DrugJIController {
    @Autowired
    DrugJIService drugJIService;
    @RequestMapping("/queryDrugJI.action")
    @ResponseBody
    public List<DrugJI> queryDrugJI(){
        return drugJIService.queryDrugJI();
    }
}
