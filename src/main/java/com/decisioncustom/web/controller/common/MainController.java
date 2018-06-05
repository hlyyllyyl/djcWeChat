package com.decisioncustom.web.controller.common;

import com.decisioncustom.domain.Employee;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.service.IEmployeeService;
import com.decisioncustom.utils.APIResult;
import com.decisioncustom.utils.MD5Until;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller 
@RequestMapping("/main")
public class MainController {

	@Autowired
	private IEmployeeService employeeService;
	
	/* 跳转到角色管理页面*/
	@RequestMapping("/index")
	private String index(Model model){
		return "main/main";
	}
	/* 跳转到密码修改页面*/
	@RequestMapping("/update_password")
	private String update(HttpServletRequest request, Model model){
		//获取当前的subject,就是当前的用户
		Subject currenUser = SecurityUtils.getSubject();
		//获取当前用户的信息
		Employee user = (Employee) currenUser.getPrincipal();
		TEmployee employee= employeeService.getEmployeeByUsername(user.getUsername());
		employee.setPassWord("");
		model.addAttribute("employee",employee);
		return "main/update_password";
	}


	/* 跳转到密码修改页面*/
	@RequestMapping("/save_password")
	@ResponseBody
	private APIResult password(Employee employee, Model model){
		//获取当前的subject,就是当前的用户
		Subject currenUser = SecurityUtils.getSubject();
		//获取当前用户的信息
		TEmployee user = (TEmployee) currenUser.getPrincipal();
		String password1 = user.getPassWord();
		String newPassword = employee.getNewPassword();
		String password = employee.getPassword();
		String soltPassword= MD5Until.encrypt(password);
	/*	System.out.print(employee);
		System.out.print(password1);*/
		if (password1.equals(soltPassword)){
			user.setPassWord(MD5Until.encrypt(newPassword));
			employeeService.updateSelective(user);
			return new APIResult().setMessage("修改成功");
		}else{
			return new APIResult().setMessage("用户名密码不匹配！");
		}
	}
}
