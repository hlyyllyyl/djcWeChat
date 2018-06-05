package com.decisioncustom.mapper;


import com.decisioncustom.domain.TIntelligenceAgencies;

import java.util.List;

public interface TIntelligenceAgenciesMapper extends CrudMapper<TIntelligenceAgencies> {
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
