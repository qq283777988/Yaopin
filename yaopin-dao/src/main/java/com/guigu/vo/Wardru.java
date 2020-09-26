package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class Wardru  implements Serializable {
    private  int id;
    private  Warehouse warehouse;
    private  Supdru supdru;
    private int ku_cun;

    public Wardru() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Wardru{" +
                "id=" + id +
                ", warehouse=" + warehouse +
                ", supdru=" + supdru +
                ", ku_cun=" + ku_cun +
                '}';
    }

    public Supdru getSupdru() {
        return supdru;
    }

    public void setSupdru(Supdru supdru) {
        this.supdru = supdru;
    }

    public Wardru(int id, Warehouse warehouse, Supdru supdru, int ku_cun) {
        this.id = id;
        this.warehouse = warehouse;
        this.supdru = supdru;
        this.ku_cun = ku_cun;
    }

    public int getKu_cun() {
        return ku_cun;
    }

    public void setKu_cun(int ku_cun) {
        this.ku_cun = ku_cun;
    }
}
