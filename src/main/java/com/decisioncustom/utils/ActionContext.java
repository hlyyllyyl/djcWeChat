package com.decisioncustom.utils;

import javax.servlet.http.HttpServletRequest;

public class ActionContext {
	
	
	private static ThreadLocal<HttpServletRequest> requestContext = new ThreadLocal<HttpServletRequest>();
	
	public static void setHttpRequest(HttpServletRequest request){
		requestContext.set(request);
	}
	
	public static HttpServletRequest getHttpRequest(){
		return requestContext.get();
	}
}
