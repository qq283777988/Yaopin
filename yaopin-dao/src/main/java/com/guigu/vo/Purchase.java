package com.guigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

@JsonIgnoreProperties("handler")
public class Purchase implements Serializable {
           private int pid;
            private PurchaseApply purchaseApply;
            private Employee employee;
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm" ,timezone="GMT+8")
            @JSONField(format = "yyyy-MM-dd HH:mm" )
            private Timestamp pua_shentime;
            private String pua_zhuang;




    public PurchaseApply getPurchaseApply() {
        return purchaseApply;
    }

    public void setPurchaseApply(PurchaseApply purchaseApply) {
        this.purchaseApply = purchaseApply;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getPua_shentime() {
        return pua_shentime;
    }

    public void setPua_shentime(Timestamp pua_shentime) {
        this.pua_shentime = pua_shentime;
    }

    public String getPua_zhuang() {
        return pua_zhuang;
    }

    public Purchase() {
    }

    public void setPua_zhuang(String pua_zhuang) {
        this.pua_zhuang = pua_zhuang;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "pid=" + pid +
                ", purchaseApply=" + purchaseApply +
                ", employee=" + employee +
                ", pua_shentime=" + pua_shentime +
                ", pua_zhuang='" + pua_zhuang + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Purchase(int pid, PurchaseApply purchaseApply, Employee employee, Timestamp pua_shentime, String pua_zhuang) {
        this.pid = pid;
        this.purchaseApply = purchaseApply;
        this.employee = employee;
        this.pua_shentime = pua_shentime;
        this.pua_zhuang = pua_zhuang;
    }
}
