package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TOperationLog;
import com.decisioncustom.mapper.TOperationLogMapper;
import com.decisioncustom.query.OperationLogQuery;
import com.decisioncustom.service.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationLogServiceImpl
		extends ICrudServiceImpl<TOperationLog,Long> implements IOperationLogService {

	@Autowired
	private TOperationLogMapper operationLogMapper;
	@Override
	public List<TOperationLog> selectByQuery(OperationLogQuery operationLogQuery) {
		return operationLogMapper.selectByQuery(operationLogQuery);
	}
}
