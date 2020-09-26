package com.guigu.controller;

import com.guigu.service.WarehouseoutApplyService;
import com.guigu.service.WarehouseoutApplyZhongService;
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
public class WarehouseoutApplyZhongController {
    @Autowired
    WarehouseoutApplyZhongService warehouseoutApplyZhongService;
    @Autowired
    WarehouseoutApplyService warehouseoutApplyService;
    @RequestMapping(value ="/addWarehouseoutApplyZhong.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addWarehouseoutApplyZhong(int cus_id,String mids, String countlist, String zjialist, int zcount, double zjia, String canglist,String gonglist, HttpSession session){
        System.out.println("0--"+cus_id);
        System.out.println("1--"+mids);
        System.out.println("2--"+countlist);
        System.out.println("3--"+zjialist);
        System.out.println("4--"+zcount);
        System.out.println("5--"+zjia);
        System.out.println("6--"+canglist);
        System.out.println("7--"+gonglist);
        WarehouseoutApply warehouseoutApply=new WarehouseoutApply();
        Customer customer=new Customer();
        customer.setCus_id(cus_id);
        warehouseoutApply.setCustomer(customer);
        warehouseoutApply.setWoa_zcount(zcount);
        warehouseoutApply.setWoa_zjia(zjia);
        Employee employee=(Employee) session.getAttribute("employee");
        warehouseoutApply.setEmployee(employee);
        int num1=warehouseoutApplyService.addWarehouseoutApply(warehouseoutApply);
        System.out.println("添加新的"+num1);
        String[] midss = mids.split(",");
        String[] countlistt= countlist.split(",");
        String[] zjialistt = zjialist.split(",");
        String[] canglistt = canglist.split(",");
        String[] gonglistt = gonglist.split(",");
        List<WarehouseoutApplyZhong> warehouseoutApplyZhongList=new ArrayList<>();
        WarehouseoutApply warehouseoutApply1=warehouseoutApplyService.queryWarehouseoutApplyBywoaid(warehouseoutApply.getWoa_id());
        for(int i=0;i<midss.length;i++){
            WarehouseoutApplyZhong warehouseoutApplyZhong=new WarehouseoutApplyZhong();
            warehouseoutApplyZhong.setWarehouseoutApply(warehouseoutApply1);
            Drug drug=new Drug();
            drug.setDru_id(Integer.parseInt(midss[i]));
            warehouseoutApplyZhong.setDrug(drug);
            Warehouse warehouse=new Warehouse();
            warehouse.setWar_id(Integer.parseInt(canglistt[i]));
            Supplier supplier=new Supplier();
            supplier.setSup_id(Integer.parseInt(gonglistt[i]));
            warehouseoutApplyZhong.setSupplier(supplier);
            warehouseoutApplyZhong.setWarehouse(warehouse);
            warehouseoutApplyZhong.setWoa_zcount(Integer.parseInt(countlistt[i]));
            warehouseoutApplyZhong.setWoa_zjia(Double.parseDouble(zjialistt[i]));
            warehouseoutApplyZhongList.add(warehouseoutApplyZhong);
        }
        int num=warehouseoutApplyZhongService.addWarehouseoutApplyZhong(warehouseoutApplyZhongList);

        if(num==midss.length){
            return "操作成功";
        }
        return "操作失败";
    }
    @RequestMapping("/queryWarehouseoutApplyZhongBywoaid.action")
    @ResponseBody
    public List<WarehouseoutApplyZhong> queryWarehouseoutApplyZhongBywoaid( @RequestParam(value = "woa_id")Integer woa_id){
        return warehouseoutApplyZhongService.queryWarehouseoutApplyZhongBywoaid(woa_id);
    }
    @RequestMapping("/queryWarehouseoutApplyZhongBywid.action")
    @ResponseBody
    public List<WarehouseoutApplyZhong> queryWarehouseoutApplyZhongBywid( @RequestParam(value = "wid")Integer wid){
        return warehouseoutApplyZhongService.queryWarehouseoutApplyZhongBywid(wid);
    }
}
