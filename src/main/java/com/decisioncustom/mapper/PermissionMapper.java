package com.decisioncustom.mapper;


import com.decisioncustom.domain.Permission;

import java.util.List;


public interface PermissionMapper extends BaseMapper<Permission>{

	List<Permission> getPermissionByLoginId(Long loginId);

}
