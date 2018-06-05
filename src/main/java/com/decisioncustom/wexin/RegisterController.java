package com.decisioncustom.wexin;

import com.decisioncustom.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private IEmployeeService employeeService;

	// 跳转到注册页面
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "register";
	}

	// 处理注册
/*	 @RequestMapping(method=RequestMethod.POST)
	 public ModelAndView register(HttpServletRequest request,Employee employee)
	 {
		 //判断注册用户是否已存在，如果存在，跳转到注册页面，提示“用户已经存在！”
		 Employee employeeByDb = employeeService.findByLogin(employee);
		 if (employeeByDb != null) {
			return new ModelAndView("register", "msg", "用户已经存在！");
		 }else{
			 //不存在，注册并绑定，存Session，跳转主页
			 String fromUserName = (String) request.getSession().getAttribute("fromUserName");
			 employee.setFromUserName(fromUserName);
			 employeeService.save(employee);
			 
			 request.getSession().setAttribute("loginUser", employee);
			 return new ModelAndView("main");
		 }*/
	 }
