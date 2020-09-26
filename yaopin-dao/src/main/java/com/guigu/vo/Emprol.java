package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties("handler")
public class Emprol implements Serializable {
    private  int id;
    private  int emp_id;
    private  int rol_id;

    public Emprol() {
    }

    public Emprol(int id, int emp_id, int rol_id) {
        this.id = id;
        this.emp_id = emp_id;
        this.rol_id = rol_id;
    }

    @Override
    public String toString() {
        return "Emprol{" +
                "id=" + id +
                ", emp_id=" + emp_id +
                ", rol_id=" + rol_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }
}
