package com.guigu.controller;

import com.guigu.service.DrugService;
import com.guigu.service.DrugTypeService;
import com.guigu.vo.DrugType;
import com.guigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DrugTypeController {
    @Autowired
    DrugTypeService drugTypeService;
    @RequestMapping("/queryDrugType.action")
    @ResponseBody
    public List<DrugType> queryDrugType(){
        return drugTypeService.queryDrugType();
    }

}
