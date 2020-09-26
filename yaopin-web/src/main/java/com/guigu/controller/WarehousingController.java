package com.guigu.controller;

import com.guigu.service.PurchaseService;
import com.guigu.service.WarehouseServive;
import com.guigu.service.WarehousingService;
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
public class WarehousingController {
    @Autowired
    WarehousingService warehousingService;
    @Autowired
    PurchaseService purchaseService;
    @RequestMapping(value ="/addwarehousing.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addwarehousing(String mids, HttpSession session){
        System.out.println("分:"+mids);
        List<Warehousing> warehousingList=new ArrayList<>();
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        for(String s:midss){
            Warehousing warehousing=new Warehousing();
            Purchase purchase=new Purchase();
            purchase.setPid(Integer.parseInt(s));
            warehousing.setPurchase(purchase);
            Employee employee=(Employee) session.getAttribute("employee");
            warehousing.setEmployee(employee);
            warehousingList.add(warehousing);
        }
        int nm=warehousingService.addWarehousing(warehousingList);
        if(nm==midss.length){
            int num=purchaseService.updatePurchasezhuang(idsss);
            if(num==idsss.length){
                return  "操作成功";
            }

        }
        return  "操作失败";
    }
    @RequestMapping("/queryWarehousing.action")
    @ResponseBody
    public PageVo<Warehousing> queryWarehousing(Warehousing warehousing,
                                          @RequestParam(value = "page",defaultValue = "1") int page,
                                          @RequestParam(value = "rows",defaultValue = "5")int rows){

        return warehousingService.queryWarehousing(warehousing,page,rows);
    }
   /* @RequestMapping(value ="/updateWarehousingstate.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updateWarehousingstate(String mids, HttpSession session){
        System.out.println("分:"+mids);
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        int num=warehousingService.updateWarehousingstate(idsss);
        if(num==idsss.length){
            return  "操作成功";
        }

        return  "操作失败";
    }*/
    @RequestMapping(value ="/updateWarehousingstates.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updateWarehousingstates(String mids, HttpSession session){
        System.out.println("分:"+mids);
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        int num=warehousingService.updateWarehousingstates(idsss);
        if(num==idsss.length){
            return  "操作成功";
        }

        return  "操作失败";
    }
}
