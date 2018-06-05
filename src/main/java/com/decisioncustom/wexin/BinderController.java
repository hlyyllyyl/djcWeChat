package com.decisioncustom.wexin;

import com.decisioncustom.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/binder")
public class BinderController {

	@Autowired
	private IEmployeeService employeeService;

	//用来处理微信的“绑定”菜单的get请求--跳转到绑定页面
/*	@RequestMapping(method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
//		System.out.println(request.getParameter("fromUserName")+"jjjjj");
//		System.out.println(request.getSession());
		System.out.println(request.getSession().getAttribute("fromUserName")+"kkkkkkkkkkkkkk");
		String fromUserName = (String) request.getSession().getAttribute("fromUserName");
		//如果已经绑定则跳转到主页
		//已经绑定?通过当前微信号，在数据库表中查询，如果能够查询到说明已经绑定
		TEmployee employee = employeeService.findByBinder(fromUserName);
		if (employee != null) {
			//相当于是微信号所对应的后台用户已经登录，需要把用户放入Session
			request.getSession().setAttribute("loginUser", employee);
			return "main";
		}else{
			//否则跳转到绑定页面
			return "binder";
		}
	}*/
	
	/*//处理绑定
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView binder(HttpServletRequest request,Employee employee) {
		String fromUserName = (String) request.getSession().getAttribute("fromUserName");
		Employee employeeByDb = employeeService.findByLogin(employee);
		//判断是否有该用户，如果没有，跳转到绑定页面，并给出“用户名或密码不正确的提示！”
		if (null == employeeByDb) {
			return new ModelAndView("binder", "msg", "用户名或密码不正确!");
		}else{
			//如果有，完成绑定功能！设置Session并跳转主页面
			employeeByDb.setFromUserName(fromUserName);
			employeeService.update(employeeByDb);
			request.getSession().setAttribute("loginUser", employeeByDb);
			return new ModelAndView("main");
		}
	}*/
}
