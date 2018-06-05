package com.decisioncustom.query;

public class TextQuery extends BaseQuery{

    private String title;

    private String teacherName;

    private Long original;
    private Long top;
    private String startTime;

    private String endTime;
    private Long textTypeId;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getTextTypeId() {
        return textTypeId;
    }

    public void setTextTypeId(Long textTypeId) {
        this.textTypeId = textTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getOriginal() {
        return original;
    }

    public void setOriginal(Long original) {
        this.original = original;
    }

    public Long getTop() {
        return top;
    }

    public void setTop(Long top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "TextQuery{" +
                "title='" + title + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", original=" + original +
                ", top=" + top +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", textTypeId=" + textTypeId +
                '}';
    }
}
