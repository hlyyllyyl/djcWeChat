package com.decisioncustom.mapper;


import com.decisioncustom.domain.TAllText;
import com.decisioncustom.query.TextQuery;

import java.util.List;

public interface TAllTextMapper extends CrudMapper<TAllText> {

    /**
     * 根据query查询
     * @return
     */
    List<TAllText> getAllTextText(TextQuery textQuery);

    /**
     * 根据文章内容ID查询文章
     * @return
     */
    TAllText getAllTextById(Long textId);

    TAllText  selectById(Long id);

    /**
     * 根据文章内容ID删除
     * @return
     */
    void deleteByTextId(Long textId);

}
