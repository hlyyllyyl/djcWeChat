package com.decisioncustom.domain.vo;

/**
 * 描述:t_article表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-29
 */
public class VideoVO {


    private String createTimeStr;
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
}