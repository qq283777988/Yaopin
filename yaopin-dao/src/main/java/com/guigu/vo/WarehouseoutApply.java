package com.guigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

@JsonIgnoreProperties("handler")
public class WarehouseoutApply implements Serializable {
    private int woa_id;
    private  Customer customer;
    private  int woa_zcount;
    private double woa_zjia;
    private  Employee employee;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" ,timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm" )
    private Timestamp woa_time;
    private  String woa_state;

    public WarehouseoutApply() {
    }


    public int getWoa_id() {
        return woa_id;
    }

    public void setWoa_id(int woa_id) {
        this.woa_id = woa_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getWoa_time() {
        return woa_time;
    }

    public void setWoa_time(Timestamp woa_time) {
        this.woa_time = woa_time;
    }


    public String getWoa_state() {
        return woa_state;
    }

    public void setWoa_state(String woa_state) {
        this.woa_state = woa_state;
    }

    @Override
    public String toString() {
        return "WarehouseoutApply{" +
                "woa_id=" + woa_id +
                ", customer=" + customer +
                ", woa_zcount=" + woa_zcount +
                ", woa_zjia=" + woa_zjia +
                ", employee=" + employee +
                ", woa_time=" + woa_time +
                ", woa_state='" + woa_state + '\'' +
                '}';
    }

    public WarehouseoutApply(int woa_id, Customer customer, int woa_zcount, double woa_zjia, Employee employee, Timestamp woa_time, String woa_state) {
        this.woa_id = woa_id;
        this.customer = customer;
        this.woa_zcount = woa_zcount;
        this.woa_zjia = woa_zjia;
        this.employee = employee;
        this.woa_time = woa_time;
        this.woa_state = woa_state;
    }

    public int getWoa_zcount() {
        return woa_zcount;
    }

    public void setWoa_zcount(int woa_zcount) {
        this.woa_zcount = woa_zcount;
    }

    public double getWoa_zjia() {
        return woa_zjia;
    }



    public void setWoa_zjia(double woa_zjia) {
        this.woa_zjia = woa_zjia;
    }


}
