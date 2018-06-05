package com.decisioncustom.domain;

import java.util.Date;

/**
 * 描述:t_leave_words表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-04-27
 */
public class TLeaveWords {
    private TEmployee teacher;

    private TCustomer customer;

    public TEmployee getTeacher() {
        return teacher;
    }

    public void setTeacher(TEmployee teacher) {
        this.teacher = teacher;
    }

    public TCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TCustomer customer) {
        this.customer = customer;
    }

    /**
     * 留言ID
     */
    private Long id;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 老师ID
     */
    private Long teacherId;

    /**
     * 留言内容
     */
    private String leaveText;

    /**
     * 留言时间
     */
    private Date leaveDate;

    /**
     * 状态 0：待回复, -1：审核失败, 1：审核中 2：回收站 3：已读 4：未读 5：已回复
     */
    private Long state;

    /**
     * 审核人id
     */
    private Long auditId;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核备注
     */
    private String auditRemark;

    /**
     * 留言ID
     * @return id 留言ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 留言ID
     * @param id 留言ID
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
     * 老师ID
     * @return teacher_id 老师ID
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * 老师ID
     * @param teacherId 老师ID
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 留言内容
     * @return leave_text 留言内容
     */
    public String getLeaveText() {
        return leaveText;
    }

    /**
     * 留言内容
     * @param leaveText 留言内容
     */
    public void setLeaveText(String leaveText) {
        this.leaveText = leaveText == null ? null : leaveText.trim();
    }

    /**
     * 留言时间
     * @return leave_date 留言时间
     */
    public Date getLeaveDate() {
        return leaveDate;
    }

    /**
     * 留言时间
     * @param leaveDate 留言时间
     */
    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    /**
     * 状态 0：正常, -1：审核失败, 1：审核中 2：回收站 3：已读 4：未读
     * @return state 状态 0：正常, -1：审核失败, 1：审核中 2：回收站 3：已读 4：未读
     */
    public Long getState() {
        return state;
    }

    /**
     * 状态 0：正常, -1：审核失败, 1：审核中 2：回收站 3：已读 4：未读
     * @param state 状态 0：正常, -1：审核失败, 1：审核中 2：回收站 3：已读 4：未读
     */
    public void setState(Long state) {
        this.state = state;
    }

    /**
     * 审核人id
     * @return audit_id 审核人id
     */
    public Long getAuditId() {
        return auditId;
    }

    /**
     * 审核人id
     * @param auditId 审核人id
     */
    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    /**
     * 审核时间
     * @return audit_time 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 审核时间
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 审核备注
     * @return audit_remark 审核备注
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * 审核备注
     * @param auditRemark 审核备注
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }
}