package com.decisioncustom.mapper;


import com.decisioncustom.domain.TArticle;
import com.decisioncustom.query.ArticleQuery;

import java.util.List;

public interface TArticleMapper extends CrudMapper<TArticle> {

    /*根据栏目类型查询文章*/
    List<TArticle> getArticleByColumn(Long columnId);

    /*根据文章ID查询文章*/
    TArticle getArticleById(Long id);

    /*根据文章ID查询文章*/
    TArticle getNextByQuery(ArticleQuery articleQuery);

    /*根据条件查询文章*/
    List<TArticle> getArticleByQuery(ArticleQuery articleQuery);
}
