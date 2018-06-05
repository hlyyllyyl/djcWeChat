package com.decisioncustom.web.djcInterface;

import com.decisioncustom.domain.TColumn;
import com.decisioncustom.service.IColumnService;
import com.decisioncustom.service.IEmployeeService;
import com.decisioncustom.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class MController {


	@Autowired
	private IColumnService columnService;

	@Autowired
	private IEmployeeService employeeService;




	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult totalSave(TColumn column,HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		if(id!=null && !id.equals("")){
			columnService.update(column);
		}else {
			columnService.createSelective(column);
		}
		return new AjaxResult();
	}
}
