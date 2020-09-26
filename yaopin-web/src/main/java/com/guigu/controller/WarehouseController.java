package com.guigu.controller;

import com.guigu.service.DrugService;
import com.guigu.service.WarehouseServive;
import com.guigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WarehouseController {
    @Autowired
    WarehouseServive warehouseServive;
    @RequestMapping("/queryWarehouse.action")
    @ResponseBody
    public PageVo<Warehouse> queryEmployee(Warehouse warehouse,
                                      @RequestParam(value = "page",defaultValue = "1") int page,
                                      @RequestParam(value = "rows",defaultValue = "3")int rows){
        return warehouseServive.queryWarehouse(warehouse,page,rows);
    }
    @RequestMapping("/queryWarehousee.action")
    @ResponseBody
    public List<Warehouse> queryWarehousee(){
        return warehouseServive.queryWarehousee();
    }
    @RequestMapping("/queryWarehouseeBydruid.action")
    @ResponseBody  //通知框架   返回的集合，vo，map  转成json格式  jackson.jar
    public  List<Warehouse>  queryWarehouseeBydruid(int dru_id)
    {
        return warehouseServive.queryallWarehouseBydruid(dru_id);
    }
}
