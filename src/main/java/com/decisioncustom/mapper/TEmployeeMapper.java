package com.decisioncustom.mapper;


import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.domain.TEmployeeRole;

import java.io.Serializable;
import java.util.List;


public interface TEmployeeMapper extends CrudMapper<TEmployee>{
		//员工离职
		void leave(Long id);
	
	//通过employee删除中间表关联关系
		void removeEmployeeRoles(Serializable id);
	//保存中间表关联关系
		void saveEmployeeRoles(List<TEmployeeRole> role_Permissions);

		TEmployee getEmployeeByUsername(String username);
 		//根据用户Id查询用户角色
		TEmployee getRoleById(Long id);

		List<TEmployee> getEmployeeByDept(Long id);

		TEmployee employeeIdRecord(Serializable id);

		TEmployee employeeIdComplain(Serializable id);

		TEmployee employeeIdCustomer(Serializable id);
}
