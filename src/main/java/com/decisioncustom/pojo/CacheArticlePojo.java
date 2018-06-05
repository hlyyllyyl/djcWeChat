package com.decisioncustom.pojo;

public class CacheArticlePojo {
    private Long columnId;
    private Integer pageSize;
    private Integer page;

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public CacheArticlePojo(Long columnId, Integer pageSize, Integer page) {
        this.columnId = columnId;
        this.pageSize = pageSize;
        this.page = page;
    }

    @Override
    public String toString() {
        return "CacheArticlePojo{" +
                "columnId=" + columnId +
                ", pageSize=" + pageSize +
                ", page=" + page +
                '}';
    }
}
