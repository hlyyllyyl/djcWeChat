package com.decisioncustom.utils;

import com.decisioncustom.domain.TCustomer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;


public class UserContext {
	private static  final String LOGINUSER ="loginUser";
	
	
	
	
	/**
	 * 将当前用户存到session
	 */
	
	public static void setUser(TCustomer employee){
		
		Subject current = SecurityUtils.getSubject();
		
		current.getSession().setAttribute(LOGINUSER, employee);
	}
	/**
	 * 将当前用户存到session
	 */

	public static void delUser(TCustomer employee){

		Subject current = SecurityUtils.getSubject();
		current.getSession().removeAttribute(LOGINUSER);
	}
	
	/**
	 * 从session中取出用户
	 */
	
	public static TCustomer getUser(){
		
		Subject current = SecurityUtils.getSubject();

		TCustomer employee = (TCustomer) current.getSession().getAttribute(LOGINUSER);
		
		return employee;
	}
	
	
	public static String getUserIp(){
		//拿到resp对象
		HttpServletRequest request = ActionContext.getHttpRequest();
		String ip = "";
			if(request!=null){
					 ip = request.getHeader("X-Forwarded-For");
					if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getHeader("Proxy-Client-IP");
					}
					if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getHeader("WL-Proxy-Client-IP");
					}
					if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getHeader("HTTP_CLIENT_IP");
					}
					if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getHeader("HTTP_X_FORWARDED_FOR");
					}
					if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getRemoteAddr();
					}
			}
		return ip;
	}
	
}






