package com.decisioncustom.web.controller.role;

import com.decisioncustom.domain.Permission;
import com.decisioncustom.domain.Role;
import com.decisioncustom.query.RoleQuery;
import com.decisioncustom.service.IRoleService;
import com.decisioncustom.service.PermissionService;
import com.decisioncustom.utils.AjaxResult;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller 
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	@Autowired
	private PermissionService permissionService;

	/* 跳转到角色管理页面*/
	@RequestMapping("/list")
	private String index(@RequestParam(required=true,defaultValue="1") Integer page,RoleQuery roleQuery,
						 HttpServletRequest request, Model model){
		PageHelper.startPage(page, 10);
		List<Role> roleList= roleService.getAll();
	/*	System.out.print(permissionList);*/
		PageInfo<Role> p= new PageInfo<>(roleList);
		request.setAttribute("page", p);
		/*request.setAttribute("command", operationLogQuery);*/
		request.setAttribute("APP_PATH", "/role/list");
		request.setAttribute("roleList",roleList);
		return "role/list_role";
	}
	/* 跳转到角色编辑页面*/
	@RequestMapping("/edit")
	private String roleEdit(Long id, HttpServletRequest request, Model model){
		boolean isNew = true;
		List<Permission> permissionList= permissionService.getAll();
		if(id!=null){
			Role role = roleService.getOne(id);
			/*回显权限*/
			List<Permission> permissions = role.getPermissions();
			StringBuilder permissionIds = new StringBuilder();
			for (Permission c : permissions){
				permissionIds.append(c.getId()+",");
			}
			request.setAttribute("permissionIds",permissionIds);
			model.addAttribute("permissionList",permissionList);
			model.addAttribute("role",role);
			return "role/edit_role";
		}
		Role newRole= new Role();
		model.addAttribute("isNew",isNew);
		model.addAttribute("permissionList",permissionList);
		model.addAttribute("role",newRole);
		return "role/edit_role";
	}

	/*添加或修改数据*/
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Role role){
		String[] permissionStrs = role.getPermissionStrs();
		List<Permission> permissions = new ArrayList<>();
		for (int i = 0; i <permissionStrs.length ; i++) {
			System.out.print(i);
			Permission permission = permissionService.getOne(Long.valueOf(permissionStrs[i]));
			permissions.add(permission);
		}
		role.setPermissions(permissions);
		try {
			if(role.getId()!=null){
				roleService.update(role);
			}else{
				roleService.add(role);
			}
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult("操作失败："+e.getMessage());
		}
	}

	/* 删除数据 */
	@RequestMapping("/select_del")
	@ResponseBody
	public AjaxResult selectdelbooks( HttpServletRequest request, Model model) {
		try {
			ServletInputStream inputStream = request.getInputStream();
			String mybooksid = IOUtils.toString(inputStream);
			JSONArray jsonarr = new JSONArray(mybooksid);
			List<String> book_id = new ArrayList<>();
			for (int i=0;i<jsonarr.length();i++){
				book_id.add(((JSONObject)jsonarr.get(i)).getString("book_id"));
			}
			for (String id:book_id) {
				try {
					if (!id.equals("on")){
						roleService.del(Long.valueOf(id));
					}
				} catch (Exception e) {
					e.printStackTrace();
					return new AjaxResult("操作失败："+e.getMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  new AjaxResult();
	}
}
