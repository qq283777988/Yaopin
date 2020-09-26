package com.guigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties("handler")
public class Employee implements Serializable {
    private  Integer emp_id;
    private String emp_name;
    private String emp_sex;
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd" )
    private Date emp_birthday;
    private String emp_user;
    private String emp_pass;
    private String emp_state;

    private List<Role> roles;
    public Employee() {
    }


    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_sex='" + emp_sex + '\'' +
                ", emp_birthday=" + emp_birthday +
                ", emp_user='" + emp_user + '\'' +
                ", emp_pass='" + emp_pass + '\'' +
                ", emp_state='" + emp_state + '\'' +
                ", roles=" + roles +
                '}';
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    public Date getEmp_birthday() {
        return emp_birthday;
    }

    public void setEmp_birthday(Date emp_birthday) {
        this.emp_birthday = emp_birthday;
    }

    public String getEmp_user() {
        return emp_user;
    }

    public void setEmp_user(String emp_user) {
        this.emp_user = emp_user;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public String getEmp_state() {
        return emp_state;
    }

    public void setEmp_state(String emp_state) {
        this.emp_state = emp_state;
    }

    public Employee(Integer emp_id, String emp_name, String emp_sex, Date emp_birthday, String emp_user, String emp_pass, String emp_state) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sex = emp_sex;
        this.emp_birthday = emp_birthday;
        this.emp_user = emp_user;
        this.emp_pass = emp_pass;
        this.emp_state = emp_state;
    }
}
