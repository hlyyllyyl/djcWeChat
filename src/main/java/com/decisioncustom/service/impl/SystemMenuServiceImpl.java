package com.decisioncustom.service.impl;


import com.decisioncustom.domain.SystemMenu;
import com.decisioncustom.mapper.SystemMenuMapper;
import com.decisioncustom.service.ISystemMenuService;
import com.decisioncustom.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMenuServiceImpl extends BaseServiceImpl<SystemMenu> implements ISystemMenuService {
	
	
	@Autowired
	private SystemMenuMapper systemMenuMapper;
	@Override
	public List<SystemMenu> getSystemMenuTree() {
		
		
		//这个时候需要传入参数，参数就是当前用户的id
		Long loginUserId = UserContext.getUser().getId();
		return systemMenuMapper.getMenuTree(loginUserId);
	}

	@Override
	public List<SystemMenu> getParents() {
		return systemMenuMapper.getParents();
	}

	@Override
	public List<SystemMenu> getChildren() {
		return systemMenuMapper.getChildren();
	}
}






