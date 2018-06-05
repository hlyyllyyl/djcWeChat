package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TCustomerColumn;
import com.decisioncustom.mapper.TCustomerColumnMapper;
import com.decisioncustom.pojo.CustomerColumnPojo;
import com.decisioncustom.query.CustomerColumnQuery;
import com.decisioncustom.service.ICustomerColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerColumnServiceImpl
		extends ICrudServiceImpl<TCustomerColumn,Long> implements ICustomerColumnService {

	@Autowired
	private TCustomerColumnMapper customerColumnMapper;

	@Override
	public List<TCustomerColumn> selectAllByQuery(CustomerColumnQuery customerColumnQuery) {
		return customerColumnMapper.selectAllByQuery(customerColumnQuery);
	}

	@Override
	public TCustomerColumn selectAllByCustomer(CustomerColumnPojo customerColumnPojo) {
		return customerColumnMapper.selectAllByCustomer(customerColumnPojo);
	}


}
