package com.decisioncustom.web.controller.menu;

import com.decisioncustom.domain.MyAnno;
import com.decisioncustom.domain.SystemMenu;
import com.decisioncustom.service.ISystemMenuService;
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
@RequestMapping("/menu")
public class SystemMenuController {
	@Autowired
	private ISystemMenuService menuService;

	/* 跳转到部门管理页面*/
	@RequestMapping("/list")
	private String index(@RequestParam(required=true,defaultValue="1") Integer page, HttpServletRequest request, Model model){
		PageHelper.startPage(page, 10);
		List<SystemMenu> systemMenuList= menuService.getAll();
	/*	System.out.print(permissionList);*/
		PageInfo<SystemMenu> p= new PageInfo<>(systemMenuList);
		request.setAttribute("page", p);
		/*request.setAttribute("command", operationLogQuery);*/
		request.setAttribute("APP_PATH", "/menu/list");
		request.setAttribute("systemMenuList",systemMenuList);
		return "menu/list_menu";
	}
	/* 跳转到角色编辑页面*/
	@RequestMapping("/edit")
	private String systemMenuEdit(Long id, HttpServletRequest request, Model model){
		boolean isNew = true;
		List<SystemMenu> parentList = menuService.getParents();
		if(id!=null){
			SystemMenu systemMenu = menuService.getOne(id);
			System.out.print(systemMenu);
			Long parentId= systemMenu.getParentId();

			model.addAttribute("parentId",parentId);
			model.addAttribute("parentList",parentList);
			model.addAttribute("systemMenu",systemMenu);
			return "menu/edit_menu";
		}
		SystemMenu newSystemMenu= new SystemMenu();
		model.addAttribute("isNew",isNew);
		model.addAttribute("parentList",parentList);
		model.addAttribute("systemMenu",newSystemMenu);
		return "menu/edit_menu";
	}
	/*添加或修改数据*/
	@RequestMapping("/save")
	@ResponseBody
	@MyAnno(url="/save")
	public AjaxResult save(SystemMenu systemMenu){
		String parentStr = systemMenu.getParentStr();
		if(parentStr!=null && !parentStr.equals("")){
			systemMenu.setParentId(Long.valueOf(parentStr));
		}
		try {
			if(systemMenu.getId()!=null){
				menuService.update(systemMenu);
			}else{
				menuService.add(systemMenu);
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
	@MyAnno(url="/menu/select_del")
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
						menuService.del(Long.valueOf(id));
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
	
	//获得菜单树
	@RequestMapping("/getMenuTree")
	@ResponseBody
	public List<SystemMenu> getMenuTree(){
		List<SystemMenu> list = menuService.getSystemMenuTree();
		return list;
	}
	
}
