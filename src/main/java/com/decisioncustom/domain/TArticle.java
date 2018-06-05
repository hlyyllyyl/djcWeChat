package com.decisioncustom.domain;

import java.util.Date;
import java.util.List;

/**
 * 描述:t_article表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-29
 */
public class TArticle {
    private TEmployee employee;

    private TColumn column;
    private TSystemDictionaryItem  systemDictionaryItem;
    private List<TArticle> children;

    public TSystemDictionaryItem getSystemDictionaryItem() {
        return systemDictionaryItem;
    }

    public void setSystemDictionaryItem(TSystemDictionaryItem systemDictionaryItem) {
        this.systemDictionaryItem = systemDictionaryItem;
    }

    public List<TArticle> getChildren() {
        return children;
    }

    public void setChildren(List<TArticle> children) {
        this.children = children;
    }

    public TEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(TEmployee employee) {
        this.employee = employee;
    }

    public TColumn getColumn() {
        return column;
    }

    public void setColumn(TColumn column) {
        this.column = column;
    }

    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }


    /**
     * 
     */
    private Long id;

    /**
     * 老师ID
     */
    private Long teacherId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 标题图片
     */
    private String titleImg;

    /**
     * 文章标签ID
     */
    private Long tagId;

    /**
     * 来源
     */
    private String source;

    /**
     * 创建时间
     */
    private Date creationTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 点赞量
     */
    private Long thumbUpQuantity;

    /**
     * 阅读量
     */
    private Long readingQuantity;

    /**
     * 置顶 0：否，1：是
     */
    private Integer top;

    /**
     * 专题文章ID
     */
    private Long parentId;

    /**
     * 文章类型ID
     */
    private Long columnId;

    /**
     * 文章摘要
     */
    private String articleIntro;

    /**
     * 相关链接
     */
    private String url;

    /**
     * 链接标题
     */
    private String urlTitle;

    /**
     * 音频标题
     */
    private String voiceTitle;

    /**
     * 音频路径
     */
    private String voicePath;

    /**
     * 审核人ID
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
     * 股票代码
     */
    private String stocks;

    /**
     * 状态 0：审核通过, -1：审核失败, 1：审核中，2：回收站
     */
    private Integer state;

    /**
     * 文章内容
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
     * 文章标题
     * @return title 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 文章标题
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 标题图片
     * @return title_img 标题图片
     */
    public String getTitleImg() {
        return titleImg;
    }

    /**
     * 标题图片
     * @param titleImg 标题图片
     */
    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg == null ? null : titleImg.trim();
    }

    /**
     * 文章标签ID
     * @return tag_id 文章标签ID
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 文章标签ID
     * @param tagId 文章标签ID
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * 来源
     * @return source 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 来源
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 创建时间
     * @return creation_time 创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * 创建时间
     * @param creationTime 创建时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 点赞量
     * @return thumb_up_quantity 点赞量
     */
    public Long getThumbUpQuantity() {
        return thumbUpQuantity;
    }

    /**
     * 点赞量
     * @param thumbUpQuantity 点赞量
     */
    public void setThumbUpQuantity(Long thumbUpQuantity) {
        this.thumbUpQuantity = thumbUpQuantity;
    }

    /**
     * 阅读量
     * @return reading_quantity 阅读量
     */
    public Long getReadingQuantity() {
        return readingQuantity;
    }

    /**
     * 阅读量
     * @param readingQuantity 阅读量
     */
    public void setReadingQuantity(Long readingQuantity) {
        this.readingQuantity = readingQuantity;
    }

    /**
     * 置顶 0：否，1：是
     * @return top 置顶 0：否，1：是
     */
    public Integer getTop() {
        return top;
    }

    /**
     * 置顶 0：否，1：是
     * @param top 置顶 0：否，1：是
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * 专题文章ID
     * @return parent_id 专题文章ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 专题文章ID
     * @param parentId 专题文章ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 文章类型ID
     * @return column_id 文章类型ID
     */
    public Long getColumnId() {
        return columnId;
    }

    /**
     * 文章类型ID
     * @param columnId 文章类型ID
     */
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    /**
     * 文章摘要
     * @return article_intro 文章摘要
     */
    public String getArticleIntro() {
        return articleIntro;
    }

    /**
     * 文章摘要
     * @param articleIntro 文章摘要
     */
    public void setArticleIntro(String articleIntro) {
        this.articleIntro = articleIntro == null ? null : articleIntro.trim();
    }

    /**
     * 相关链接
     * @return url 相关链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 相关链接
     * @param url 相关链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 链接标题
     * @return url_title 链接标题
     */
    public String getUrlTitle() {
        return urlTitle;
    }

    /**
     * 链接标题
     * @param urlTitle 链接标题
     */
    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle == null ? null : urlTitle.trim();
    }

    /**
     * 音频标题
     * @return voice_title 音频标题
     */
    public String getVoiceTitle() {
        return voiceTitle;
    }

    /**
     * 音频标题
     * @param voiceTitle 音频标题
     */
    public void setVoiceTitle(String voiceTitle) {
        this.voiceTitle = voiceTitle == null ? null : voiceTitle.trim();
    }

    /**
     * 音频路径
     * @return voice_path 音频路径
     */
    public String getVoicePath() {
        return voicePath;
    }

    /**
     * 音频路径
     * @param voicePath 音频路径
     */
    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath == null ? null : voicePath.trim();
    }

    /**
     * 审核人ID
     * @return audit_id 审核人ID
     */
    public Long getAuditId() {
        return auditId;
    }

    /**
     * 审核人ID
     * @param auditId 审核人ID
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

    /**
     * 股票代码
     * @return stocks 股票代码
     */
    public String getStocks() {
        return stocks;
    }

    /**
     * 股票代码
     * @param stocks 股票代码
     */
    public void setStocks(String stocks) {
        this.stocks = stocks == null ? null : stocks.trim();
    }

    /**
     * 状态 0：审核通过, -1：审核失败, 1：审核中，2：回收站
     * @return state 状态 0：审核通过, -1：审核失败, 1：审核中，2：回收站
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态 0：审核通过, -1：审核失败, 1：审核中，2：回收站
     * @param state 状态 0：审核通过, -1：审核失败, 1：审核中，2：回收站
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 文章内容
     * @return article_intro_details 文章内容
     */
    public String getArticleIntroDetails() {
        return articleIntroDetails;
    }

    /**
     * 文章内容
     * @param articleIntroDetails 文章内容
     */
    public void setArticleIntroDetails(String articleIntroDetails) {
        this.articleIntroDetails = articleIntroDetails == null ? null : articleIntroDetails.trim();
    }
}