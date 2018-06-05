package com.decisioncustom.service;


import com.decisioncustom.domain.TOperationLog;
import com.decisioncustom.query.OperationLogQuery;

import java.util.List;

public interface IOperationLogService extends ICrudService<TOperationLog,Long>{

    List<TOperationLog> selectByQuery(OperationLogQuery operationLogQuery);
}
