package com.decisioncustom.service;


import com.decisioncustom.domain.TResearchResult;

import java.util.List;

public interface IResearchResultService extends ICrudService<TResearchResult,Long> {

    /**
     * 查询所有最新研究成果
     * @return
     */
    List<TResearchResult> getAllResearchResult();

    /**
     * 查询所有最新研究成果
     * @return
     */
    TResearchResult getResearchResultText(Long textId);

}
