package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class DrugJI  implements Serializable {
    private int dru_jiid;
    private String dru_jiname;

    public DrugJI() {
    }

    public DrugJI(int dru_jiid, String dru_jiname) {
        this.dru_jiid = dru_jiid;
        this.dru_jiname = dru_jiname;
    }

    public int getDru_jiid() {
        return dru_jiid;
    }

    @Override
    public String toString() {
        return "DrugJI{" +
                "dru_jiid=" + dru_jiid +
                ", dru_jiname='" + dru_jiname + '\'' +
                '}';
    }

    public void setDru_jiid(int dru_jiid) {
        this.dru_jiid = dru_jiid;
    }

    public String getDru_jiname() {
        return dru_jiname;
    }

    public void setDru_jiname(String dru_jiname) {
        this.dru_jiname = dru_jiname;
    }
}
