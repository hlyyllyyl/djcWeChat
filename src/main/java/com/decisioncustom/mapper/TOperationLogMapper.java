package com.decisioncustom.mapper;


import com.decisioncustom.domain.TOperationLog;
import com.decisioncustom.query.OperationLogQuery;

import java.util.List;


public interface TOperationLogMapper extends CrudMapper<TOperationLog>{

    List<TOperationLog> selectByQuery(OperationLogQuery operationLogQuery);

}
