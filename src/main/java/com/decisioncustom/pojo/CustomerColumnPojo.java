package com.decisioncustom.pojo;

public class CustomerColumnPojo {
    private Long customerId;
    private Long columnId;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public CustomerColumnPojo(Long customerId, Long columnId) {
        this.customerId = customerId;
        this.columnId = columnId;
    }
}
