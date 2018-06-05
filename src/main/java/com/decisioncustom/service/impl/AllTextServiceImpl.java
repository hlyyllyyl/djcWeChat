package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TAllText;
import com.decisioncustom.mapper.TAllTextMapper;
import com.decisioncustom.query.TextQuery;
import com.decisioncustom.service.IAllTextService;
import com.decisioncustom.utils.log.BussAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public  class AllTextServiceImpl extends ICrudServiceImpl<TAllText,Long> implements IAllTextService {

    @Autowired
    private TAllTextMapper allTextMapper;

    @BussAnnotation(moduleName="人员管理",option="添加用户")
    @Override
    public List<TAllText> getAllTextText(TextQuery textQuery) {
        return allTextMapper.getAllTextText(textQuery);
    }

    @Override
    public TAllText getAllTextById(Long textId) {
        return allTextMapper.getAllTextById(textId);
    }

    @Override
    public void deleteByTextId(Long textId) {
        allTextMapper.deleteByTextId(textId);
    }

    @BussAnnotation(moduleName="文章浏览",option="添加用户")
    @Override
    public TAllText findOneById(Long id) {
        return allTextMapper.selectByPrimaryKey(id);
    }
}
