package com.decisioncustom.web.controller.jiepan;

import com.decisioncustom.domain.MyAnno;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.domain.TJiePan;
import com.decisioncustom.query.JiePanQuery;
import com.decisioncustom.service.IJiePanService;
import com.decisioncustom.utils.AjaxResult;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("/jie_pan")
public class JiePanController {

	@Autowired
	private IJiePanService jiePanService;

	@RequestMapping("/list")
	@MyAnno(url="/jie_pan/list")
	public String toIndex(@RequestParam(required=true,defaultValue="1") Integer page,JiePanQuery jiePanQuery,
						  HttpServletRequest request, Model model) {
		PageHelper.startPage(page, 10);
		List<TJiePan> jiePanList = jiePanService.selectByQuery(jiePanQuery);
		System.out.println(jiePanList);
	/*	System.out.print(permissionList);*/
		PageInfo<TJiePan> p= new PageInfo<>(jiePanList);
		request.setAttribute("page", p);
		request.setAttribute("command", jiePanQuery);
		request.setAttribute("APP_PATH", "/jie_pan/list");
		request.setAttribute("jiePanList",jiePanList);
		return "jiepan/list_jie_pan";
	}
	@RequestMapping("/edit")
	public String list(Long id,HttpServletRequest request, Model model) {
		boolean isNew = true;
		if(id!=null){
			TJiePan jiePan = jiePanService.findOne(id);
			model.addAttribute("jiePan",jiePan);
			return "jiepan/edit_jie_pan";
		}
		TJiePan newTJiePan= new TJiePan();
		model.addAttribute("isNew",isNew);
		model.addAttribute("jiePan",newTJiePan);
		return "jiepan/edit_jie_pan";
	}

	/*批量置顶文章*/
	@RequestMapping("/select_top")
	@ResponseBody
	public AjaxResult selectTopBooks(HttpServletRequest request, Model model) {
		AjaxResult ajaxResult = new AjaxResult();
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
						TJiePan jiePan= jiePanService.findOne(Long.valueOf(id));
						int top = jiePan.getTop();
						if (top==0){
							jiePan.setTop(1);
							ajaxResult.setMessage("置顶成功");
						}else if(top==1){
							jiePan.setTop(0);
							ajaxResult.setMessage("取消置顶成功");
						}
						jiePanService.updateSelective(jiePan);
					}
				} catch (Exception e) {
					e.printStackTrace();
					return new AjaxResult("操作失败："+e.getMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  ajaxResult;
	}

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
						jiePanService.delete(Long.valueOf(id));
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

	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult totalSave(TJiePan jiePan,HttpServletRequest request, Model model) {
		   String id = request.getParameter("id");
		//获取当前的subject,就是当前的用户
		Subject currenUser = SecurityUtils.getSubject();
		//获取当前用户的信息
		TEmployee user = (TEmployee) currenUser.getPrincipal();
		Long teacherId= user.getId();
		jiePan.setTeacherId(teacherId);
		if(id!=null && !id.equals("")){
			jiePanService.updateSelective(jiePan);
		}else {
			jiePanService.createSelective(jiePan);
		}
			return new AjaxResult();
		}
}
