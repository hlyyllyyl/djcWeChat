package com.decisioncustom.domain.vo;

/**
 * 描述:t_article表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-29
 */
public class VideoInfoVO {


    private String createTimeStr;
    private String videoIntroDetails;
    private String videoPath;

    private EmployeeVO employeeVO;

    /**
     *
     */
    private Long id;
    /**
     * 视频标题
     */
    private String title;


    /**
     * 标题图片
     */
    private String thumbnailPath;

    /**
     * 视频时长
     */
    private String videoDuration;

    /**
     * 播放量
     */
    private Long playQuantity;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    public Long getPlayQuantity() {
        return playQuantity;
    }

    public void setPlayQuantity(Long playQuantity) {
        this.playQuantity = playQuantity;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoIntroDetails() {
        return videoIntroDetails;
    }

    public void setVideoIntroDetails(String videoIntroDetails) {
        this.videoIntroDetails = videoIntroDetails;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }
}