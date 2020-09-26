package com.guigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

@JsonIgnoreProperties("handler")
public class Warehouseout implements Serializable {
    private  int wid;
    private  WarehouseoutApply warehouseoutApply;
    private  Employee employee;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" ,timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm" )
    private Timestamp woa_shentime;
    private String woa_zhuang;

    public Warehouseout() {
    }




    public WarehouseoutApply getWarehouseoutApply() {
        return warehouseoutApply;
    }

    public void setWarehouseoutApply(WarehouseoutApply warehouseoutApply) {
        this.warehouseoutApply = warehouseoutApply;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getWoa_shentime() {
        return woa_shentime;
    }

    public void setWoa_shentime(Timestamp woa_shentime) {
        this.woa_shentime = woa_shentime;
    }




    @Override
    public String toString() {
        return "Warehouseout{" +
                "wid=" + wid +
                ", warehouseoutApply=" + warehouseoutApply +
                ", employee=" + employee +
                ", woa_shentime=" + woa_shentime +
                ", woa_zhuang=" + woa_zhuang +
                '}';
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getWoa_zhuang() {
        return woa_zhuang;
    }

    public void setWoa_zhuang(String woa_zhuang) {
        this.woa_zhuang = woa_zhuang;
    }

    public Warehouseout(int wid, WarehouseoutApply warehouseoutApply, Employee employee, Timestamp woa_shentime, String woa_zhuang) {
        this.wid = wid;
        this.warehouseoutApply = warehouseoutApply;
        this.employee = employee;
        this.woa_shentime = woa_shentime;
        this.woa_zhuang = woa_zhuang;
    }
}
