package com.guigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@JsonIgnoreProperties("handler")
public class PurchaseApply implements Serializable {
    private int pua_id;
    private double pua_zjia;
    private int pua_zcount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" ,timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm" )
    private Timestamp pua_time;
    private String  pua_state;
    private  Employee employee;




    public PurchaseApply() {
    }


    public int getPua_zcount() {
        return pua_zcount;
    }

    public void setPua_zcount(int pua_zcount) {
        this.pua_zcount = pua_zcount;
    }

    public int getPua_id() {
        return pua_id;
    }

    public void setPua_id(int pua_id) {
        this.pua_id = pua_id;
    }


    public double getPua_zjia() {
        return pua_zjia;
    }

    public void setPua_zjia(double pua_zjia) {
        this.pua_zjia = pua_zjia;
    }




    public Timestamp getPua_time() {
        return pua_time;
    }

    public void setPua_time(Timestamp pua_time) {
        this.pua_time = pua_time;
    }



    public Employee getEmployee() {
        return employee;
    }

    public String getPua_state() {
        return pua_state;
    }

    @Override
    public String toString() {
        return "PurchaseApply{" +
                "pua_id=" + pua_id +
                ", pua_zjia=" + pua_zjia +
                ", pua_zcount=" + pua_zcount +
                ", pua_time=" + pua_time +
                ", pua_state='" + pua_state + '\'' +
                ", employee=" + employee +
                '}';
    }

    public void setPua_state(String pua_state) {
        this.pua_state = pua_state;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PurchaseApply(int pua_id, double pua_zjia, int pua_zcount, Timestamp pua_time, String pua_state, Employee employee) {
        this.pua_id = pua_id;
        this.pua_zjia = pua_zjia;
        this.pua_zcount = pua_zcount;
        this.pua_time = pua_time;
        this.pua_state = pua_state;
        this.employee = employee;
    }
}
