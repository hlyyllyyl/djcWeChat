package com.decisioncustom.service;


import com.decisioncustom.domain.TJiePan;
import com.decisioncustom.query.JiePanQuery;

import java.util.List;

public interface IJiePanService extends ICrudService<TJiePan,Long>{

    List<TJiePan> selectByQuery(JiePanQuery jiePanQuery);
}
