package com.decisioncustom.service.impl;

import com.decisioncustom.domain.Role;
import com.decisioncustom.service.IRoleService;
import com.decisioncustom.domain.Role_Permission;
import com.decisioncustom.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	
	@Override
	@Transactional
	public void del(Serializable id) {
		//删除中间 表
		roleMapper.removeRole_Permission(id);
		
		//删除自己
		roleMapper.remove(id);
	}


	@Override
	@Transactional
	public void add(Role t) {
		System.out.println(t.toString()+"++++++++++++++++++");
		roleMapper.save(t);
		List<Role_Permission> role_Permissions = t.getRole_Permissions();
		if(role_Permissions.size()==0){
			return;
		}
		roleMapper.saveRole_Permissions(role_Permissions);
	}


	@Override
	@Transactional
	public void update(Role t) {
		roleMapper.update(t);
		roleMapper.removeRole_Permission(t.getId());
		if(t.getRole_Permissions().size()==0){
			return;
		}
		roleMapper.saveRole_Permissions(t.getRole_Permissions());
	}


	@Override
	public List<Role> getRoleByLoginId(Long loginId) {
		return roleMapper.getRoleByLoginId(loginId);
	}
}
