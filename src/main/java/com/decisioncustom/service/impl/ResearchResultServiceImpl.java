package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TResearchResult;
import com.decisioncustom.mapper.TResearchResultMapper;
import com.decisioncustom.service.IResearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public  class ResearchResultServiceImpl extends ICrudServiceImpl<TResearchResult,Long> implements IResearchResultService {
    @Autowired
    private TResearchResultMapper researchResultMapper;

    @Override
    public List<TResearchResult> getAllResearchResult() {
        return researchResultMapper.getAllResearchResult();
    }

    @Override
    public TResearchResult getResearchResultText(Long textId) {
        return researchResultMapper.getResearchResultText(textId);
    }
}
