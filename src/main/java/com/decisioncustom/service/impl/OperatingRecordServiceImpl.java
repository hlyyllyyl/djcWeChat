package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TOperatingRecord;
import com.decisioncustom.domain.TOperatingRecordCustomer;
import com.decisioncustom.domain.TOperatingRecordEmployee;
import com.decisioncustom.mapper.TOperatingRecordMapper;
import com.decisioncustom.service.IOperatingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class OperatingRecordServiceImpl
		extends ICrudServiceImpl<TOperatingRecord,Long> implements IOperatingRecordService {

	@Autowired
	private TOperatingRecordMapper operatingRecordMapper;


	@Override
	@Transactional(readOnly = false)
	public TOperatingRecord createSelective(TOperatingRecord resource) {
		operatingRecordMapper.insertSelective(resource);
		List<TOperatingRecordEmployee> operatingRecordEmployeeList= resource.getOperatingRecordEmployee();
		List<TOperatingRecordCustomer> operatingRecordCustomerList= resource.getOperatingRecordCustomer();

		if(operatingRecordCustomerList.size()==0){
			return resource;
		}
		if(operatingRecordEmployeeList.size()==0){
			return resource;
		}
		operatingRecordMapper.saveRecordEmployees(operatingRecordEmployeeList);
		operatingRecordMapper.saveRecordCustomers(operatingRecordCustomerList);
		return resource;
	}
	@Override
	@Transactional(readOnly = false)
	public TOperatingRecord updateSelective(TOperatingRecord resource) {
		operatingRecordMapper.updateByPrimaryKeySelective(resource);
		operatingRecordMapper.removeRecordEmployees(resource.getId());
		operatingRecordMapper.removeRecordCustomers(resource.getId());
		if(resource.getOperatingRecordEmployee().size()==0){
			return resource;
		}
		if(resource.getOperatingRecordCustomer().size()==0){
			return resource;
		}
		operatingRecordMapper.saveRecordEmployees(resource.getOperatingRecordEmployee());
		operatingRecordMapper.saveRecordCustomers(resource.getOperatingRecordCustomer());
		return resource;
	}
	@Override
	@Transactional()
	public void delete(Serializable id) {
		operatingRecordMapper.removeRecordEmployees(id);
		operatingRecordMapper.removeRecordCustomers(id);
		operatingRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TOperatingRecord updateStockPrice(TOperatingRecord record) {
		operatingRecordMapper.updateStockPrice(record);
		return record;
	}
}
