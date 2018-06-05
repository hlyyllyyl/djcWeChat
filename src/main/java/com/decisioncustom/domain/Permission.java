package com.decisioncustom.domain;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descs='" + descs + '\'' +
                ", sn='" + sn + '\'' +
                ", resource='" + resource + '\'' +
                ", menu_id='" + menu_id + '\'' +
                '}';
    }
    private SystemMenu menu;

    public SystemMenu getMenu() {
        return menu;
    }

    public void setMenu(SystemMenu menu) {
        this.menu = menu;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.descs
     *
     * @mbggenerated
     */
    private String descs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.sn
     *
     * @mbggenerated
     */
    private String sn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.resource
     *
     * @mbggenerated
     */
    private String resource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.menu_id
     *
     * @mbggenerated
     */
    private String menu_id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.name
     *
     * @return the value of permission.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.name
     *
     * @param name the value for permission.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.descs
     *
     * @return the value of permission.descs
     *
     * @mbggenerated
     */
    public String getDescs() {
        return descs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.descs
     *
     * @param descs the value for permission.descs
     *
     * @mbggenerated
     */
    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.sn
     *
     * @return the value of permission.sn
     *
     * @mbggenerated
     */
    public String getSn() {
        return sn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.sn
     *
     * @param sn the value for permission.sn
     *
     * @mbggenerated
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.resource
     *
     * @return the value of permission.resource
     *
     * @mbggenerated
     */
    public String getResource() {
        return resource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.resource
     *
     * @param resource the value for permission.resource
     *
     * @mbggenerated
     */
    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }


    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }
}