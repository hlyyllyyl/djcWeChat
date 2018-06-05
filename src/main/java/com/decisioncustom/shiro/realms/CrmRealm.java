package com.decisioncustom.shiro.realms;

import com.decisioncustom.domain.Permission;
import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.service.ICustomerService;
import com.decisioncustom.service.PermissionService;
import com.decisioncustom.utils.MD5Until;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class CrmRealm extends AuthorizingRealm{
	@Autowired
	private ICustomerService customerService;
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//将其强行转化为登录对象
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		//获得用户名
		String username = (String) upt.getPrincipal();
		//查询出来的当前的用户对象
		TCustomer user = customerService.loginByCustomerName(username);
		if(user==null){
			//用户名不存在,抛出用户名存在的异常
			throw new UnknownAccountException();
		}
		if(user.getState() == -1){
			throw new LockedAccountException("员工已经离职");
		}
		
		//密码，后天根据前台的数据查询出来的
		String hashedCredentials = user.getPassword();
		//盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(MD5Until.SALT);
		String realmName = getName();
		return new SimpleAuthenticationInfo(user, hashedCredentials,credentialsSalt,realmName);
	}
	
	
	//没有建立数据库，使用main方法计算加密的密码值
	public static void main(String[] args) {
		String algorithmName = "MD5";//加密算法
		Object source = "123";//加密的内容
		int hashIterations = 1000;//重复加密1000次
		Object salt = ByteSource.Util.bytes("daJueCe");//盐值
		SimpleHash simpleHash = new SimpleHash(algorithmName, source ,salt, hashIterations );
		System.out.println(simpleHash.toString());
	}
	
	@Autowired
	private PermissionService permissionService;
	//权限验证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户名
		TEmployee employee = (TEmployee)principals.getPrimaryPrincipal();
		
		
		System.out.println("进入登录用户的权限验证。。。。。。。。。。。。。。。。。。。。。。");
		
		/**
		 * 通过employee Id  动态的获取权限， 但会给框架，框架进行验证
		 * 
		 */
		
		
		Long loginId =  employee.getId();
		
		List<String> permissionString = new ArrayList<>();
		
		List<Permission> permissions = permissionService.getPermissionByLoginId(loginId);
		for (Permission permission2 : permissions) {
			if(permission2!=null){
				permissionString.add(permission2.getSn());
			}
		}
		
		System.out.println(permissionString);

		//把用户权限返回给框架
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		
		
		
		info.addStringPermissions(permissionString);
		
		
		return info;
	}
	
	
	
	
	
	
	
}
