package com.decisioncustom.mapper;


import com.decisioncustom.domain.TJiePan;
import com.decisioncustom.query.JiePanQuery;

import java.util.List;


public interface TJiePanMapper extends CrudMapper<TJiePan>{

    List<TJiePan> selectByQuery(JiePanQuery jiePanQuery);

}
