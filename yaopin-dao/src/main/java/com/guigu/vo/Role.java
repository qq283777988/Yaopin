package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties("handler")
public class Role  implements Serializable {
    private int rol_id;
    private String rol_name;
    public Role() {
    }

    public Role(int rol_id, String rol_name) {
        this.rol_id = rol_id;
        this.rol_name = rol_name;
    }


    @Override
    public String toString() {
        return "Role{" +
                "rol_id=" + rol_id +
                ", rol_name='" + rol_name + '\'' +
                '}';
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }
}
