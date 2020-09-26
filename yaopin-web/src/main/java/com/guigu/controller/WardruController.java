package com.guigu.controller;
import com.guigu.service.*;
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
public class WardruController {
    @Autowired
    WardruService wardruService;
    @Autowired
    DrugService drugService;
    @Autowired
    PurchaseApplyZhongService purchaseApplyZhongService;
    @Autowired
    PurchaseApplyService purchaseApplyService;
    @Autowired
    WarehousingService warehousingService;
    @Autowired
    SupdruService supdruService;
    @Autowired
    WarehouseoutApplyZhongService warehouseoutApplyZhongService;
    @Autowired
    WarehouseServive warehouseServive;
    @Autowired
    WarehouseoutApplyService warehouseoutApplyService;
    @Autowired
    WarehouseoutService warehouseoutService;

    @RequestMapping("/queryallWardru.action")
    @ResponseBody
    public List<Wardru> queryallWardru(@RequestParam(value = "dru_id") Integer dru_id) {

        return wardruService.queryallWardru(dru_id);
    }

    @RequestMapping("/queryDrugkucun.action")
    @ResponseBody
    public int queryDrugkucun(@RequestParam(value = "dru_id", defaultValue = "1") Integer dru_id) {

        return wardruService.queryDrugkucun(dru_id);
    }
    @RequestMapping("/queryallWardruBysupdruid.action")
    @ResponseBody
    public List<Wardru> queryallWardruBysupdruid(@RequestParam(value = "sup_id") Integer sup_id,@RequestParam(value = "dru_id") Integer dru_id) {

        return wardruService.queryallWardruBysupdruid(sup_id,dru_id);
    }
    @RequestMapping(value = "/ruku.action", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String ruku(String mids, @RequestParam(value = "war_id") Integer war_id, HttpSession session) {
        String[] midss = mids.split(",");
        int[] idsss = new int[midss.length];
        for (int i = 0; i < midss.length; i++) {
            idsss[i] = Integer.parseInt(midss[i]);
        }
        int znum = 0;
        int ysizez = 0;
        for (String s : midss) {
            //2---查询订单所有药品ID
            List<Supdru> drugs = supdruService.querySupdruBywahid(Integer.parseInt(s));
            int ysize = drugs.size();

            ysizez = ysizez + ysize;
            //3-查询订单所有药品数量
            List<PurchaseApplyZhong> purchaseApplyZhongs = purchaseApplyZhongService.queryPurchaseApplyZhongBywahid(Integer.parseInt(s));
            //4-拿到所有仓库ID
            List<Wardru> wardruList = new ArrayList<>();
            for (int i = 0; i < drugs.size(); i++) {
                List<Wardru> wardrus = wardruService.queryallWardruu(war_id, drugs.get(i).getDrug().getDru_id());
              /*  System.out.println("根据drugID warId 查询 ： wardrus = " + wardrus);
                System.out.println("根据drugID warId 查询 ： war_id = " + war_id);
                System.out.println("根据drugID warId 查询 ： drugs_id = " + drugs.get(i).getDru_id());*/
                //drugID warId  ---- > 数据库查询 有没有这个药品----》 true/false
                if (wardrus.size() >= 1) {
                    //根据drugID warId修改药品数量

                    Wardru wardru = new Wardru();
                    Warehouse warehouse = new Warehouse();
                    warehouse.setWar_id(war_id);
                    wardru.setWarehouse(warehouse);
                    wardru.setKu_cun(purchaseApplyZhongs.get(i).getPua_zcount());
                    Supdru supdru = new Supdru();
                    supdru.setId(drugs.get(i).getId());
                    wardru.setSupdru(supdru);
                    znum = znum + wardruService.updateWardru(wardru);
                } else {
                    //根据drugID warId
                    Wardru wardru = new Wardru();
                    Warehouse warehouse = new Warehouse();
                    warehouse.setWar_id(war_id);
                    wardru.setWarehouse(warehouse);
                    wardru.setKu_cun(purchaseApplyZhongs.get(i).getPua_zcount());
                    Supdru supdru = new Supdru();
                    supdru.setId(drugs.get(i).getId());
                    wardru.setSupdru(supdru);
                    znum = znum + wardruService.addWardrulist(wardru);
                }
            }
        }
        if (znum == ysizez) {
            int n = warehousingService.updateWarehousingstate(idsss);
            if (n == idsss.length) {
                return "操作成功";
            }
        }
        return "操作失败";
    }
    @RequestMapping(value = "/chuku.action", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String chuku(@RequestParam(value = "wid") Integer wid, HttpSession session) {

       //先查库存表中是否存在 不存在直接报库存不足 确认补货后 添加到仓库
        List<Supdru> supdrus=new ArrayList<>();
        List<Warehouse> warehouses=warehouseServive.queryWarehouseBywid(wid);
        List<Drug>drugs=drugService.queryDrugBywid(wid);
        for(int i=0;i<drugs.size();i++){
            Supdru supdru=supdruService.querySupdruBywiddruidwarid(wid,drugs.get(i).getDru_id(),warehouses.get(i).getWar_id());
            supdrus.add(supdru);
        }
       /*List<Supdru> supdrus=supdruService.querySupdruBywid(wid);*/

        System.out.println("仓库的"+drugs);
        //库存够的集合
        List<WarehouseoutApplyZhong>warehouseoutApplyZhongListgou=new ArrayList<>();
        //库存不够的集合
       List<WarehouseoutApplyZhong>warehouseoutApplyZhongListbugou=new ArrayList<>();
       //添加后的

       for(int i=0;i<warehouses.size();i++){
           Wardru wardru=wardruService.queryallWardruBysupwarid(supdrus.get(i).getId(),warehouses.get(i).getWar_id());
            if(wardru!=null){
                WarehouseoutApplyZhong warehouseoutApplyZhong=
                        warehouseoutApplyZhongService.queryWarehouseoutApplyZhongBywswid(
                                wid,supdrus.get(i).getSupplier().getSup_id(),
                                warehouses.get(i).getWar_id(),
                                drugs.get(i).getDru_id());
                System.out.println( supdrus.get(i).getSupplier().getSup_id()+"11"+warehouseoutApplyZhong);
                System.out.println( warehouses.get(i).getWar_id()+"22"+warehouseoutApplyZhong);
                System.out.println( drugs.get(i).getDru_id()+"33"+warehouseoutApplyZhong);
                warehouseoutApplyZhongListgou.add(warehouseoutApplyZhong);

            }else{
                System.out.println(i+"这个没有");
                WarehouseoutApplyZhong warehouseoutApplyZhong=
                        warehouseoutApplyZhongService.queryWarehouseoutApplyZhongBywswid(
                                wid,supdrus.get(i).getSupplier().getSup_id(),
                                warehouses.get(i).getWar_id(),
                                drugs.get(i).getDru_id());
                System.out.println(warehouseoutApplyZhong);
                warehouseoutApplyZhongListbugou.add(warehouseoutApplyZhong);
                /*//出库申请表
                WarehouseoutApply warehouseoutApply=new WarehouseoutApply();
                Customer customer=new Customer();
                customer.setCus_id(warehouseoutApplyZhong.getWarehouseoutApply().getCustomer().getCus_id());
                warehouseoutApply.setCustomer(customer);
                warehouseoutApply.setWoa_zcount(warehouseoutApplyZhong.getWarehouseoutApply().getWoa_zcount());
                warehouseoutApply.setWoa_zjia(warehouseoutApplyZhong.getWarehouseoutApply().getWoa_zjia());
                Employee employee=(Employee)session.getAttribute("employee");
                warehouseoutApply.setEmployee(employee);
                int num1=warehouseoutApplyService.addWarehouseoutApply(warehouseoutApply);

                //出库申请
                WarehouseoutApply warehouseoutApply1=warehouseoutApplyService.queryWarehouseoutApplyBywoaid(warehouseoutApply.getWoa_id());
                WarehouseoutApplyZhong warehouseoutApplyZhong1=new WarehouseoutApplyZhong();
                warehouseoutApplyZhong1.setWarehouseoutApply(warehouseoutApply1);
                warehouseoutApplyZhong1.setDrug(warehouseoutApplyZhong.getDrug());
                warehouseoutApplyZhong1.setSupplier(warehouseoutApplyZhong.getSupplier());
                warehouseoutApplyZhong1.setWarehouse(warehouseoutApplyZhong.getWarehouse());
                warehouseoutApplyZhong.setWoa_zcount(warehouseoutApplyZhong.getWoa_zcount());
                warehouseoutApplyZhong1.setWoa_zjia(warehouseoutApplyZhong.getWoa_zjia());
                warehouseoutApplyZhongList1.add(warehouseoutApplyZhong1);*/
            }
       }
       if(warehouseoutApplyZhongListbugou.size()>=1){
           warehouseoutService.updateWarehouseoutzhuangs(wid);
          // List<WarehouseoutApplyZhong> warehouseoutApplyZhongList1=new ArrayList<>();
           List<PurchaseApplyZhong> purchaseApplyZhongList=new ArrayList<>();
           for(int i=0;i<warehouseoutApplyZhongListbugou.size();i++){
               PurchaseApply purchaseApply=new PurchaseApply();
               purchaseApply.setPua_zjia(warehouseoutApplyZhongListbugou.get(i).getWarehouseoutApply().getWoa_zjia());
                purchaseApply.setPua_zcount(warehouseoutApplyZhongListbugou.get(i).getWarehouseoutApply().getWoa_zcount());
               Employee employee=(Employee)session.getAttribute("employee");
               purchaseApply.setEmployee(employee);
               int num1=purchaseApplyService.addPurchaseApply(purchaseApply);


               PurchaseApplyZhong purchaseApplyZhong=new PurchaseApplyZhong();
               PurchaseApply purchaseApply1=purchaseApplyService.queryPurchaseApplyBypuaid(purchaseApply.getPua_id());
               purchaseApplyZhong.setPurchaseApply(purchaseApply1);
               Supdru supdru=supdruService.queryallSupdruBysupdruid(
                       warehouseoutApplyZhongListbugou.get(i).getSupplier().getSup_id(),
                       warehouseoutApplyZhongListbugou.get(i).getDrug().getDru_id()
               );
               purchaseApplyZhong.setSupdru(supdru);
               purchaseApplyZhong.setPua_zcount(warehouseoutApplyZhongListbugou.get(i).getWoa_zcount());
               purchaseApplyZhong.setPua_zjia(warehouseoutApplyZhongListbugou.get(i).getWoa_zjia());
               purchaseApplyZhongList.add(purchaseApplyZhong);
           /*    //出库申请
               WarehouseoutApply warehouseoutApply1=warehouseoutApplyService.queryWarehouseoutApplyBywoaid(warehouseoutApply.getWoa_id());
               WarehouseoutApplyZhong warehouseoutApplyZhong1=new WarehouseoutApplyZhong();
               warehouseoutApplyZhong1.setWarehouseoutApply(warehouseoutApply1);
               warehouseoutApplyZhong1.setDrug(warehouseoutApplyZhongListbugou.get(i).getDrug());
               warehouseoutApplyZhong1.setSupplier(warehouseoutApplyZhongListbugou.get(i).getSupplier());
               warehouseoutApplyZhong1.setWarehouse(warehouseoutApplyZhongListbugou.get(i).getWarehouse());
               warehouseoutApplyZhong1.setWoa_zcount(warehouseoutApplyZhongListbugou.get(i).getWoa_zcount());
               warehouseoutApplyZhong1.setWoa_zjia(warehouseoutApplyZhongListbugou.get(i).getWoa_zjia());
               warehouseoutApplyZhongList1.add(warehouseoutApplyZhong1);*/

           }
           int num2=purchaseApplyZhongService.addPurchaseApplyZhong(purchaseApplyZhongList);
           int numm=warehouseoutService.updateWarehouseoutzhuangs(wid);
           if(num2==warehouseoutApplyZhongListbugou.size()){
               return "库存不足!进货申请单已自动形成";
           }
       }else {
           int num=0;
           int[] idsss = new int[supdrus.size()];
           for(int i=0;i<supdrus.size();i++){
               Wardru wardru=wardruService.queryallWardruBysupwarid(supdrus.get(i).getSupplier().getSup_id(),warehouses.get(i).getWar_id());
               idsss[i]=wardru.getKu_cun();
           }
           System.out.println(idsss);
           //不够:够多少就进多少
           //List<WarehouseoutApplyZhong> warehouseoutApplyZhongListshao=new ArrayList<>();
           List<PurchaseApplyZhong> purchaseApplyZhongListshao=new ArrayList<>();
           int zzshu=0;
           double zzjia=0;
         for(int i=0;i<warehouseoutApplyZhongListgou.size();i++){
             if(idsss[i]<warehouseoutApplyZhongListgou.get(i).getWoa_zcount()){
                int shu=warehouseoutApplyZhongListgou.get(i).getWoa_zcount()-idsss[i];
                zzshu=zzshu+shu;
                double jia=warehouseoutApplyZhongListgou.get(i).getDrug().getDru_jia();
                double zjia=zzshu*jia;
                zzjia=zzjia+zjia;
                 PurchaseApply purchaseApply=new PurchaseApply();
                 purchaseApply.setPua_zjia(zzjia);
                 purchaseApply.setPua_zcount(zzshu);
                 Employee employee=(Employee)session.getAttribute("employee");
                 purchaseApply.setEmployee(employee);
                 int num1=purchaseApplyService.addPurchaseApply(purchaseApply);


                 PurchaseApplyZhong purchaseApplyZhong=new PurchaseApplyZhong();
                 PurchaseApply purchaseApply1=purchaseApplyService.queryPurchaseApplyBypuaid(purchaseApply.getPua_id());
                 purchaseApplyZhong.setPurchaseApply(purchaseApply1);
                 Supdru supdru=supdruService.queryallSupdruBysupdruid(
                         warehouseoutApplyZhongListgou.get(i).getSupplier().getSup_id(),
                         warehouseoutApplyZhongListgou.get(i).getDrug().getDru_id()
                 );
                 purchaseApplyZhong.setSupdru(supdru);
                 purchaseApplyZhong.setPua_zcount(shu);
                 purchaseApplyZhong.setPua_zjia(jia);
                 purchaseApplyZhongListshao.add(purchaseApplyZhong);
                /* //出库申请表
                 WarehouseoutApply warehouseoutApply=new WarehouseoutApply();
                 Customer customer=new Customer();
                 customer.setCus_id(warehouseoutApplyZhongListgou.get(i).getWarehouseoutApply().getCustomer().getCus_id());
                 warehouseoutApply.setCustomer(customer);
                 warehouseoutApply.setWoa_zcount(zzshu);
                 warehouseoutApply.setWoa_zjia(zzjia);
                 Employee employee=(Employee)session.getAttribute("employee");
                 warehouseoutApply.setEmployee(employee);
                 int num1=warehouseoutApplyService.addWarehouseoutApply(warehouseoutApply);
                 //出库申请
                 WarehouseoutApply warehouseoutApply1=warehouseoutApplyService.queryWarehouseoutApplyBywoaid(warehouseoutApply.getWoa_id());
                 WarehouseoutApplyZhong warehouseoutApplyZhong1=new WarehouseoutApplyZhong();
                 warehouseoutApplyZhong1.setWarehouseoutApply(warehouseoutApply1);
                 warehouseoutApplyZhong1.setDrug(warehouseoutApplyZhongListgou.get(i).getDrug());
                 warehouseoutApplyZhong1.setSupplier(warehouseoutApplyZhongListgou.get(i).getSupplier());
                 warehouseoutApplyZhong1.setWarehouse(warehouseoutApplyZhongListgou.get(i).getWarehouse());
                 warehouseoutApplyZhong1.setWoa_zcount(shu);
                 warehouseoutApplyZhong1.setWoa_zjia(zjia);
                 warehouseoutApplyZhongListshao.add(warehouseoutApplyZhong1);*/
             }
         }
         if(purchaseApplyZhongListshao.size()>=1){
             int num2=purchaseApplyZhongService.addPurchaseApplyZhong(purchaseApplyZhongListshao);
             int numm=warehouseoutService.updateWarehouseoutzhuangs(wid);
             if(num2==warehouseoutApplyZhongListbugou.size()){
                 return "库存不足!进货申请单已自动形成";
             }
         }else{
             int numm=warehouseoutService.updateWarehouseoutzhuang(wid);
             int nz=0;
             for(int i=0;i<warehouseoutApplyZhongListgou.size();i++){
                 Wardru wardru=new Wardru();
                 wardru.setSupdru(supdrus.get(i));
                 wardru.setWarehouse(warehouses.get(i));
                 wardru.setKu_cun(warehouseoutApplyZhongListgou.get(i).getWoa_zcount());
                int n= wardruService.updateWardrus(wardru);
                nz=nz+n;
             }
           if(nz==warehouseoutApplyZhongListgou.size()){
               return "库存足够,已自动出库";
           }
         }
       }
        return "库存不足!进货申请单已自动形成";
    }
    @RequestMapping(value = "/test.action", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String test() {

        return "库存不足";
    }
}
