package com.guigu.controller;

import com.guigu.service.WarehouseoutApplyService;
import com.guigu.service.WarehouseoutService;
import com.guigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WarehouseoutController {
    @Autowired
    WarehouseoutService warehouseoutService;
    @Autowired
    WarehouseoutApplyService warehouseoutApplyService;
    @RequestMapping(value ="/addWarehouseout.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addWarehouseout(String mids, HttpSession session){
        System.out.println("分:"+mids);
        List<Warehouseout> warehouseoutList=new ArrayList<>();
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        for(String s:midss){
            Warehouseout warehouseout=new Warehouseout();
            WarehouseoutApply warehouseoutApply=new WarehouseoutApply();
            warehouseoutApply.setWoa_id(Integer.parseInt(s));
            warehouseout.setWarehouseoutApply(warehouseoutApply);
            Employee employee=(Employee) session.getAttribute("employee");
            warehouseout.setEmployee(employee);
            warehouseoutList.add(warehouseout);
        }
        int nm=warehouseoutService.addWarehouseout(warehouseoutList);
        if(nm==midss.length){
            int num=warehouseoutApplyService.updateWarehouseoutApplyzhuang(idsss);
            if(num==idsss.length){
                return  "操作成功";
            }
        }
        return  "操作失败";
    }
    @RequestMapping("/queryWarehouseout.action")
    @ResponseBody
    public PageVo<Warehouseout> queryWarehouseout(Warehouseout warehouseout,
                                          @RequestParam(value = "page",defaultValue = "1") int page,
                                          @RequestParam(value = "rows",defaultValue = "5")int rows){

        return warehouseoutService.queryWarehouseout(warehouseout,page,rows);
    }

}
