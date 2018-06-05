package com.decisioncustom.pojo;

import com.decisioncustom.domain.MTextType;

public class Text {
    private Long id;
    private String titleImg;
    private String title;
    private String textIntroDetails;
    private String original;
    private String top;
    private MTextType textType;

    private String editorValue;

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEditorValue() {
        return editorValue;
    }

    public void setEditorValue(String editorValue) {
        this.editorValue = editorValue;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public MTextType getTextType() {
        return textType;
    }

    public void setTextType(MTextType textType) {
        this.textType = textType;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextIntroDetails() {
        return textIntroDetails;
    }

    public void setTextIntroDetails(String textIntroDetails) {
        this.textIntroDetails = textIntroDetails;
    }

    @Override
    public String toString() {
        return "Text{" +
                "titleImg='" + titleImg + '\'' +
                ", title='" + title + '\'' +
                ", textIntroDetails='" + textIntroDetails + '\'' +
                ", original='" + original + '\'' +
                ", textType=" + textType +
                ", editorValue='" + editorValue + '\'' +
                '}';
    }
}
