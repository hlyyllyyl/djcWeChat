package com.decisioncustom.shiro.realms;

import com.decisioncustom.domain.Permission;
import com.decisioncustom.mapper.PermissionMapper;
import com.decisioncustom.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class FilterChainDefinitionMapFactoryBean {
	/**
	 * 
	 * 
	 * 这里不能直接注入service，
	 * 		在shiro初始化的时候，会使用反射调用方法，（这个时候框架还没有加载完毕），当进入service的时候，会被拦截
	 * 		这个时候，会调用shiro的方法，因为框架还没有加载完毕，就会在xml读取的时候失败，因此错误信息是，bean创建失败
	 * 
	 */
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private PermissionMapper mapper;
	
	/**
	 * 定义需要权限进行访问的路径
	 */
	public Map<String,String> createFilterChainDefinitionMap(){
		//这是一有顺序的map，严格控制顺序
		Map<String,String> map = new LinkedHashMap<>();
		
		/**
		 * <value> 
		 * #这两个资源不需要登录 
		 * /login.jsp = anon
		 * /login = anon
		 * #对需要权限才能访问的资源地址配置拦截，只要不再这儿配置都任务不需要任何权限，直接放行 
		 * /authorized.html =
		 * perms[user:*] 
		 * #其他资源都需登录    
		 *  /** = authc 
		 * </value>
		 */
		//map.put("/login.jsp", "anon");
		/*
        <!-- 登录页面，没有登录就进入的页面 -->
        <property name="loginUrl" value="/login.jsp"/>
        */
		/**
		 * 	为进行登录，就直接进入log.jsp页面
		 */
		
		//登陆放行
		map.put("/login", "anon");
		map.put("/login.jsp", "anon");
		map.put("/index.jsp", "anon");
		//静态资源放行
		map.put("/assets/**", "anon");
		map.put("/common/**", "anon");
		map.put("/fonts/**", "anon");
		map.put("/ueditor/**", "anon");
		map.put("/upload/**", "anon");
		map.put("/MP_verify_KYppsNa4LQHtAAAd.txt", "anon");
		map.put("/css/**", "anon");
		map.put("/fonts/**", "anon");
		map.put("/imgs/**", "anon");
		map.put("/js/**", "anon");
		map.put("/unpackage/**", "anon");
		map.put("/video/**", "anon");
		//配置注销功能
		map.put("/djc/logout", "logout");
		map.put("/article/v/jsp", "anon");
		map.put("/column/main/**", "anon");
		map.put("/column/article/**", "anon");
		map.put("/article/article", "anon");
		map.put("/advertising/article1", "anon");
		map.put("/informality", "anon");
		map.put("/v/**", "anon");
		map.put("/index", "anon");
		map.put("/wx/index", "anon");
		map.put("/djc/**", "anon");
		map.put("/weChat/login", "anon");
		//数据库查询数据
		//List<Permission> list = permissionService.getAll();

		List<Permission> list = mapper.getAll();
		
		for (Permission permission : list) {
			String resource = "/"+permission.getResource();
			String sn = "crmPerms["+permission.getSn()+"]";
			
			System.out.println(resource);
			System.out.println(sn);
			
			map.put(resource, sn);
			
		}

		//登陆后所有资源放行
		map.put("/**", "authc");
		
		return map;
	}
}
