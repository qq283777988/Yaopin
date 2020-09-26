package com.guigu.controller;
import com.guigu.service.DrugService;
import com.guigu.service.PurchaseApplyService;
import com.guigu.service.PurchaseApplyZhongService;
import com.guigu.vo.Employee;
import com.guigu.vo.PurchaseApply;
import com.guigu.vo.PurchaseApplyZhong;
import com.guigu.vo.Supdru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PurchaseApplyZhongController {
    @Autowired
    PurchaseApplyZhongService purchaseApplyZhongService;
    @Autowired
    PurchaseApplyService purchaseApplyService;
    @RequestMapping(value ="/addPurchaseApplyZhong.action",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String addPurchaseApplyZhong(String mids, String countlist, String zjialist, int zcount, double zjia, HttpSession session){
        System.out.println("1--"+mids);
        System.out.println("2--"+countlist);
        System.out.println("3--"+zjialist);
        System.out.println("4--"+zcount);
        System.out.println("5--"+zjia);

        PurchaseApply purchaseApply=new PurchaseApply();
        purchaseApply.setPua_zjia(zjia);
        purchaseApply.setPua_zcount(zcount);
        Employee employee=(Employee) session.getAttribute("employee");
        purchaseApply.setEmployee(employee);
       int nu=purchaseApplyService.addPurchaseApply(purchaseApply);
        System.out.println("添加新的"+nu);
        String[] midss = mids.split(",");
        String[] countlistt= countlist.split(",");
        String[] zjialistt = zjialist.split(",");


        List<PurchaseApplyZhong> purchaseApplyZhongs=new ArrayList<>();
       PurchaseApply purchaseApply1=purchaseApplyService.queryPurchaseApplyBypuaid(purchaseApply.getPua_id());
        for(int i=0;i<midss.length;i++){
            PurchaseApplyZhong purchaseApplyZhong=new PurchaseApplyZhong();
          purchaseApplyZhong.setPurchaseApply(purchaseApply1);
            Supdru supdru=new Supdru();
            supdru.setId(Integer.parseInt(midss[i]));
            purchaseApplyZhong.setSupdru(supdru);
            purchaseApplyZhong.setPua_zcount(Integer.parseInt(countlistt[i]));
            purchaseApplyZhong.setPua_zjia(Double.parseDouble(zjialistt[i]));
              /*  if(!beilistt[i].equals("")){
                    purchaseApplyZhong.setPua_bei(beilistt[i]);
                }*/

            purchaseApplyZhongs.add(purchaseApplyZhong);
        }
      int num=purchaseApplyZhongService.addPurchaseApplyZhong(purchaseApplyZhongs);

      if(num==midss.length){
            return "操作成功";
        }
        return "操作失败";
    }
    @RequestMapping("/queryPurchaseApplyZhongBypuaid.action")
    @ResponseBody
    public List<PurchaseApplyZhong> queryPurchaseApplyZhongBypuaid( @RequestParam(value = "pua_id")Integer pua_id){
        return purchaseApplyZhongService.queryPurchaseApplyZhongBypuaid(pua_id);
    }
}
