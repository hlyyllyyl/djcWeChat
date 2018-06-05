package com.decisioncustom.web.controller.common;

import com.decisioncustom.domain.SystemMenu;
import com.decisioncustom.domain.TAdvertising;
import com.decisioncustom.domain.TColumn;
import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.service.IAdvertisingService;
import com.decisioncustom.service.IColumnService;
import com.decisioncustom.service.ICustomerService;
import com.decisioncustom.service.ISystemMenuService;
import com.decisioncustom.utils.APIResult;
import com.decisioncustom.utils.AjaxResult;
import com.decisioncustom.utils.UserContext;
import com.decisioncustom.utils.globalVariable.GlobalVariable;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LoginController {

	@Autowired
	private IColumnService columnService;

	@Autowired
	private ISystemMenuService systemMenuService;

	@Autowired
	private IAdvertisingService advertisingService;

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/v/index")
	@ResponseBody
	public APIResult getImg(HttpServletRequest request) {

		List<TAdvertising> advertising = advertisingService.selectAdByAdType(47L);
		TAdvertising img = new TAdvertising();
		for (TAdvertising A :advertising){
			img = A;
		}
		Map imgPath = new HashMap<>();
		imgPath.put("advertising",img);
		return  APIResult.success().setData(imgPath);
	}

	@RequestMapping("/v/login")
	@ResponseBody
	public APIResult vLogin(String username, String password, HttpServletRequest request){


		//获取当前的subject,就是当前的用户
		Subject currenUser = SecurityUtils.getSubject();
		//判断该用户是不是匿名用户，如果不是匿名用户就进行登陆验证，是就直接放行
		if(!currenUser.isAuthenticated()){
			//没有被认证，进行登录判断
			System.out.println(username);
			System.out.println(password);
			//封装对象
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			//执行登录
			try {
				currenUser.login(token);
			}
			catch (UnknownAccountException e) {
				e.printStackTrace();
				return new APIResult().failure().setMessage("用户名或密码不正确！");
			}
			catch (IncorrectCredentialsException e) {
				e.printStackTrace();
				return new APIResult().failure().setMessage("用户名或密码不正确！");
			}
			catch (LockedAccountException e) {
				e.printStackTrace();
				return new APIResult().failure().setMessage("该员工已经离职！");
			}
			catch (AuthenticationException e) {
				e.printStackTrace();
				return new APIResult().failure().setMessage("登录失败！");
			}
		}

		List<TColumn> columnList = columnService.selectParentColumn();
		String columnName = columnList.get(0).getName();
		Long    columnId = columnService.selectTopColumnByName(columnName).getId();
		String  templateName = columnService.selectTopColumnByName(columnName).getTemplateName();
		Map map = new HashMap<>();
		map.put("columnList",columnList);
		map.put("columnId",columnId);
		map.put("columnName",columnName);
		map.put("templateName",templateName);

		return  APIResult.success().setData(map);
	}


	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {

		List<TAdvertising> advertising = advertisingService.selectAdByAdType(47L);
		for (TAdvertising A :advertising){
			request.setAttribute("advertising",A);
			request.setAttribute("content", GlobalVariable.CONTENTPATH);
		}
		return "main/index";
	}

	/*风险揭示页面*/
	@RequestMapping(value = "/weChat/login")
	public String wxLogin(HttpServletRequest request) {
		TCustomer customer =  (TCustomer)request.getSession().getAttribute("customer");
		if(customer!=null){
			String fromUserName = customer.getFromUserName();
			TCustomer tCustomer = customerService.loginByWeChat(fromUserName);
			if(tCustomer==null){
				return "/common/risk";
			}else {
				return "redirect:/login.jsp";
			}
		}
		return "redirect:/login.jsp";
	}

	@RequestMapping(value = "/informality")
	public String noBuy(HttpServletRequest request) {

		return "common/notColumn";
	}

	@RequestMapping(value = "/logout")
	public String logout() {

		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/login.jsp";
	}

	@RequestMapping("/login")
	@ResponseBody
	public AjaxResult login(String username, String password, HttpServletRequest request){
		List<TColumn> columnList = columnService.selectAllColumn();
		String name = columnList.get(0).getName();
		//获取当前的subject,就是当前的用户
		Subject currenUser = SecurityUtils.getSubject();
		//判断该用户是不是匿名用户，如果不是匿名用户就进行登陆验证，是就直接放行

		/*if(!currenUser.isAuthenticated()){*/
			//没有被认证，进行登录判断
			System.out.println(username);
			System.out.println(password);
			//封装对象
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			//执行登录
			try {
				currenUser.login(token);
			}
			catch (UnknownAccountException e) {
				e.printStackTrace();
				return new AjaxResult("用户名或密码不正确！");
			}
			catch (IncorrectCredentialsException e) {
				e.printStackTrace();
				return new AjaxResult("用户名或密码不正确！");
			}
			catch (LockedAccountException e) {
				e.printStackTrace();
				return new AjaxResult("当前账号已中止！");
			}
			catch (AuthenticationException e) {
				e.printStackTrace();
				return new AjaxResult("登录失败！");
			}

		//获取当前用户的信息
		TCustomer user = (TCustomer) currenUser.getPrincipal();

		Long state = user.getState();
		Date endTime = user.getEndTime();
		if (state == 1) {
			return new AjaxResult(false, "当前账号已暂停！");
		} else if (state == -1) {
			return new AjaxResult(false, "当前账号已中止！");
		} else if (endTime.getTime() < new Date().getTime()) {
			return new AjaxResult(false, "当前账号不在有效期内！");
		}

		TCustomer customer =  (TCustomer)request.getSession().getAttribute("customer");
		if(customer!=null){
			user.setWxHeadImg(customer.getWxHeadImg());
			user.setProvince(customer.getProvince());
			user.setCity(customer.getCity());
			user.setWechatName(customer.getWechatName());
			user.setFromUserName(customer.getFromUserName());
			customerService.updateSelective(user);
		}

		//将信息存在session中
		UserContext.setUser(user);
		currenUser.getSession().setAttribute("contentPath", GlobalVariable.CONTENTPATH);
		return new AjaxResult(true,name);
	}

	@RequestMapping("/loadTree")
	@ResponseBody
	public List<SystemMenu> loadTree(){
		
		/**
		 * 
		 * 登录完成以后，拿到Tree，返回值为List  不需要传递参数
		 * 
		 */
		
		//
		List<SystemMenu> tree = systemMenuService.getSystemMenuTree();
		
		for (SystemMenu systemMenu : tree) {
		/*	System.out.println("----------------------------------");
			System.out.println(tree);
			System.out.println("-------------");*/
			List<SystemMenu> children = systemMenu.getChildren();
			for (SystemMenu systemMenu2 : children) {
				System.out.println(systemMenu2);
			}
		}
		
		return tree;
	}

}