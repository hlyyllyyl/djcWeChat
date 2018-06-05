package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TLeaveWords;
import com.decisioncustom.mapper.TLeaveWordsMapper;
import com.decisioncustom.query.LeaveWordsQuery;
import com.decisioncustom.service.ILeaveWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveWordsServiceImpl
		extends ICrudServiceImpl<TLeaveWords,Long> implements ILeaveWordsService {

	@Autowired
	private TLeaveWordsMapper leaveWordsMapper;
	@Override
	public List<TLeaveWords> getAllLeaveWordsByQuery(LeaveWordsQuery leaveWordsQuery) {
		return leaveWordsMapper.getAllLeaveWordsByQuery(leaveWordsQuery);
	}

	@Override
	public List<TLeaveWords> selectByCustomerId(Long customerId) {
		return leaveWordsMapper.selectByCustomerId(customerId);
	}
}
