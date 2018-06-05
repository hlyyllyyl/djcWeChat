package com.decisioncustom.mapper;


import com.decisioncustom.domain.TVideo;
import com.decisioncustom.query.ArticleQuery;

import java.util.List;

public interface TVideoMapper extends CrudMapper<TVideo> {
    /*根据条件查询视频*/
    List<TVideo> getVideoByQuery(ArticleQuery articleQuery);
}
