package com.decisioncustom.domain;

import java.util.Date;

/**
 * 描述:t_customer_column表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-04-12
 */
public class TCustomerColumn {
    private TCustomer customer;
    private TColumn column;

    private String startTimeStr;
    private String endTimeStr;
    private String pauseTimeStr;

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getPauseTimeStr() {
        return pauseTimeStr;
    }

    public void setPauseTimeStr(String pauseTimeStr) {
        this.pauseTimeStr = pauseTimeStr;
    }

    public TCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TCustomer customer) {
        this.customer = customer;
    }

    public TColumn getColumn() {
        return column;
    }

    public void setColumn(TColumn column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "TCustomerColumn{" +
                "customer=" + customer +
                ", column=" + column +
                ", id=" + id +
                ", customerId=" + customerId +
                ", columnId=" + columnId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", remark='" + remark + '\'' +
                ", pauseTime=" + pauseTime +
                ", state=" + state +
                '}';
    }

    /**
     * 
     */
    private Long id;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 栏目ID
     */
    private Long columnId;

    /**
     * 开始日期
     */
    private Date startTime;

    /**
     * 结束日期
     */
    private Date endTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 暂停日期
     */
    private Date pauseTime;

    /**
     * 状态 0：正常 1：暂停 2：终止
     */
    private Long state;

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
     * 客户ID
     * @return customer_id 客户ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 客户ID
     * @param customerId 客户ID
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 栏目ID
     * @return column_id 栏目ID
     */
    public Long getColumnId() {
        return columnId;
    }

    /**
     * 栏目ID
     * @param columnId 栏目ID
     */
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    /**
     * 开始日期
     * @return start_time 开始日期
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始日期
     * @param startTime 开始日期
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束日期
     * @return end_time 结束日期
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束日期
     * @param endTime 结束日期
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 暂停日期
     * @return pause_time 暂停日期
     */
    public Date getPauseTime() {
        return pauseTime;
    }

    /**
     * 暂停日期
     * @param pauseTime 暂停日期
     */
    public void setPauseTime(Date pauseTime) {
        this.pauseTime = pauseTime;
    }

    /**
     * 状态 0：正常 1：暂停 2：终止
     * @return state 状态 0：正常 1：暂停 2：终止
     */
    public Long getState() {
        return state;
    }

    /**
     * 状态 0：正常 1：暂停 2：终止
     * @param state 状态 0：正常 1：暂停 2：终止
     */
    public void setState(Long state) {
        this.state = state;
    }
}