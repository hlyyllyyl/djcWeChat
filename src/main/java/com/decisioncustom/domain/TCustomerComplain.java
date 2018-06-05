package com.decisioncustom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCustomerComplain {

    private List<TEmployee> saleMans = new ArrayList<>();

    private TSystemDictionaryItem complainType;
    private TSystemDictionaryItem company;
    private TSystemDictionaryItem complainReason;
    private TSystemDictionaryItem processingResults;
    private TSystemDictionaryItem complainSource;

    private TEmployee transfer;

    private  TCustomer customer;


    private String createTimeStr;
    private String handleTimeStr;
    private String customerStr;
    private String complainTypeStr;
    private String complainReasonStr;
    private String processingResultsStr;
    private String transferStr;
    private String complainReasonDetailStr;
    private String complainSourceStr;

    @Override
    public String toString() {
        return "TCustomerComplain{" +
                "saleMans=" + saleMans +
                ", complainType=" + complainType +
                ", company=" + company +
                ", complainReason=" + complainReason +
                ", processingResults=" + processingResults +
                ", complainSource=" + complainSource +
                ", transfer=" + transfer +
                ", customer=" + customer +
                ", complainReasonDetail=" + complainReasonDetail +
                ", id=" + id +
                ", createTime=" + createTime +
                ", handleTime=" + handleTime +
                ", customerId=" + customerId +
                ", complainTypeId=" + complainTypeId +
                ", companyId=" + companyId +
                ", complainReasonId=" + complainReasonId +
                ", complainReasonDetailId=" + complainReasonDetailId +
                ", transferId=" + transferId +
                ", trackingProcess='" + trackingProcess + '\'' +
                ", processingResultsId=" + processingResultsId +
                ", remarks='" + remarks + '\'' +
                ", complainSourceId=" + complainSourceId +
                '}';
    }

    public String getComplainReasonDetailStr() {
        return complainReasonDetailStr;
    }

    public void setComplainReasonDetailStr(String complainReasonDetailStr) {
        this.complainReasonDetailStr = complainReasonDetailStr;
    }

    public String getTransferStr() {
        return transferStr;
    }

    public void setTransferStr(String transferStr) {
        this.transferStr = transferStr;
    }

    public String getComplainSourceStr() {
        return complainSourceStr;
    }

    public void setComplainSourceStr(String complainSourceStr) {
        this.complainSourceStr = complainSourceStr;
    }

    public String getComplainReasonStr() {
        return complainReasonStr;
    }

    public void setComplainReasonStr(String complainReasonStr) {
        this.complainReasonStr = complainReasonStr;
    }

    public String getProcessingResultsStr() {
        return processingResultsStr;
    }

    public void setProcessingResultsStr(String processingResultsStr) {
        this.processingResultsStr = processingResultsStr;
    }

    public String getCustomerStr() {
        return customerStr;
    }

    public void setCustomerStr(String customerStr) {
        this.customerStr = customerStr;
    }

    public String getComplainTypeStr() {
        return complainTypeStr;
    }

    public void setComplainTypeStr(String complainTypeStr) {
        this.complainTypeStr = complainTypeStr;
    }

    public String getHandleTimeStr() {
        return handleTimeStr;
    }

    public void setHandleTimeStr(String handleTimeStr) {
        this.handleTimeStr = handleTimeStr;
    }

    public String getCreateTimeStr() {

        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    private TCustomerComplainText complainReasonDetail;

    public List<TCustomerComplainEmployee> getCustomerComplainEmployee() {
        List<TCustomerComplainEmployee> list_rp = new ArrayList<>();
        Long id = this.getId();
        List<TEmployee> p = this.getSaleMans();
        for (TEmployee p2 : p) {
            list_rp.add(new TCustomerComplainEmployee(id, p2.getId()));
        }
        return list_rp;
    }

    public TCustomerComplainText getComplainReasonDetail() {
        return complainReasonDetail;
    }

    public void setComplainReasonDetail(TCustomerComplainText complainReasonDetail) {
        this.complainReasonDetail = complainReasonDetail;
    }

    public List<TEmployee> getSaleMans() {
        return saleMans;
    }

    public void setSaleMans(List<TEmployee> saleMans) {
        this.saleMans = saleMans;
    }

    public TCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TCustomer customer) {
        this.customer = customer;
    }

    public TEmployee getTransfer() {
        return transfer;
    }

    public void setTransfer(TEmployee transfer) {
        this.transfer = transfer;
    }

    public TSystemDictionaryItem getComplainType() {
        return complainType;
    }

    public void setComplainType(TSystemDictionaryItem complainType) {
        this.complainType = complainType;
    }

    public TSystemDictionaryItem getCompany() {
        return company;
    }

    public void setCompany(TSystemDictionaryItem company) {
        this.company = company;
    }

    public TSystemDictionaryItem getComplainReason() {
        return complainReason;
    }

    public void setComplainReason(TSystemDictionaryItem complainReason) {
        this.complainReason = complainReason;
    }

    public TSystemDictionaryItem getProcessingResults() {
        return processingResults;
    }

    public void setProcessingResults(TSystemDictionaryItem processingResults) {
        this.processingResults = processingResults;
    }

    public TSystemDictionaryItem getComplainSource() {
        return complainSource;
    }

    public void setComplainSource(TSystemDictionaryItem complainSource) {
        this.complainSource = complainSource;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.handle_time
     *
     * @mbggenerated
     */
    private Date handleTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.customer_id
     *
     * @mbggenerated
     */
    private Long customerId;



    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.complain_type_id
     *
     * @mbggenerated
     */
    private Long complainTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.company_id
     *
     * @mbggenerated
     */
    private Long companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.complain_reason_id
     *
     * @mbggenerated
     */
    private Long complainReasonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.complain_reason_detail_id
     *
     * @mbggenerated
     */
    private Long complainReasonDetailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.transfer_id
     *
     * @mbggenerated
     */
    private Long transferId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.tracking_process
     *
     * @mbggenerated
     */
    private String trackingProcess;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.processing_results_id
     *
     * @mbggenerated
     */
    private Long processingResultsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.remarks
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_complain.complain_source_id
     *
     * @mbggenerated
     */
    private Long complainSourceId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.id
     *
     * @return the value of t_customer_complain.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.id
     *
     * @param id the value for t_customer_complain.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.create_time
     *
     * @return the value of t_customer_complain.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.create_time
     *
     * @param createTime the value for t_customer_complain.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.handle_time
     *
     * @return the value of t_customer_complain.handle_time
     *
     * @mbggenerated
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.handle_time
     *
     * @param handleTime the value for t_customer_complain.handle_time
     *
     * @mbggenerated
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.customer_id
     *
     * @return the value of t_customer_complain.customer_id
     *
     * @mbggenerated
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.customer_id
     *
     * @param customerId the value for t_customer_complain.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.complain_type_id
     *
     * @return the value of t_customer_complain.complain_type_id
     *
     * @mbggenerated
     */
    public Long getComplainTypeId() {
        return complainTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.complain_type_id
     *
     * @param complainTypeId the value for t_customer_complain.complain_type_id
     *
     * @mbggenerated
     */
    public void setComplainTypeId(Long complainTypeId) {
        this.complainTypeId = complainTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.company_id
     *
     * @return the value of t_customer_complain.company_id
     *
     * @mbggenerated
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.company_id
     *
     * @param companyId the value for t_customer_complain.company_id
     *
     * @mbggenerated
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.complain_reason_id
     *
     * @return the value of t_customer_complain.complain_reason_id
     *
     * @mbggenerated
     */
    public Long getComplainReasonId() {
        return complainReasonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.complain_reason_id
     *
     * @param complainReasonId the value for t_customer_complain.complain_reason_id
     *
     * @mbggenerated
     */
    public void setComplainReasonId(Long complainReasonId) {
        this.complainReasonId = complainReasonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.complain_reason_detail_id
     *
     * @return the value of t_customer_complain.complain_reason_detail_id
     *
     * @mbggenerated
     */
    public Long getComplainReasonDetailId() {
        return complainReasonDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.complain_reason_detail_id
     *
     * @param complainReasonDetailId the value for t_customer_complain.complain_reason_detail_id
     *
     * @mbggenerated
     */
    public void setComplainReasonDetailId(Long complainReasonDetailId) {
        this.complainReasonDetailId = complainReasonDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.transfer_id
     *
     * @return the value of t_customer_complain.transfer_id
     *
     * @mbggenerated
     */
    public Long getTransferId() {
        return transferId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.transfer_id
     *
     * @param transferId the value for t_customer_complain.transfer_id
     *
     * @mbggenerated
     */
    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.tracking_process
     *
     * @return the value of t_customer_complain.tracking_process
     *
     * @mbggenerated
     */
    public String getTrackingProcess() {
        return trackingProcess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.tracking_process
     *
     * @param trackingProcess the value for t_customer_complain.tracking_process
     *
     * @mbggenerated
     */
    public void setTrackingProcess(String trackingProcess) {
        this.trackingProcess = trackingProcess == null ? null : trackingProcess.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.processing_results_id
     *
     * @return the value of t_customer_complain.processing_results_id
     *
     * @mbggenerated
     */
    public Long getProcessingResultsId() {
        return processingResultsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.processing_results_id
     *
     * @param processingResultsId the value for t_customer_complain.processing_results_id
     *
     * @mbggenerated
     */
    public void setProcessingResultsId(Long processingResultsId) {
        this.processingResultsId = processingResultsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.remarks
     *
     * @return the value of t_customer_complain.remarks
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.remarks
     *
     * @param remarks the value for t_customer_complain.remarks
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_complain.complain_source_id
     *
     * @return the value of t_customer_complain.complain_source_id
     *
     * @mbggenerated
     */
    public Long getComplainSourceId() {
        return complainSourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_complain.complain_source_id
     *
     * @param complainSourceId the value for t_customer_complain.complain_source_id
     *
     * @mbggenerated
     */
    public void setComplainSourceId(Long complainSourceId) {
        this.complainSourceId = complainSourceId;
    }
}