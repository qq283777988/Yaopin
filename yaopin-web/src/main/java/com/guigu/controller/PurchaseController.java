package com.guigu.controller;

import com.guigu.service.PurchaseApplyService;
import com.guigu.service.PurchaseService;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import com.guigu.vo.Purchase;
import com.guigu.vo.PurchaseApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    PurchaseApplyService purchaseApplyService;
    @RequestMapping(value ="/addpurchase.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addpurchase(String mids, HttpSession session){
        System.out.println("分:"+mids);
        List<Purchase> purchaseList=new ArrayList<>();
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        for(String s:midss){
            Purchase purchase=new Purchase();
            PurchaseApply purchaseApply=new PurchaseApply();
            purchaseApply.setPua_id(Integer.parseInt(s));
            purchase.setPurchaseApply(purchaseApply);
            Employee employee=(Employee) session.getAttribute("employee");
            purchase.setEmployee(employee);
            purchaseList.add(purchase);
        }
        int nm=purchaseService.addPurchase(purchaseList);
        if(nm==midss.length){
            int num=purchaseApplyService.updatePurchaseApplyzhuang(idsss);
            if(num==idsss.length){
                return  "操作成功";
            }

        }
        return  "操作失败";
    }
    @RequestMapping(value ="/addpurchases.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addpurchases(String mids, HttpSession session){
        System.out.println("分:"+mids);
        List<Purchase> purchaseList=new ArrayList<>();
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
      /*  for(String s:midss){
            Purchase purchase=new Purchase();
            PurchaseApply purchaseApply=new PurchaseApply();
            purchaseApply.setPua_id(Integer.parseInt(s));
            purchase.setPurchaseApply(purchaseApply);
            Employee employee=(Employee) session.getAttribute("employee");
            purchase.setEmployee(employee);
            purchaseList.add(purchase);
        }*/
      /*  int nm=purchaseService.addPurchases(purchaseList);
        if(nm==midss.length){*/
           int num=purchaseApplyService.updatePurchaseApplyzhuangs(idsss);
           if(num==idsss.length){
                return  "操作成功";
            }
         /*   return  "操作成功";*/
      /*  }*/
        return  "操作失败";
    }
    @RequestMapping("/queryPurchase.action")
    @ResponseBody
    public PageVo<Purchase> queryPurchase(Purchase purchase,
                                                    @RequestParam(value = "page",defaultValue = "1") int page,
                                                    @RequestParam(value = "rows",defaultValue = "5")int rows){

        return purchaseService.queryPurchase(purchase,page,rows);
    }
    @RequestMapping(value ="/updatePurchasezhuang.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updatePurchasezhuang(String mids, HttpSession session){
        System.out.println("分:"+mids);
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        int num=purchaseService.updatePurchasezhuang(idsss);
        if(num==idsss.length){
            return  "操作成功";
        }

        return  "操作失败";
    }
    @RequestMapping(value ="/updatePurchasezhuangs.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updatePurchasezhuangs(String mids, HttpSession session){
        System.out.println("分:"+mids);
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        int num=purchaseService.updatePurchasezhuangs(idsss);
        if(num==idsss.length){
            return  "操作成功";
        }

        return  "操作失败";
    }
}
