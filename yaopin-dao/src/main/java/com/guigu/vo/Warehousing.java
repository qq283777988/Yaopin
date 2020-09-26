package com.guigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

@JsonIgnoreProperties("handler")
public class Warehousing implements Serializable {
    private int wah_id;
    private Purchase purchase;
    private  Employee employee;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" ,timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm" )
    private Timestamp wah_time;
    private String wah_state;


    public int getWah_id() {
        return wah_id;
    }

    public void setWah_id(int wah_id) {
        this.wah_id = wah_id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getWah_time() {
        return wah_time;
    }

    public void setWah_time(Timestamp wah_time) {
        this.wah_time = wah_time;
    }

    public String getWah_state() {
        return wah_state;
    }

    public void setWah_state(String wah_state) {
        this.wah_state = wah_state;
    }

    @Override
    public String toString() {
        return "Warehousing{" +
                "wah_id=" + wah_id +
                ", purchase=" + purchase +
                ", employee=" + employee +
                ", wah_time=" + wah_time +
                ", wah_state='" + wah_state + '\'' +
                '}';
    }

    public Warehousing(int wah_id, Purchase purchase, Employee employee, Timestamp wah_time, String wah_state) {
        this.wah_id = wah_id;
        this.purchase = purchase;
        this.employee = employee;
        this.wah_time = wah_time;
        this.wah_state = wah_state;
    }

    public Warehousing() {
    }
}
