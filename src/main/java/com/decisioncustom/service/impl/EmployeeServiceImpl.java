package com.decisioncustom.service.impl;

import com.decisioncustom.domain.*;
import com.decisioncustom.mapper.TEmployeeMapper;
import com.decisioncustom.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service
public class EmployeeServiceImpl
		extends ICrudServiceImpl<TEmployee,Long> implements IEmployeeService {

	@Autowired
	private TEmployeeMapper employeeMapper;

	@Override
	@Transactional
	public void leave(Long id) {
		employeeMapper.leave(id);
	}

	@Override
	@Transactional
	public void delete(Serializable id) {
		// 删除中间 表
		employeeMapper.removeEmployeeRoles(id);
		// 删除自己
		employeeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public TEmployee createSelective(TEmployee resource) {
		employeeMapper.insertSelective(resource);
		List<TEmployeeRole> employeeRoleList= resource.getEmployeeRoles();

		if(employeeRoleList.size()==0){
			return resource;
		}
		employeeMapper.saveEmployeeRoles(employeeRoleList);
		return resource;
	}

	@Override
	public List<TEmployee> getEmployeeByDept(Long id) {
		return employeeMapper.getEmployeeByDept(id);
	}

	@Override
	public TEmployee updateEmployee(TEmployee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
		return employee;
	}

	@Override
	public TEmployee getRoleById(Long id) {
		return employeeMapper.getRoleById(id);
	}


	@Override
	@Transactional(readOnly = false)
	public TEmployee updateSelective(TEmployee resource) {
		/*employeeMapper.updateByPrimaryKeySelective(resource);*/
		employeeMapper.removeEmployeeRoles(resource.getId());
		if(resource.getEmployeeRoles().size()==0){
			return resource;
		}
		employeeMapper.saveEmployeeRoles(resource.getEmployeeRoles());
		return resource;
	}

	@Override
	public TEmployee getEmployeeByUsername(String userName) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployeeByUsername(userName);
	}
}
