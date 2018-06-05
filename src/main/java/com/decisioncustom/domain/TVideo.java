package com.decisioncustom.domain;

import java.util.Date;

/**
 * 描述:t_video表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-14
 */
public class TVideo {
    private TEmployee employee;

    private TColumn column;

    private TEmployee auditMan;

    private String createTimeStr;


    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
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

    public TEmployee getAuditMan() {
        return auditMan;
    }

    public void setAuditMan(TEmployee auditMan) {
        this.auditMan = auditMan;
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
     * 视频标题
     */
    private String title;

    /**
     * 视频缩略图
     */
    private String thumbnailPath;

    /**
     * 视频时长
     */
    private String videoDuration;

    /**
     * 视频路径
     */
    private String videoPath;

    /**
     * 视频简介
     */
    private String videoIntroDetails;

    /**
     * 创建时间
     */
    private Date creationTime;

    /**
     * 视频类型ID
     */
    private Long columnId;

    /**
     * 置顶 0：否，1：是
     */
    private Integer top;

    /**
     * 播放量
     */
    private Long playQuantity;

    /**
     * 点赞量
     */
    private Long thumbUpQuantity;

    /**
     * 视频标签
     */
    private String tag;

    /**
     * 审核人ID
     */
    private Long auditId;

    /**
     * 审核备注
     */
    private String auditRemark;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 状态 0：审核通过, -1：审核失败, 1：审核中，2：回收站
     */
    private Integer state;

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
     * 视频标题
     * @return title 视频标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 视频标题
     * @param title 视频标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 视频缩略图
     * @return thumbnail_path 视频缩略图
     */
    public String getThumbnailPath() {
        return thumbnailPath;
    }

    /**
     * 视频缩略图
     * @param thumbnailPath 视频缩略图
     */
    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath == null ? null : thumbnailPath.trim();
    }

    /**
     * 视频时长
     * @return video_duration 视频时长
     */
    public String getVideoDuration() {
        return videoDuration;
    }

    /**
     * 视频时长
     * @param videoDuration 视频时长
     */
    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration == null ? null : videoDuration.trim();
    }

    /**
     * 视频路径
     * @return video_path 视频路径
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * 视频路径
     * @param videoPath 视频路径
     */
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }

    /**
     * 视频简介
     * @return video_intro_details 视频简介
     */
    public String getVideoIntroDetails() {
        return videoIntroDetails;
    }

    /**
     * 视频简介
     * @param videoIntroDetails 视频简介
     */
    public void setVideoIntroDetails(String videoIntroDetails) {
        this.videoIntroDetails = videoIntroDetails == null ? null : videoIntroDetails.trim();
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
     * 视频类型ID
     * @return column_id 视频类型ID
     */
    public Long getColumnId() {
        return columnId;
    }

    /**
     * 视频类型ID
     * @param columnId 视频类型ID
     */
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
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
     * 播放量
     * @return play_quantity 播放量
     */
    public Long getPlayQuantity() {
        return playQuantity;
    }

    /**
     * 播放量
     * @param playQuantity 播放量
     */
    public void setPlayQuantity(Long playQuantity) {
        this.playQuantity = playQuantity;
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
     * 视频标签
     * @return tag 视频标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 视频标签
     * @param tag 视频标签
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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
}