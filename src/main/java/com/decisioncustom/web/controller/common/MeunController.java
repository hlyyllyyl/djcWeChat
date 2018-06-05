package com.decisioncustom.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MeunController {
	/* 跳转到部门管理页�?*/
	@RequestMapping("/menu")
	private String index(Model model){
		return "menu/menu";
	}
}
