package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

@JsonIgnoreProperties("handler")
public class ReturnGoods implements Serializable {
    private int id;
    private ReturnGoodsApply returnGoodsApply;
    private Employee employee;
    private Timestamp rga_shentime;
    private double rga_jia;
    private int  rga_guanque;
    private  String rga_bei;
    private  int rga_state;

    public ReturnGoods() {
    }

    public Timestamp getRga_shentime() {
        return rga_shentime;
    }

    public void setRga_shentime(Timestamp rga_shentime) {
        this.rga_shentime = rga_shentime;
    }

    public ReturnGoods(int id, ReturnGoodsApply returnGoodsApply, Employee employee, Timestamp rga_shentime, double rga_jia, int rga_guanque, String rga_bei, int rga_state) {
        this.id = id;
        this.returnGoodsApply = returnGoodsApply;
        this.employee = employee;
        this.rga_shentime = rga_shentime;
        this.rga_jia = rga_jia;
        this.rga_guanque = rga_guanque;
        this.rga_bei = rga_bei;
        this.rga_state = rga_state;
    }

    public ReturnGoodsApply getReturnGoodsApply() {
        return returnGoodsApply;
    }

    public void setReturnGoodsApply(ReturnGoodsApply returnGoodsApply) {
        this.returnGoodsApply = returnGoodsApply;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public double getRga_jia() {
        return rga_jia;
    }

    public void setRga_jia(double rga_jia) {
        this.rga_jia = rga_jia;
    }

    public int getRga_guanque() {
        return rga_guanque;
    }

    public void setRga_guanque(int rga_guanque) {
        this.rga_guanque = rga_guanque;
    }

    public String getRga_bei() {
        return rga_bei;
    }

    public void setRga_bei(String rga_bei) {
        this.rga_bei = rga_bei;
    }

    public int getRga_state() {
        return rga_state;
    }

    public void setRga_state(int rga_state) {
        this.rga_state = rga_state;
    }
}
