package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class DrugType implements Serializable {
    private  int dru_typeid;
    private String dru_typename;

    public DrugType() {
    }

    public DrugType(int dru_typeid, String dru_typename) {
        this.dru_typeid = dru_typeid;
        this.dru_typename = dru_typename;
    }

    public int getDru_typeid() {
        return dru_typeid;
    }

    @Override
    public String toString() {
        return "DrugType{" +
                "dru_typeid=" + dru_typeid +
                ", dru_typename='" + dru_typename + '\'' +
                '}';
    }

    public void setDru_typeid(int dru_typeid) {
        this.dru_typeid = dru_typeid;
    }

    public String getDru_typename() {
        return dru_typename;
    }

    public void setDru_typename(String dru_typename) {
        this.dru_typename = dru_typename;
    }
}
