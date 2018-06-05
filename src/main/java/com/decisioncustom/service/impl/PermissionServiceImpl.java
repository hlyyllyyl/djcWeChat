package com.decisioncustom.service.impl;

import com.decisioncustom.domain.Permission;
import com.decisioncustom.mapper.PermissionMapper;
import com.decisioncustom.service.PermissionService;
import com.decisioncustom.utils.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> getPermissionByLoginId(Long loginId) {

		return permissionMapper.getPermissionByLoginId(loginId);
	}

	@Override
	@Transactional
	public void loadAllpermission() throws Exception {
		Permission p = new Permission();
		String sn = new String();
		Set<String> set = new HashSet<>();
		List<Permission> all = permissionMapper.getAll();

		for (Permission permission : all) {
			set.add(permission.getSn());
		}

		List<String> list = ClassUtil.getAnnoWithPermissions("com.decisioncustom.web.controller");

		for (String url : list) {
			if (url.startsWith("/")) {
				url = url.replaceFirst("/", "");
			}
			sn = url.replace("/", ":");
			if (set.add(sn)) {
				System.out.println(sn);
				p.setResource(url);
				p.setSn(sn);
				System.out.println(p);
				permissionMapper.save(p);
			}
		}

	}
}
