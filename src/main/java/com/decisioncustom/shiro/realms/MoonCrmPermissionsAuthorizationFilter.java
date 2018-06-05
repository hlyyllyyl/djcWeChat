package com.decisioncustom.shiro.realms;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoonCrmPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

	/**
	 * 覆写权限验证的方法
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {

        Subject subject = getSubject(request, response);
        // If the subject isn't identified, redirect to login URL
        if (subject.getPrincipal() == null) {
            saveRequestAndRedirectToLogin(request, response);
        } else {
            // If subject is known but not authorized, redirect to the unauthorized URL if there is one
            // If no unauthorized URL is specified, just return an unauthorized HTTP status code
        	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        	HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        	String xRequestedWith = httpServletRequest.getHeader("X-Requested-With");
        	
        	/*System.out.println(xRequestedWith);*/

        	if (xRequestedWith != null &&"XMLHttpRequest".equals(xRequestedWith)) {

        		//表示ajax请求 {"success":false,"message":"没有权限"}

        	/*	System.out.println("这是一个ajax请求。。。。。。。。。。。。。。。。。。");*/
        		httpServletResponse.setContentType("text/json; charset=UTF-8");
        		httpServletResponse.getWriter().print("{\"success\":false,\"message\":\"没有权限\"}");
			}
        	else{
        	/*   System.out.println("页面跳转。。。。。。。。。。。。。。。。。。");*/
    		   String unauthorizedUrl = getUnauthorizedUrl();
               //SHIRO-142 - ensure that redirect _or_ error code occurs - both cannot happen due to response commit:
               if (StringUtils.hasText(unauthorizedUrl)) {
                   WebUtils.issueRedirect(request, response, unauthorizedUrl);
               } else {
                   WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
               }
        	}
         
        }
        return false;
	}

}
