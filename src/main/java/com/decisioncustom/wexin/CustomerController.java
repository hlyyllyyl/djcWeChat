/*
package com.decisioncustom.wexin;

import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private static Map<Long,List<TCustomer>> customerSellerMapping = new HashMap<>();
	
	*/
/*static{
		customerSellerMapping
		.put(1L, Arrays.asList(new TCustomer(1L, "c1"),new Customer(2L, "c2")));
		customerSellerMapping
		.put(2L, Arrays.asList(new TCustomer(3L, "c3"),new Customer(4L, "c4")));
	}*//*


	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model model) {
		
		//获取微信号
		//通过微信号查询后台用户
		TEmployee loginUser = (TEmployee) request.getSession().getAttribute("loginUser");
		//通过后台用户id作为营销人员Id查询客户 --模拟营销人员Id和客户之间关系（Map）
		List<TCustomer> list = customerSellerMapping.get(loginUser.getId());
		model.addAttribute("list", list);
		//除了跳转页面，还需要传递数据-客户
		return "customer";
	}
}
*/
