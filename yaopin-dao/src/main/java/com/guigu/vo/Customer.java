package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class Customer implements Serializable {
    private  int cus_id;
    private String cus_name;
    private  int cus_dian;
    private  String cus_lei;
    private String cus_di;
    private  int cus_state;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", cus_dian=" + cus_dian +
                ", cus_lei='" + cus_lei + '\'' +
                ", cus_di='" + cus_di + '\'' +
                ", cus_state=" + cus_state +
                '}';
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public int getCus_dian() {
        return cus_dian;
    }

    public void setCus_dian(int cus_dian) {
        this.cus_dian = cus_dian;
    }

    public String getCus_lei() {
        return cus_lei;
    }

    public void setCus_lei(String cus_lei) {
        this.cus_lei = cus_lei;
    }

    public String getCus_di() {
        return cus_di;
    }

    public void setCus_di(String cus_di) {
        this.cus_di = cus_di;
    }

    public int getCus_state() {
        return cus_state;
    }

    public void setCus_state(int cus_state) {
        this.cus_state = cus_state;
    }

    public Customer(int cus_id, String cus_name, int cus_dian, String cus_lei, String cus_di, int cus_state) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_dian = cus_dian;
        this.cus_lei = cus_lei;
        this.cus_di = cus_di;
        this.cus_state = cus_state;
    }
}
