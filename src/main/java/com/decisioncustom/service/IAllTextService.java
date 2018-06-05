package com.decisioncustom.service;


import com.decisioncustom.domain.TAllText;
import com.decisioncustom.query.TextQuery;

import java.util.List;

public interface IAllTextService extends ICrudService<TAllText,Long> {

    /**
     * 根据TextQuery查询
     * @return
     */
    List<TAllText> getAllTextText(TextQuery textQuery);

    /**
     * 根据文章内容ID查询
     * @return
     */
    TAllText getAllTextById(Long textId);

    /*浏览文章*/
    TAllText findOneById(Long id);

    /**
     * 根据文章内容ID删除
     * @return
     */
    void deleteByTextId(Long textId);
}
