package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties("handler")
public class Supplier implements Serializable {
    private int sup_id;
    private String sup_name;
    private String sup_di;
    private String sup_dian;
    private int sup_state;
    private List<Drug> drugs;
    public Supplier() {
    }

    public Supplier(int sup_id, String sup_name, String sup_di, String sup_dian, int sup_state, List<Drug> drugs) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.sup_di = sup_di;
        this.sup_dian = sup_dian;
        this.sup_state = sup_state;
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "sup_id=" + sup_id +
                ", sup_name='" + sup_name + '\'' +
                ", sup_di='" + sup_di + '\'' +
                ", sup_dian='" + sup_dian + '\'' +
                ", sup_state=" + sup_state +
                ", drugs=" + drugs +
                '}';
    }

    public String getSup_di() {
        return sup_di;
    }

    public void setSup_di(String sup_di) {
        this.sup_di = sup_di;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public int getSup_state() {
        return sup_state;
    }

    public void setSup_state(int sup_state) {
        this.sup_state = sup_state;
    }



    public int getSup_id() {
        return sup_id;
    }

    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }



    public String getSup_dian() {
        return sup_dian;
    }

    public void setSup_dian(String sup_dian) {
        this.sup_dian = sup_dian;
    }
}
