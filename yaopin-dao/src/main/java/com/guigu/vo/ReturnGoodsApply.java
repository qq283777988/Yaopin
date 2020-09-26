package com.guigu.vo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Timestamp;

@JsonIgnoreProperties("handler")
public class ReturnGoodsApply implements Serializable {
    private int rga_id;
    private Supdru supdru;
    private  int rga_count;
    private  double rga_jia;
    private Employee employee;
    private Timestamp rga_time;
    private String rga_bei;
    private int rga_state;

    public ReturnGoodsApply() {
    }

    public ReturnGoodsApply(int rga_id, Supdru supdru, int rga_count, double rga_jia, Employee employee, Timestamp rga_time, String rga_bei, int rga_state) {
        this.rga_id = rga_id;
        this.supdru = supdru;
        this.rga_count = rga_count;
        this.rga_jia = rga_jia;
        this.employee = employee;
        this.rga_time = rga_time;
        this.rga_bei = rga_bei;
        this.rga_state = rga_state;
    }

    public int getRga_id() {
        return rga_id;
    }

    public void setRga_id(int rga_id) {
        this.rga_id = rga_id;
    }

    public Supdru getSupdru() {
        return supdru;
    }

    public void setSupdru(Supdru supdru) {
        this.supdru = supdru;
    }

    public int getRga_count() {
        return rga_count;
    }

    public void setRga_count(int rga_count) {
        this.rga_count = rga_count;
    }

    public double getRga_jia() {
        return rga_jia;
    }

    public void setRga_jia(double rga_jia) {
        this.rga_jia = rga_jia;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getRga_time() {
        return rga_time;
    }

    public void setRga_time(Timestamp rga_time) {
        this.rga_time = rga_time;
    }

    public String getRga_bei() {
        return rga_bei;
    }

    public void setRga_bei(String rga_bei) {
        this.rga_bei = rga_bei;
    }

    public int getRga_state() {
        return rga_state;
    }

    public void setRga_state(int rga_state) {
        this.rga_state = rga_state;
    }

    @Override
    public String toString() {
        return "ReturnGoodsApply{" +
                "rga_id=" + rga_id +
                ", supdru=" + supdru +
                ", rga_count=" + rga_count +
                ", rga_jia=" + rga_jia +
                ", employee=" + employee +
                ", rga_time=" + rga_time +
                ", rga_bei='" + rga_bei + '\'' +
                ", rga_state=" + rga_state +
                '}';
    }
}
