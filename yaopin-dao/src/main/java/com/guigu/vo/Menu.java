package com.guigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@JsonIgnoreProperties("handler")
public class Menu implements Serializable {
    private Integer id;
    private String text;
    private String url;
    private String iconCls;
    private String state;
    private Integer parentid;
    private Map<String,String> attributes=new HashMap<String,String>();
    //子菜单集合
    private List<Menu> children=new ArrayList<Menu>();

    //子节点选中状态
    private boolean checked;

    public Menu() {
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Menu(Integer id, String text, String url, String iconCls, String state, Integer parentid) {
        this.id = id;
        this.text = text;
        this.url = url;
        this.iconCls = iconCls;
        this.state = state;
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", state='" + state + '\'' +
                ", parentid=" + parentid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}
