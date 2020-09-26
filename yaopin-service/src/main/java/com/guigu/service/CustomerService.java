package com.guigu.service;

import com.guigu.vo.Customer;
import com.guigu.vo.Menu;
import com.guigu.vo.PageVo;

import java.util.List;

public interface CustomerService {
    public List<Customer> queryCustomerr();
    //根据id查
    public  Customer queryCustomerrBycusid(int cus_id);
    //查询所有
    public PageVo<Customer> queryCustomer(int page, int rows);
}
