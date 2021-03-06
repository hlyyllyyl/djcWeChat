package com.decisioncustom.domain;

public class MTextType {

    @Override
    public String toString() {
        return "MTextType{" +
                "id=" + id +
                ", textType='" + textType + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_text_type.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_text_type.text_type
     *
     * @mbggenerated
     */
    private String textType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_text_type.id
     *
     * @return the value of m_text_type.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_text_type.id
     *
     * @param id the value for m_text_type.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_text_type.text_type
     *
     * @return the value of m_text_type.text_type
     *
     * @mbggenerated
     */
    public String getTextType() {
        return textType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_text_type.text_type
     *
     * @param textType the value for m_text_type.text_type
     *
     * @mbggenerated
     */
    public void setTextType(String textType) {
        this.textType = textType == null ? null : textType.trim();
    }
}