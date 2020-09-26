package com.guigu.controller;

import com.guigu.dao.WarehouseoutApplyDao;
import com.guigu.service.WarehouseoutApplyService;
import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.WarehouseoutApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WarehouseoutApplyController {
    @Autowired
    WarehouseoutApplyService warehouseoutApplyService;
    @RequestMapping("/queryWarehouseoutApply.action")
    @ResponseBody
    public PageVo<WarehouseoutApply> queryWarehouseoutApply(WarehouseoutApply warehouseoutApply,
                                                        @RequestParam(value = "page",defaultValue = "1") int page,
                                                        @RequestParam(value = "rows",defaultValue = "5")int rows){

        return warehouseoutApplyService.queryWarehouseoutApply(warehouseoutApply,page,rows);
    }
    @RequestMapping(value ="/updateWarehouseoutApplyzhuangs.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updateWarehouseoutApplyzhuangs(String mids, HttpSession session){
        System.out.println("分:"+mids);
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }

        int num=warehouseoutApplyService.updateWarehouseoutApplyzhuangs(idsss);
        if(num==idsss.length){
            return  "操作成功";
        }
        return  "操作失败";
    }
}
