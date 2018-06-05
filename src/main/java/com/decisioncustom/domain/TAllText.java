package com.decisioncustom.domain;

import java.util.Date;

public class TAllText {

    private TEmployee employee;

    public TEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(TEmployee employee) {
        this.employee = employee;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.id
     *
     * @mbggenerated
     */
    private Long id;

    @Override
    public String toString() {
        return "TAllText{" +
                "employee=" + employee +
                ", id=" + id +
                ", teacherId=" + teacherId +
                ", title='" + title + '\'' +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", smallImg='" + smallImg + '\'' +
                ", img='" + img + '\'' +
                ", readingQuantity=" + readingQuantity +
                ", top=" + top +
                ", original=" + original +
                ", textId=" + textId +
                ", textTypeId=" + textTypeId +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.teacher_id
     *
     * @mbggenerated
     */
    private Long teacherId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.creation_time
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.small_img
     *
     * @mbggenerated
     */
    private String smallImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.img
     *
     * @mbggenerated
     */
    private String img;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.reading_quantity
     *
     * @mbggenerated
     */
    private Long readingQuantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.top
     *
     * @mbggenerated
     */
    private Integer top;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.original
     *
     * @mbggenerated
     */
    private Integer original;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.text_id
     *
     * @mbggenerated
     */
    private Long textId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_all_text.text_type_id
     *
     * @mbggenerated
     */
    private Long textTypeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.id
     *
     * @return the value of t_all_text.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.id
     *
     * @param id the value for t_all_text.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.teacher_id
     *
     * @return the value of t_all_text.teacher_id
     *
     * @mbggenerated
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.teacher_id
     *
     * @param teacherId the value for t_all_text.teacher_id
     *
     * @mbggenerated
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.title
     *
     * @return the value of t_all_text.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.title
     *
     * @param title the value for t_all_text.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.creation_time
     *
     * @return the value of t_all_text.creation_time
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.creation_time
     *
     * @param creationTime the value for t_all_text.creation_time
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.update_time
     *
     * @return the value of t_all_text.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.update_time
     *
     * @param updateTime the value for t_all_text.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.small_img
     *
     * @return the value of t_all_text.small_img
     *
     * @mbggenerated
     */
    public String getSmallImg() {
        return smallImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.small_img
     *
     * @param smallImg the value for t_all_text.small_img
     *
     * @mbggenerated
     */
    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg == null ? null : smallImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.img
     *
     * @return the value of t_all_text.img
     *
     * @mbggenerated
     */
    public String getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.img
     *
     * @param img the value for t_all_text.img
     *
     * @mbggenerated
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.reading_quantity
     *
     * @return the value of t_all_text.reading_quantity
     *
     * @mbggenerated
     */
    public Long getReadingQuantity() {
        return readingQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.reading_quantity
     *
     * @param readingQuantity the value for t_all_text.reading_quantity
     *
     * @mbggenerated
     */
    public void setReadingQuantity(Long readingQuantity) {
        this.readingQuantity = readingQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.top
     *
     * @return the value of t_all_text.top
     *
     * @mbggenerated
     */
    public Integer getTop() {
        return top;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.top
     *
     * @param top the value for t_all_text.top
     *
     * @mbggenerated
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.original
     *
     * @return the value of t_all_text.original
     *
     * @mbggenerated
     */
    public Integer getOriginal() {
        return original;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.original
     *
     * @param original the value for t_all_text.original
     *
     * @mbggenerated
     */
    public void setOriginal(Integer original) {
        this.original = original;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.text_id
     *
     * @return the value of t_all_text.text_id
     *
     * @mbggenerated
     */
    public Long getTextId() {
        return textId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.text_id
     *
     * @param textId the value for t_all_text.text_id
     *
     * @mbggenerated
     */
    public void setTextId(Long textId) {
        this.textId = textId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_all_text.text_type_id
     *
     * @return the value of t_all_text.text_type_id
     *
     * @mbggenerated
     */
    public Long getTextTypeId() {
        return textTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_all_text.text_type_id
     *
     * @param textTypeId the value for t_all_text.text_type_id
     *
     * @mbggenerated
     */
    public void setTextTypeId(Long textTypeId) {
        this.textTypeId = textTypeId;
    }
}