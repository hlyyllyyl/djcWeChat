package com.decisioncustom.web.controller.permission;

import com.decisioncustom.domain.Permission;
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
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	/* 跳转到权限管理页面*/
	@RequestMapping("/list")
	private String index(@RequestParam(required=true,defaultValue="1") Integer page, HttpServletRequest request, Model model){
		PageHelper.startPage(page, 10);
		List<Permission> permissionList= permissionService.getAll();
		PageInfo<Permission> p= new PageInfo<>(permissionList);
		request.setAttribute("page", p);
		request.setAttribute("APP_PATH", "/permission/list");
		request.setAttribute("permissionList",permissionList);
		return "permission/list_permission";
	}
	/* 跳转到权限编辑页面*/
	@RequestMapping("/edit")
	private String permissionEdit(Long id, HttpServletRequest request, Model model){
		boolean isNew = true;
		if(id!=null){
			Permission permission = permissionService.getOne(id);
			model.addAttribute("permission",permission);
			return "permission/edit_permission";
		}
		Permission newPermission= new Permission();
		model.addAttribute("isNew",isNew);
		model.addAttribute("permission",newPermission);
		return "permission/edit_permission";
	}

	/*添加或修改数据*/
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Permission permission){
		try {
			if(permission.getId()!=null){
				permissionService.update(permission);
			}else{
				System.out.print("create");
				permissionService.add(permission);
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
						permissionService.del(Long.valueOf(id));
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
	
	
	@RequestMapping("/loadpermission")
	@ResponseBody
	public AjaxResult loadpermission(){
		try {
			permissionService.loadAllpermission();
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult("加载失败："+e.getMessage());
		}
	}

}
