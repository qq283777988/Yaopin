package com.guigu.controller;

import com.guigu.service.CustomerService;
import com.guigu.service.DrugService;
import com.guigu.vo.Customer;
import com.guigu.vo.PageVo;
import com.guigu.vo.Role;
import com.guigu.vo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @RequestMapping("/queryallCustomer.action")
    @ResponseBody
    public List<Customer> queryallCustomer(){
        return customerService.queryCustomerr();
    }
    @RequestMapping("/queryCustomer.action")
    @ResponseBody
    public PageVo<Customer> queryCustomer(
                                          @RequestParam(value = "page",defaultValue = "1") int page,
                                          @RequestParam(value = "rows",defaultValue = "3")int rows){
        return customerService.queryCustomer(page,rows);
    }
}
