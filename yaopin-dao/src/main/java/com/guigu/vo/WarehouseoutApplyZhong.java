package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class WarehouseoutApplyZhong implements Serializable {
    private  int woa_zhongid;
    private  WarehouseoutApply warehouseoutApply;
    private  Drug drug;
    private Supplier supplier;
    private Warehouse warehouse;
    private  int woa_zcount;
    private double woa_zjia;
    private  int woa_state;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public String toString() {
        return "WarehouseoutApplyZhong{" +
                "woa_zhongid=" + woa_zhongid +
                ", warehouseoutApply=" + warehouseoutApply +
                ", drug=" + drug +
                ", supplier=" + supplier +
                ", warehouse=" + warehouse +
                ", woa_zcount=" + woa_zcount +
                ", woa_zjia=" + woa_zjia +
                ", woa_state=" + woa_state +
                '}';
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public WarehouseoutApplyZhong(int woa_zhongid, WarehouseoutApply warehouseoutApply, Drug drug, Supplier supplier, Warehouse warehouse, int woa_zcount, double woa_zjia, int woa_state) {
        this.woa_zhongid = woa_zhongid;
        this.warehouseoutApply = warehouseoutApply;
        this.drug = drug;
        this.supplier = supplier;
        this.warehouse = warehouse;
        this.woa_zcount = woa_zcount;
        this.woa_zjia = woa_zjia;
        this.woa_state = woa_state;
    }

    public int getWoa_zhongid() {
        return woa_zhongid;
    }

    public void setWoa_zhongid(int woa_zhongid) {
        this.woa_zhongid = woa_zhongid;
    }

    public WarehouseoutApply getWarehouseoutApply() {
        return warehouseoutApply;
    }

    public void setWarehouseoutApply(WarehouseoutApply warehouseoutApply) {
        this.warehouseoutApply = warehouseoutApply;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getWoa_zcount() {
        return woa_zcount;
    }

    public void setWoa_zcount(int woa_zcount) {
        this.woa_zcount = woa_zcount;
    }

    public double getWoa_zjia() {
        return woa_zjia;
    }

    public void setWoa_zjia(double woa_zjia) {
        this.woa_zjia = woa_zjia;
    }


    public int getWoa_state() {
        return woa_state;
    }

    public void setWoa_state(int woa_state) {
        this.woa_state = woa_state;
    }



    public WarehouseoutApplyZhong() {
    }
}
