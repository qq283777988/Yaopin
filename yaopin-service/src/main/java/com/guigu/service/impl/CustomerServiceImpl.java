package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.CustomerDao;
import com.guigu.dao.DrugJIDao;
import com.guigu.service.CustomerService;
import com.guigu.vo.Customer;
import com.guigu.vo.PageVo;
import com.guigu.vo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;
    @Override
    public List<Customer> queryCustomerr() {
        return customerDao.queryCustomerr();
    }

    @Override
    public Customer queryCustomerrBycusid(int cus_id) {
        return customerDao.queryCustomerrBycusid(cus_id);
    }

    @Override
    public PageVo<Customer> queryCustomer(int page, int rows) {
        PageVo<Customer> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(customerDao.queryCustomerr());
        //获取总的记录数量
        pageVo.setTotal(customerDao.querycountCustomer());
        return pageVo;
    }
}
