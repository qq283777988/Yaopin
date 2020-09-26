package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties("handler")
public class Supdru implements Serializable {
    private  int id;
    private Supplier supplier;
    private  Drug drug;
    private  double jin_dan;

    public Supdru() {
    }

    public Supdru(int id, Supplier supplier, Drug drug, double jin_dan) {
        this.id = id;
        this.supplier = supplier;
        this.drug = drug;
        this.jin_dan = jin_dan;
    }

    @Override
    public String toString() {
        return "Supdru{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", drug=" + drug +
                ", jin_dan=" + jin_dan +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public double getJin_dan() {
        return jin_dan;
    }

    public void setJin_dan(double jin_dan) {
        this.jin_dan = jin_dan;
    }
}
