package com.decisioncustom.domain;

public class TTextIntro {
    @Override
    public String toString() {
        return "TTextIntro{" +
                "id=" + id +
                ", textTypeId=" + textTypeId +
                ", textIntroDetails='" + textIntroDetails + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_text_intro.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_text_intro.text_type_id
     *
     * @mbggenerated
     */
    private Long textTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_text_intro.text_intro_details
     *
     * @mbggenerated
     */
    private String textIntroDetails;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_text_intro.id
     *
     * @return the value of t_text_intro.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_text_intro.id
     *
     * @param id the value for t_text_intro.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_text_intro.text_type_id
     *
     * @return the value of t_text_intro.text_type_id
     *
     * @mbggenerated
     */
    public Long getTextTypeId() {
        return textTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_text_intro.text_type_id
     *
     * @param textTypeId the value for t_text_intro.text_type_id
     *
     * @mbggenerated
     */
    public void setTextTypeId(Long textTypeId) {
        this.textTypeId = textTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_text_intro.text_intro_details
     *
     * @return the value of t_text_intro.text_intro_details
     *
     * @mbggenerated
     */
    public String getTextIntroDetails() {
        return textIntroDetails;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_text_intro.text_intro_details
     *
     * @param textIntroDetails the value for t_text_intro.text_intro_details
     *
     * @mbggenerated
     */
    public void setTextIntroDetails(String textIntroDetails) {
        this.textIntroDetails = textIntroDetails == null ? null : textIntroDetails.trim();
    }
}