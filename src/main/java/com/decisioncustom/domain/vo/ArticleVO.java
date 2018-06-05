package com.decisioncustom.domain.vo;

import java.util.List;

/**
 * 描述:t_article表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-29
 */
public class ArticleVO {

    private List<ArticleVO> children;

    private String createTimeStr;
    /**
     *
     */
    private Long id;
    /**
     * 文章标题
     */
    private String title;

    /**
     * 标题图片
     */
    private String titleImg;

    /**
     * 点赞量
     */
    private Long thumbUpQuantity;

    /**
     * 阅读量
     */
    private Long readingQuantity;


    /**
     * 文章摘要
     */
    private String articleIntro;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public Long getThumbUpQuantity() {
        return thumbUpQuantity;
    }

    public void setThumbUpQuantity(Long thumbUpQuantity) {
        this.thumbUpQuantity = thumbUpQuantity;
    }

    public Long getReadingQuantity() {
        return readingQuantity;
    }

    public void setReadingQuantity(Long readingQuantity) {
        this.readingQuantity = readingQuantity;
    }

    public String getArticleIntro() {
        return articleIntro;
    }

    public void setArticleIntro(String articleIntro) {
        this.articleIntro = articleIntro;
    }

    public List<ArticleVO> getChildren() {
        return children;
    }

    public void setChildren(List<ArticleVO> children) {
        this.children = children;
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