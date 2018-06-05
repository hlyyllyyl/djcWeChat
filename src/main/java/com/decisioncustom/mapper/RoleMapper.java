package com.decisioncustom.mapper;

import com.decisioncustom.domain.Role;
import com.decisioncustom.domain.Role_Permission;

import java.io.Serializable;
import java.util.List;


public interface RoleMapper extends BaseMapper<Role>{
//通过roleid删除中间表关联关系
	void removeRole_Permission(Serializable id);
//保存中间表关联关系
	void saveRole_Permissions(List<Role_Permission> role_Permissions);

	Role employeeId_role(Serializable id);

	List<Role> getRoleByLoginId(Long loginId);
}
