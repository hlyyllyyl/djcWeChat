package com.decisioncustom.service;


import com.decisioncustom.domain.TEmployee;

import java.util.List;

public interface IEmployeeService extends ICrudService<TEmployee,Long>{
	/**
	 * 
	 * 员工离职
	 */
	void leave(Long id);


	TEmployee getEmployeeByUsername(String username);

	List<TEmployee> getEmployeeByDept(Long id);

	/*修改员工基本信息*/
	TEmployee updateEmployee(TEmployee employee);

	//根据用户Id查询用户角色
	TEmployee getRoleById(Long id);
}
