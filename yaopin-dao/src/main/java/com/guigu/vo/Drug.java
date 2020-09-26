package com.guigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties("handler")
public class Drug implements Serializable {
    private int dru_id;
    private String dru_name;
    private String dru_image;
    private String dru_gui;
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd" )
    private Date dru_time;
    private String dru_gong;
    private Double dru_jia;
    private DrugType drugType;
    private DrugJI drugJI;
    private  int dru_state;//在1 不在0

    private List<Supplier> suppliers;
    private List<Warehouse> warehouses;
    public Drug() {
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "dru_id=" + dru_id +
                ", dru_name='" + dru_name + '\'' +
                ", dru_image='" + dru_image + '\'' +
                ", dru_gui='" + dru_gui + '\'' +
                ", dru_time=" + dru_time +
                ", dru_gong='" + dru_gong + '\'' +
                ", dru_jia=" + dru_jia +
                ", drugType=" + drugType +
                ", drugJI=" + drugJI +
                ", dru_state=" + dru_state +
                '}';
    }

    public int getDru_id() {
        return dru_id;
    }

    public void setDru_id(int dru_id) {
        this.dru_id = dru_id;
    }

    public String getDru_name() {
        return dru_name;
    }

    public void setDru_name(String dru_name) {
        this.dru_name = dru_name;
    }

    public String getDru_image() {
        return dru_image;
    }

    public void setDru_image(String dru_image) {
        this.dru_image = dru_image;
    }

    public String getDru_gui() {
        return dru_gui;
    }

    public void setDru_gui(String dru_gui) {
        this.dru_gui = dru_gui;
    }

    public Date getDru_time() {
        return dru_time;
    }

    public void setDru_time(Date dru_time) {
        this.dru_time = dru_time;
    }

    public String getDru_gong() {
        return dru_gong;
    }

    public void setDru_gong(String dru_gong) {
        this.dru_gong = dru_gong;
    }

    public Double getDru_jia() {
        return dru_jia;
    }

    public void setDru_jia(Double dru_jia) {
        this.dru_jia = dru_jia;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public void setDrugType(DrugType drugType) {
        this.drugType = drugType;
    }

    public DrugJI getDrugJI() {
        return drugJI;
    }

    public void setDrugJI(DrugJI drugJI) {
        this.drugJI = drugJI;
    }

    public int getDru_state() {
        return dru_state;
    }

    public void setDru_state(int dru_state) {
        this.dru_state = dru_state;
    }

    public Drug(int dru_id, String dru_name, String dru_image, String dru_gui, Date dru_time, String dru_gong, Double dru_jia, DrugType drugType, DrugJI drugJI, int dru_state) {
        this.dru_id = dru_id;
        this.dru_name = dru_name;
        this.dru_image = dru_image;
        this.dru_gui = dru_gui;
        this.dru_time = dru_time;
        this.dru_gong = dru_gong;
        this.dru_jia = dru_jia;
        this.drugType = drugType;
        this.drugJI = drugJI;
        this.dru_state = dru_state;
    }
}
