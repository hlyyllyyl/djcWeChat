package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TJiePan;
import com.decisioncustom.domain.TOperationLog;
import com.decisioncustom.mapper.TJiePanMapper;
import com.decisioncustom.mapper.TOperationLogMapper;
import com.decisioncustom.query.JiePanQuery;
import com.decisioncustom.query.OperationLogQuery;
import com.decisioncustom.service.IJiePanService;
import com.decisioncustom.service.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiePanServiceImpl
		extends ICrudServiceImpl<TJiePan,Long> implements IJiePanService {

	@Autowired
	private TJiePanMapper jiePanMapper;
	@Override
	public List<TJiePan> selectByQuery(JiePanQuery jiePanQuery) {
		return jiePanMapper.selectByQuery(jiePanQuery);
	}
}
