package com.decisioncustom.domain;

/**
 * 描述:t_department表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-03-28
 */
public class TDepartment {
    /**
     * 
     */
    private Long id;

    /**
     * 部门编号
     */
    private String sn;

    /**
     * 
     */
    private String name;

    /**
     * 路径
     */
    private String dirpath;

    /**
     * 状态，0为正常，-1为停用,
     */
    private Integer state;

    /**
     * 
     */
    private Long parent;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 部门编号
     * @return sn 部门编号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 部门编号
     * @param sn 部门编号
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 路径
     * @return dirPath 路径
     */
    public String getDirpath() {
        return dirpath;
    }

    /**
     * 路径
     * @param dirpath 路径
     */
    public void setDirpath(String dirpath) {
        this.dirpath = dirpath == null ? null : dirpath.trim();
    }

    /**
     * 状态，0为正常，-1为停用,
     * @return state 状态，0为正常，-1为停用,
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态，0为正常，-1为停用,
     * @param state 状态，0为正常，-1为停用,
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 
     * @return parent 
     */
    public Long getParent() {
        return parent;
    }

    /**
     * 
     * @param parent 
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }
}