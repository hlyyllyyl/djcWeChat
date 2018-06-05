package com.decisioncustom.query;

public class CustomerComplainQuery extends BaseQuery{

    private String realName;
    private String serviceManName;
    private String createTimeStr;
    private String handleTimeStr;
    private String customerStr;
    private Long complainTypeId;
    private Long complainReasonId;
    private Long companyId;
    private Long processingResultsId;
    private Long transferId;
    private Long complainReasonDetailId;
    private Long complainSourceId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getServiceManName() {
        return serviceManName;
    }

    public void setServiceManName(String serviceManName) {
        this.serviceManName = serviceManName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getHandleTimeStr() {
        return handleTimeStr;
    }

    public void setHandleTimeStr(String handleTimeStr) {
        this.handleTimeStr = handleTimeStr;
    }

    public String getCustomerStr() {
        return customerStr;
    }

    public void setCustomerStr(String customerStr) {
        this.customerStr = customerStr;
    }

    public Long getComplainTypeId() {
        return complainTypeId;
    }

    public void setComplainTypeId(Long complainTypeId) {
        this.complainTypeId = complainTypeId;
    }

    public Long getComplainReasonId() {
        return complainReasonId;
    }

    public void setComplainReasonId(Long complainReasonId) {
        this.complainReasonId = complainReasonId;
    }

    public Long getProcessingResultsId() {
        return processingResultsId;
    }

    public void setProcessingResultsId(Long processingResultsId) {
        this.processingResultsId = processingResultsId;
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Long getComplainReasonDetailId() {
        return complainReasonDetailId;
    }

    public void setComplainReasonDetailId(Long complainReasonDetailId) {
        this.complainReasonDetailId = complainReasonDetailId;
    }

    public Long getComplainSourceId() {
        return complainSourceId;
    }

    public void setComplainSourceId(Long complainSourceId) {
        this.complainSourceId = complainSourceId;
    }
}
