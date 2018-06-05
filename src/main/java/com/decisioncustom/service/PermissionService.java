package com.decisioncustom.service;

import com.decisioncustom.domain.Permission;

import java.util.List;


public interface PermissionService extends IBaseService<Permission>{


	List<Permission> getPermissionByLoginId(Long loginId);


	void loadAllpermission() throws Exception;

}
