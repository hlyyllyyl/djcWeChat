package com.decisioncustom.domain;

/**
 * 描述:t_advertising表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-10
 */
public class TAdvertising {
    private TSystemDictionaryItem advertisingType;

    public TSystemDictionaryItem getAdvertisingType() {
        return advertisingType;
    }

    public void setAdvertisingType(TSystemDictionaryItem advertisingType) {
        this.advertisingType = advertisingType;
    }

    @Override
    public String toString() {
        return "TAdvertising{" +
                "advertisingType=" + advertisingType +
                ", id=" + id +
                ", imgPath='" + imgPath + '\'' +
                ", adType=" + adType +
                ", sequence=" + sequence +
                ", adPath='" + adPath + '\'' +
                ", articleIntroDetails='" + articleIntroDetails + '\'' +
                '}';
    }

    /**
     *
     */
    private Long id;

    /**
     * 图片路径
     */
    private String imgPath;

    /**
     * 广告类型ID
     */
    private Long adType;

    /**
     * 顺序
     */
    private Long sequence;

    /**
     * 广告链接
     */
    private String adPath;

    /**
     * 广告内容
     */
    private String articleIntroDetails;

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
     * 图片路径
     * @return img_path 图片路径
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 图片路径
     * @param imgPath 图片路径
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    /**
     * 广告类型ID
     * @return ad_type 广告类型ID
     */
    public Long getAdType() {
        return adType;
    }

    /**
     * 广告类型ID
     * @param adType 广告类型ID
     */
    public void setAdType(Long adType) {
        this.adType = adType;
    }

    /**
     * 顺序
     * @return sequence 顺序
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * 顺序
     * @param sequence 顺序
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    /**
     * 广告链接
     * @return ad_path 广告链接
     */
    public String getAdPath() {
        return adPath;
    }

    /**
     * 广告链接
     * @param adPath 广告链接
     */
    public void setAdPath(String adPath) {
        this.adPath = adPath == null ? null : adPath.trim();
    }

    /**
     * 广告内容
     * @return article_intro_details 广告内容
     */
    public String getArticleIntroDetails() {
        return articleIntroDetails;
    }

    /**
     * 广告内容
     * @param articleIntroDetails 广告内容
     */
    public void setArticleIntroDetails(String articleIntroDetails) {
        this.articleIntroDetails = articleIntroDetails == null ? null : articleIntroDetails.trim();
    }
}