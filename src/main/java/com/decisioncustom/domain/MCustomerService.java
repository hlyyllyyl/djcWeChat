package com.decisioncustom.domain;

public class MCustomerService {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_customer_service.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_customer_service.service_hotline
     *
     * @mbggenerated
     */
    private String serviceHotline;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_customer_service.service_qq
     *
     * @mbggenerated
     */
    private String serviceQq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_customer_service.service_wechat
     *
     * @mbggenerated
     */
    private String serviceWechat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_customer_service.id
     *
     * @return the value of m_customer_service.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_customer_service.id
     *
     * @param id the value for m_customer_service.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_customer_service.service_hotline
     *
     * @return the value of m_customer_service.service_hotline
     *
     * @mbggenerated
     */
    public String getServiceHotline() {
        return serviceHotline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_customer_service.service_hotline
     *
     * @param serviceHotline the value for m_customer_service.service_hotline
     *
     * @mbggenerated
     */
    public void setServiceHotline(String serviceHotline) {
        this.serviceHotline = serviceHotline == null ? null : serviceHotline.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_customer_service.service_qq
     *
     * @return the value of m_customer_service.service_qq
     *
     * @mbggenerated
     */
    public String getServiceQq() {
        return serviceQq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_customer_service.service_qq
     *
     * @param serviceQq the value for m_customer_service.service_qq
     *
     * @mbggenerated
     */
    public void setServiceQq(String serviceQq) {
        this.serviceQq = serviceQq == null ? null : serviceQq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_customer_service.service_wechat
     *
     * @return the value of m_customer_service.service_wechat
     *
     * @mbggenerated
     */
    public String getServiceWechat() {
        return serviceWechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_customer_service.service_wechat
     *
     * @param serviceWechat the value for m_customer_service.service_wechat
     *
     * @mbggenerated
     */
    public void setServiceWechat(String serviceWechat) {
        this.serviceWechat = serviceWechat == null ? null : serviceWechat.trim();
    }
}