package com.guigu.dao;

import com.guigu.vo.Customer;
import com.guigu.vo.Drug;

import java.util.List;

public interface CustomerDao {
    //查询所有
    public List<Customer> queryCustomerr();
    //查询所有角色信息数量
    public int querycountCustomer();
    //根据id查
    public  Customer queryCustomerrBycusid(int cus_id);
}
