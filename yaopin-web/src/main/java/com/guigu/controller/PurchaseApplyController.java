package com.guigu.controller;

import com.guigu.service.PurchaseApplyService;
import com.guigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PurchaseApplyController {
    @Autowired
    PurchaseApplyService purchaseApplyService;
    @RequestMapping("/queryPurchaseApply.action")
    @ResponseBody
    public PageVo<PurchaseApply> queryPurchaseApply(PurchaseApply purchaseApply,
                                                    @RequestParam(value = "page",defaultValue = "1") int page,
                                                    @RequestParam(value = "rows",defaultValue = "5")int rows){

        return purchaseApplyService.queryPurchaseApply(purchaseApply,page,rows);
    }
}
