package com.decisioncustom.query;

import java.util.Arrays;
import java.util.Date;

public class ArticleQuery extends BaseQuery {

    private String title;

    private String teacherName;

    private Integer top;

    private Long state;

    private Long columnId;

    private Long teacherId;

    private Long upId;

    private Long nextId;
    private Date creationTime;

    private Long parentId;

    private String[] tags;

    @Override
    public String toString() {
        return "ArticleQuery{" +
                "title='" + title + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", top=" + top +
                ", state=" + state +
                ", columnId=" + columnId +
                ", teacherId=" + teacherId +
                ", upId=" + upId +
                ", nextId=" + nextId +
                ", creationTime=" + creationTime +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public ArticleQuery() {
    }

    public ArticleQuery(Integer top, Long columnId) {
        this.top = top;
        this.columnId = columnId;
    }

    public ArticleQuery(Integer top, Long columnId, Date creationTime) {
        this.top = top;
        this.columnId = columnId;
        this.creationTime = creationTime;
    }


    public ArticleQuery(Long columnId,  Date creationTime) {
        this.columnId = columnId;
        this.creationTime = creationTime;
    }

    public Long getUpId() {
        return upId;
    }

    public void setUpId(Long upId) {
        this.upId = upId;
    }

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }
}
