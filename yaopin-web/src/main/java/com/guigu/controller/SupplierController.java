package com.guigu.controller;

import com.guigu.service.SupplierService;
import com.guigu.vo.PageVo;
import com.guigu.vo.Supplier;
import com.guigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @RequestMapping("/querySupplier.action")
    @ResponseBody
    public PageVo<Supplier> querySupplier(Supplier supplier,
                                          @RequestParam(value = "page",defaultValue = "1") int page,
                                          @RequestParam(value = "rows",defaultValue = "3")int rows){
        return supplierService.querySupplier(supplier,page,rows);
    }
    @RequestMapping("/querySupplierr.action")
    @ResponseBody
    public List<Supplier> querySupplierr(){
        return supplierService.querySupplierr();
    }
    @RequestMapping("/querySupplierBydruid.action")
    @ResponseBody  //通知框架   返回的集合，vo，map  转成json格式  jackson.jar
    public  List<Supplier>  querySupplierBydruid(int dru_id)
    {
        return supplierService.queryallSupplierBydruid(dru_id);
    }
}
