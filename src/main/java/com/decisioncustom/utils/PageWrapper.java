package com.decisioncustom.utils;/*
package com.maidou.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageWrapper<T> {
    private static final String URL_PARAM_PAGE = "page";
    private static final String URL_PARAM_SIZE = "size";
    private static final String DEFAULT_ENCODING = "UTF-8";

    public static final int MAX_PAGE_ITEM_DISPLAY = 5;
    private Page<T> page;
    private List<PageItem> items;
    private int currentNumber;
    private String url;
    private Map<String, String[]> params;

    public String getUrl() {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append(url);
            builder.append("?");
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    if (!StringUtils.equals(URL_PARAM_PAGE, key) && !StringUtils.equals(URL_PARAM_SIZE, key)) {
                        builder.append(URLEncoder.encode(key, DEFAULT_ENCODING));
                        builder.append("=");
                        builder.append(URLEncoder.encode(value, DEFAULT_ENCODING));
                        builder.append("&");
                    }
                }
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }
        String pageUrl = builder.toString();
        pageUrl = pageUrl.substring(0, pageUrl.length() - 1); //去掉末尾的&
        return pageUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageWrapper(Page<T> page, String url, Map<String, String[]> params) {
        this.page = page;
        this.url = url;
        this.params = params;
        items = new ArrayList<PageItem>();
        currentNumber = page.getNumber() + 1;
        int start, size;
        if (page.getTotalPages() <= MAX_PAGE_ITEM_DISPLAY) {
            start = 1;
            size = page.getTotalPages();
        } else {
            if (currentNumber <= MAX_PAGE_ITEM_DISPLAY - MAX_PAGE_ITEM_DISPLAY / 2) {
                start = 1;
                size = MAX_PAGE_ITEM_DISPLAY;
            } else if (currentNumber >= page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY / 2) {
                start = page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY + 1;
                size = MAX_PAGE_ITEM_DISPLAY;
            } else {
                start = currentNumber - MAX_PAGE_ITEM_DISPLAY / 2;
                size = MAX_PAGE_ITEM_DISPLAY;
            }
        }

        for (int i = 0; i < size; i++) {
            items.add(new PageItem(start + i, (start + i) == currentNumber));
        }

    }

    public List<PageItem> getItems() {
        return items;
    }

    public int getNumber() {
        return currentNumber;
    }

    public List<T> getContent() {
        return page.getContent();
    }

    public int getSize() {
        return page.getSize();
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public boolean isFirstPage() {
        return page.isFirst();
    }

    public boolean isLastPage() {
        return page.isLast();
    }

    public boolean isHasPreviousPage() {
        return page.hasPrevious();
    }

    public boolean isHasNextPage() {
        return page.hasNext();
    }

    public class PageItem {
        private int number;
        private boolean current;

        public PageItem(int number, boolean current) {
            this.number = number;
            this.current = current;
        }

        public int getNumber() {
            return this.number;
        }

        public boolean isCurrent() {
            return this.current;
        }
    }

}
*/
