package com.decisioncustom.service;


import com.decisioncustom.domain.TIntelligenceAgencies;

import java.util.List;

public interface IIntelligenceAgenciesService extends ICrudService<TIntelligenceAgencies,Long> {
    /**
     * 查询所有机构情报
     * @return
     */
    List<TIntelligenceAgencies> getAllintelligenceAgencies();

    /**
     * 根据文章ID查询机构情报
     * @return
     */
    TIntelligenceAgencies getIntelligenceAgenciesText(Long textId);
}
