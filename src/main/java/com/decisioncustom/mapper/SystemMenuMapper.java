package com.decisioncustom.mapper;


import com.decisioncustom.domain.SystemMenu;

import java.util.List;


public interface SystemMenuMapper extends BaseMapper<SystemMenu>{
	
	//查询菜单树的方法
	List<SystemMenu> getMenuTree(Long id);

	/*获取所有父菜单*/
	List<SystemMenu> getParents();

	/*获取所有子菜单*/
	List<SystemMenu> getChildren();
}
