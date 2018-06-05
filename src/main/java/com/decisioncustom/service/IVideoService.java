package com.decisioncustom.service;


import com.decisioncustom.domain.TVideo;
import com.decisioncustom.query.ArticleQuery;

import java.util.List;

public interface IVideoService extends ICrudService<TVideo,Long> {
    /*根据条件查询视频*/
    List<TVideo> getVideoByQuery(ArticleQuery articleQuery);
}
