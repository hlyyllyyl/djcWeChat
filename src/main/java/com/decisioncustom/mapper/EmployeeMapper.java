package com.decisioncustom.mapper;


import com.decisioncustom.domain.Employee;
import com.decisioncustom.domain.Employee_Role;

import java.io.Serializable;
import java.util.List;


public interface EmployeeMapper extends BaseMapper<Employee>{
		//员工离职
		void leave(Long id);
	
	//通过employee删除中间表关联关系
		void removeEmployee_Roles(Serializable id);
	//保存中间表关联关系
		void saveEmployee_Roles(List<Employee_Role> role_Permissions);
		
		Employee getEmployeeByUsername(String username);

		List<Employee> getEmployeeByDept(Long id);

	    Employee employeeId_Record(Serializable id);

	    Employee employeeId_Complain(Serializable id);

	    Employee employeeId_Customer(Serializable id);
}
