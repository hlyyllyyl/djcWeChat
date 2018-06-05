package com.decisioncustom.service;


import com.decisioncustom.domain.SystemMenu;

import java.util.List;


public interface ISystemMenuService extends IBaseService<SystemMenu>{
	
	//一个返回菜单树的方法
	List<SystemMenu> getSystemMenuTree();
	/*获取所有父菜单*/
	List<SystemMenu> getParents();
	/*获取所有子菜单*/
	List<SystemMenu> getChildren();
}
