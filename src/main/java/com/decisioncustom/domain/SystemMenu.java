package com.decisioncustom.domain;

import java.util.ArrayList;
import java.util.List;

public class SystemMenu {
    private Long id;
    private String sn; //菜单编号
    private String name;//菜单名字
    private String icon;//图标
    private String url;//地址
    private String intro;//简介

    private Long parentId;//父菜单Id
    private SystemMenu parent;//对用的父菜单

    private List<SystemMenu> children = new ArrayList<>();//该菜单对应的子菜单

    //增加一个树的get方法
    //父菜单
    private String parentStr;

    public String getText(){

        return this.name;
    }

    @Override
    public String toString() {
        return "SystemMenu{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", intro='" + intro + '\'' +
                ", parentId=" + parentId +
                ", parent=" + parent +
                ", children=" + children +
                ", parentStr='" + parentStr + '\'' +
                '}';
    }

    public String getParentStr() {
        return parentStr;
    }

    public void setParentStr(String parentStr) {
        this.parentStr = parentStr;
    }

    public Long getParentId() {

        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSn() {
        return sn;
    }
    public void setSn(String sn) {
        this.sn = sn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public List<SystemMenu> getSystemMenus() {
        return children;
    }
    public void setSystemMenus(List<SystemMenu> children) {
        this.children = children;
    }





    public List<SystemMenu> getChildren() {
        return children;
    }
    public void setChildren(List<SystemMenu> children) {
        this.children = children;
    }
    public SystemMenu getParent() {
        return parent;
    }
    public void setParent(SystemMenu parent) {
        this.parent = parent;
    }


}
