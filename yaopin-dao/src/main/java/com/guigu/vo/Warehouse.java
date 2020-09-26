package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties("handler")
public class Warehouse implements Serializable {
    private  int war_id;
    private String war_name;
    private  int war_state;
    private List<Drug> drugs;
    public Warehouse() {
    }

    public int getWar_id() {
        return war_id;
    }

    public Warehouse(int war_id, String war_name, int war_state) {
        this.war_id = war_id;
        this.war_name = war_name;
        this.war_state = war_state;
    }

    public int getWar_state() {
        return war_state;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "war_id=" + war_id +
                ", war_name='" + war_name + '\'' +
                ", war_state=" + war_state +
                '}';
    }

    public void setWar_state(int war_state) {
        this.war_state = war_state;
    }

    public void setWar_id(int war_id) {
        this.war_id = war_id;
    }

    public String getWar_name() {
        return war_name;
    }

    public void setWar_name(String war_name) {
        this.war_name = war_name;
    }
}
