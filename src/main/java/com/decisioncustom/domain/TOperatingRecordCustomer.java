package com.decisioncustom.domain;

public class TOperatingRecordCustomer {
    public TOperatingRecordCustomer(Long operatingRecordId, Long customerId) {
        super();
        this.operatingRecordId = operatingRecordId;
        this.customerId = customerId;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operating_record_customer.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operating_record_customer.operating_record_id
     *
     * @mbggenerated
     */
    private Long operatingRecordId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_operating_record_customer.customer_id
     *
     * @mbggenerated
     */
    private Long customerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_operating_record_customer.id
     *
     * @return the value of t_operating_record_customer.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_operating_record_customer.id
     *
     * @param id the value for t_operating_record_customer.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_operating_record_customer.operating_record_id
     *
     * @return the value of t_operating_record_customer.operating_record_id
     *
     * @mbggenerated
     */
    public Long getOperatingRecordId() {
        return operatingRecordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_operating_record_customer.operating_record_id
     *
     * @param operatingRecordId the value for t_operating_record_customer.operating_record_id
     *
     * @mbggenerated
     */
    public void setOperatingRecordId(Long operatingRecordId) {
        this.operatingRecordId = operatingRecordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_operating_record_customer.customer_id
     *
     * @return the value of t_operating_record_customer.customer_id
     *
     * @mbggenerated
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_operating_record_customer.customer_id
     *
     * @param customerId the value for t_operating_record_customer.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}