package com.decisioncustom.pojo;

import java.util.Date;

public class CustomerCompanyPojo {
    private String companyName;
    private Long outside;
    private Long inside;
    private Long loss;
    private Long notContact;
    private Long lossNotContact;
    private Long serviceDissatisfaction;
    private Long notCompact;
    private Long badAttitude;
    private Long notWant;
    private Long disapprovingProduct;
    private Long seekRedress;
    private Date createTime;
    private Date createTimeM;

    @Override
    public String toString() {
        return "CustomerCompanyPojo{" +
                "companyName='" + companyName + '\'' +
                ", outside=" + outside +
                ", inside=" + inside +
                ", loss=" + loss +
                ", notContact=" + notContact +
                ", lossNotContact=" + lossNotContact +
                ", serviceDissatisfaction=" + serviceDissatisfaction +
                ", notCompact=" + notCompact +
                ", badAttitude=" + badAttitude +
                ", notWant=" + notWant +
                ", disapprovingProduct=" + disapprovingProduct +
                ", seekRedress=" + seekRedress +
                ", createTime=" + createTime +
                ", createTimeM=" + createTimeM +
                '}';
    }

    public Date getCreateTimeM() {
        return createTimeM;
    }

    public void setCreateTimeM(Date createTimeM) {
        this.createTimeM = createTimeM;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getOutside() {
        return outside;
    }

    public void setOutside(Long outside) {
        this.outside = outside;
    }

    public Long getInside() {
        return inside;
    }

    public void setInside(Long inside) {
        this.inside = inside;
    }

    public Long getLoss() {
        return loss;
    }

    public void setLoss(Long loss) {
        this.loss = loss;
    }

    public Long getNotContact() {
        return notContact;
    }

    public void setNotContact(Long notContact) {
        this.notContact = notContact;
    }

    public Long getLossNotContact() {
        return lossNotContact;
    }

    public void setLossNotContact(Long lossNotContact) {
        this.lossNotContact = lossNotContact;
    }

    public Long getServiceDissatisfaction() {
        return serviceDissatisfaction;
    }

    public void setServiceDissatisfaction(Long serviceDissatisfaction) {
        this.serviceDissatisfaction = serviceDissatisfaction;
    }

    public Long getNotCompact() {
        return notCompact;
    }

    public void setNotCompact(Long notCompact) {
        this.notCompact = notCompact;
    }

    public Long getBadAttitude() {
        return badAttitude;
    }

    public void setBadAttitude(Long badAttitude) {
        this.badAttitude = badAttitude;
    }

    public Long getNotWant() {
        return notWant;
    }

    public void setNotWant(Long notWant) {
        this.notWant = notWant;
    }

    public Long getDisapprovingProduct() {
        return disapprovingProduct;
    }

    public void setDisapprovingProduct(Long disapprovingProduct) {
        this.disapprovingProduct = disapprovingProduct;
    }

    public Long getSeekRedress() {
        return seekRedress;
    }

    public void setSeekRedress(Long seekRedress) {
        this.seekRedress = seekRedress;
    }
}
