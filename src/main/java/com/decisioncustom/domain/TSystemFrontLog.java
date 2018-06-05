package com.decisioncustom.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 描述:t_system_front_log表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-02
 */
public class TSystemFrontLog {
    /**
     * 
     */
    private Long id;

    /**
     * 操作人员
     */
    private String openUser;

    /**
     * 操作日期
     */
    private Date openDate;

    /**
     * IP地址
     */
    private String openIp;

    /**
     * 方法
     */
    private String function;

    /**
     * 参数
     */
    private String parameter;

    @Override
    public String toString() {
        return "TSystemFrontLog{" +
                "id=" + id +
                ", openUser='" + openUser + '\'' +
                ", openDate=" + openDate +
                ", openIp='" + openIp + '\'' +
                ", function='" + function + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }

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
     * 操作人员
     * @return open_user 操作人员
     */
    public String getOpenUser() {
        return openUser;
    }

    /**
     * 操作人员
     * @param openUser 操作人员
     */
    public void setOpenUser(String openUser) {
        this.openUser = openUser == null ? null : openUser.trim();
    }

    /**
     * 操作日期
     * @return open_date 操作日期
     */
    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone="GMT+8")
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * 操作日期
     * @param openDate 操作日期
     */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    /**
     * IP地址
     * @return open_ip IP地址
     */
    public String getOpenIp() {
        return openIp;
    }

    /**
     * IP地址
     * @param openIp IP地址
     */
    public void setOpenIp(String openIp) {
        this.openIp = openIp == null ? null : openIp.trim();
    }

    /**
     * 方法
     * @return function 方法
     */
    public String getFunction() {
        return function;
    }

    /**
     * 方法
     * @param function 方法
     */
    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    /**
     * 参数
     * @return parameter 参数
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * 参数
     * @param parameter 参数
     */
    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }
}