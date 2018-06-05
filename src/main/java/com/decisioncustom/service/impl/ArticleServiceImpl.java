package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TArticle;
import com.decisioncustom.domain.vo.ArticleVO;
import com.decisioncustom.mapper.TArticleMapper;
import com.decisioncustom.query.ArticleQuery;
import com.decisioncustom.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public  class ArticleServiceImpl extends ICrudServiceImpl<TArticle,Long> implements IArticleService {

    @Autowired
    private TArticleMapper articleMapper;

    @Override
    public List<TArticle> getArticleByColumn(Long columnId) {
        return articleMapper.getArticleByColumn(columnId);
    }

    @Override
    public TArticle getArticleById(Long id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public TArticle getNextByQuery(ArticleQuery articleQuery) {
        return articleMapper.getNextByQuery(articleQuery);
    }

    @Override
    public List<TArticle> getArticleByQuery(ArticleQuery articleQuery) {
        return articleMapper.getArticleByQuery(articleQuery);
    }
}
