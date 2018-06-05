package com.decisioncustom.query;

import java.util.Arrays;

public class CustomerQuery extends BaseQuery{

    private String realName;
    private String endTime;

    private String[] servicemanStr;

    private Long customerId;

    private Long team;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String[] getServicemanStr() {
        return servicemanStr;
    }

    public void setServicemanStr(String[] servicemanStr) {
        this.servicemanStr = servicemanStr;
    }


    public Long getTeam() {
        return team;
    }

    public void setTeam(Long team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "realName='" + realName + '\'' +
                ", endTime='" + endTime + '\'' +
                ", servicemanStr=" + Arrays.toString(servicemanStr) +
                ", customerId=" + customerId +
                ", team=" + team +
                '}';
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
