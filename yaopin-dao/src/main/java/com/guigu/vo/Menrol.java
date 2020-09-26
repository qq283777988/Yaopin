package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class Menrol implements Serializable {
    private  int id;
    private  int men_id;
    private int rol_id;

    public Menrol(int id, int men_id, int rol_id) {
        this.id = id;
        this.men_id = men_id;
        this.rol_id = rol_id;
    }

    public Menrol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMen_id() {
        return men_id;
    }

    public void setMen_id(int men_id) {
        this.men_id = men_id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    @Override
    public String toString() {
        return "Menrol{" +
                "id=" + id +
                ", men_id=" + men_id +
                ", rol_id=" + rol_id +
                '}';
    }
}
