package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class PurchaseApplyZhong implements Serializable {
    private int pua_sdzhongid;
    private PurchaseApply purchaseApply;
    private Supdru supdru;
    private int pua_zcount;
    private double pua_zjia;
    private int pua_state;
    public int getPua_zcount() {
        return pua_zcount;
    }

    public void setPua_zcount(int pua_zcount) {
        this.pua_zcount = pua_zcount;
    }

    public PurchaseApplyZhong(int pua_sdzhongid, PurchaseApply purchaseApply, Supdru supdru, int pua_zcount, double pua_zjia, int pua_state) {
        this.pua_sdzhongid = pua_sdzhongid;
        this.purchaseApply = purchaseApply;
        this.supdru = supdru;
        this.pua_zcount = pua_zcount;
        this.pua_zjia = pua_zjia;
        this.pua_state = pua_state;
    }

    @Override
    public String toString() {
        return "PurchaseApplyZhong{" +
                "pua_sdzhongid=" + pua_sdzhongid +
                ", purchaseApply=" + purchaseApply +
                ", supdru=" + supdru +
                ", pua_zcount=" + pua_zcount +
                ", pua_zjia=" + pua_zjia +
                ", pua_state=" + pua_state +
                '}';
    }

    public int getPua_state() {
        return pua_state;
    }

    public void setPua_state(int pua_state) {
        this.pua_state = pua_state;
    }

    public double getPua_zjia() {
        return pua_zjia;
    }

    public void setPua_zjia(double pua_zjia) {
        this.pua_zjia = pua_zjia;
    }


    public int getPua_sdzhongid() {
        return pua_sdzhongid;
    }

    public void setPua_sdzhongid(int pua_sdzhongid) {
        this.pua_sdzhongid = pua_sdzhongid;
    }

    public PurchaseApply getPurchaseApply() {
        return purchaseApply;
    }

    public void setPurchaseApply(PurchaseApply purchaseApply) {
        this.purchaseApply = purchaseApply;
    }

    public Supdru getSupdru() {
        return supdru;
    }

    public void setSupdru(Supdru supdru) {
        this.supdru = supdru;
    }

    public PurchaseApplyZhong() {
    }
}
