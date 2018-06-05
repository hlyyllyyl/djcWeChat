package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TVideo;
import com.decisioncustom.mapper.TVideoMapper;
import com.decisioncustom.query.ArticleQuery;
import com.decisioncustom.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public  class VideoServiceImpl extends ICrudServiceImpl<TVideo,Long> implements IVideoService {

    @Autowired
    private TVideoMapper videoMapper;

    @Override
    public List<TVideo> getVideoByQuery(ArticleQuery articleQuery) {
        return videoMapper.getVideoByQuery(articleQuery);
    }
}
