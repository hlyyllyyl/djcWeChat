package com.decisioncustom.domain;

import java.util.List;

/**
 * 描述:t_column表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-04-08
 */
public class TColumn {
    private TColumn parentColumn;
    private TEmployee auditMan;


    private List<TColumn> childrenColumn;

    private List<TArticle> articleList;

    private List<TVideo> videoList;

    public List<TVideo> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<TVideo> videoList) {
        this.videoList = videoList;
    }

    /**
     * 栏目名称备注
     */
    private String nameRemark;

    public List<TArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<TArticle> articleList) {
        this.articleList = articleList;
    }

    public List<TColumn> getChildrenColumn() {
        return childrenColumn;
    }

    public void setChildrenColumn(List<TColumn> childrenColumn) {
        this.childrenColumn = childrenColumn;
    }

    public TEmployee getAuditMan() {
        return auditMan;
    }

    public void setAuditMan(TEmployee auditMan) {
        this.auditMan = auditMan;
    }

    public TColumn getParentColumn() {
        return parentColumn;
    }

    public void setParentColumn(TColumn parentColumn) {
        this.parentColumn = parentColumn;
    }

    public String getNameRemark() {
        return nameRemark;
    }

    public void setNameRemark(String nameRemark) {
        this.nameRemark = nameRemark;
    }

    @Override
    public String toString() {
        return "TColumn{" +
                "parentColumn=" + parentColumn +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", parentId=" + parentId +
                ", auditId=" + auditId +
                ", templateName='" + templateName + '\'' +
                ", rank=" + rank +
                ", isTop=" + isTop +
                '}';
    }

    /**
     * 
     */
    private Long id;

    /**
     * 栏目名称
     */
    private String name;

    /**
     * 栏目选中图标地址
     */
    private String checkImgPath;

    /**
     * 栏目路径
     */
    private String url;

    /**
     * 栏目图标地址
     */
    private String imgPath;

    /**
     * 父栏目ID
     */
    private Long parentId;

    /**
     * 审核人ID
     */
    private Long auditId;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 顺序
     */
    private Integer rank;

    /**
     * 是否置顶 0：否 1：是
     */
    private Integer isTop;

    public String getCheckImgPath() {
        return checkImgPath;
    }

    public void setCheckImgPath(String checkImgPath) {
        this.checkImgPath = checkImgPath;
    }

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
     * 栏目名称
     * @return name 栏目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 栏目名称
     * @param name 栏目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 栏目路径
     * @return url 栏目路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 栏目路径
     * @param url 栏目路径
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 栏目图标地址
     * @return img_path 栏目图标地址
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 栏目图标地址
     * @param imgPath 栏目图标地址
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    /**
     * 父栏目ID
     * @return parent_id 父栏目ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父栏目ID
     * @param parentId 父栏目ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 模板名称
     * @return template_name 模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 模板名称
     * @param templateName 模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     * 顺序
     * @return rank 顺序
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 顺序
     * @param rank 顺序
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 是否置顶 0：否 1：是
     * @return is_top 是否置顶 0：否 1：是
     */
    public Integer getIsTop() {
        return isTop;
    }

    /**
     * 是否置顶 0：否 1：是
     * @param isTop 是否置顶 0：否 1：是
     */
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
}