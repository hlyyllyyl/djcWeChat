package com.decisioncustom.mapper;


import com.decisioncustom.domain.TResearchResult;

import java.util.List;

public interface TResearchResultMapper extends CrudMapper<TResearchResult> {
    /**
     * 查询所有最新研究成果
     * @return
     */
    List<TResearchResult> getAllResearchResult();

    /**
     * 根据文章ID查询最新研究成果
     * @return
     */
    TResearchResult getResearchResultText(Long textId);
}
