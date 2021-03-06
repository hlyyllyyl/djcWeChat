package com.decisioncustom.domain;

import java.util.Date;

public class TOperationLog {
    @Override
    public String toString() {
        return "TOperationLog{" +
                "adviser=" + adviser +
                ", id=" + id +
                ", teacherId=" + teacherId +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", logDetails='" + logDetails + '\'' +
                '}';
    }

    private TEmployee adviser;

    public TEmployee getAdviser() {
        return adviser;
    }

    public void setAdviser(TEmployee adviser) {
        this.adviser = adviser;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operation_log.operation_log_id
     *
     * @mbggenerated
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operation_log.teacher_id
     *
     * @mbggenerated
     */
    private Long teacherId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operation_log.creation_time
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operation_log.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operation_log.log_details
     *
     * @mbggenerated
     */
    private String logDetails;


    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_operation_log.creation_time
     *
     * @return the value of t_operation_log.creation_time
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_operation_log.creation_time
     *
     * @param creationTime the value for t_operation_log.creation_time
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_operation_log.update_time
     *
     * @return the value of t_operation_log.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_operation_log.update_time
     *
     * @param updateTime the value for t_operation_log.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_operation_log.log_details
     *
     * @return the value of t_operation_log.log_details
     *
     * @mbggenerated
     */
    public String getLogDetails() {
        return logDetails;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_operation_log.log_details
     *
     * @param logDetails the value for t_operation_log.log_details
     *
     * @mbggenerated
     */
    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails == null ? null : logDetails.trim();
    }
}