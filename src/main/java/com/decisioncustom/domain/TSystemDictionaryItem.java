package com.decisioncustom.domain;

public class TSystemDictionaryItem {

    private TSystemDictionary systemDictionary;

    public TSystemDictionary getSystemDictionary() {
        return systemDictionary;
    }

    public void setSystemDictionary(TSystemDictionary systemDictionary) {
        this.systemDictionary = systemDictionary;
    }

    @Override
    public String toString() {
        return "TSystemDictionaryItem{" +
                "systemDictionary=" + systemDictionary +
                ", id=" + id +
                ", requence=" + requence +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary_item.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary_item.requence
     *
     * @mbggenerated
     */
    private Integer requence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary_item.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary_item.intro
     *
     * @mbggenerated
     */
    private String intro;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary_item.parent_id
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary_item.id
     *
     * @return the value of t_system_dictionary_item.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary_item.id
     *
     * @param id the value for t_system_dictionary_item.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary_item.requence
     *
     * @return the value of t_system_dictionary_item.requence
     *
     * @mbggenerated
     */
    public Integer getRequence() {
        return requence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary_item.requence
     *
     * @param requence the value for t_system_dictionary_item.requence
     *
     * @mbggenerated
     */
    public void setRequence(Integer requence) {
        this.requence = requence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary_item.name
     *
     * @return the value of t_system_dictionary_item.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary_item.name
     *
     * @param name the value for t_system_dictionary_item.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary_item.intro
     *
     * @return the value of t_system_dictionary_item.intro
     *
     * @mbggenerated
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary_item.intro
     *
     * @param intro the value for t_system_dictionary_item.intro
     *
     * @mbggenerated
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary_item.parent_id
     *
     * @return the value of t_system_dictionary_item.parent_id
     *
     * @mbggenerated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary_item.parent_id
     *
     * @param parentId the value for t_system_dictionary_item.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}