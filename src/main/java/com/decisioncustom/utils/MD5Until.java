package com.decisioncustom.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Until {
	
	//加密的方式
	private static final String ALGORITHMNAME = "MD5";
	
	//加密次数为1000次
	private static final Integer HASHITERATIONS = 1000;
	
	//盐值
	public static final String SALT = "daJueCe";
	
	//获得加密对象的方法
	public static String encrypt(String source){
		
		//通过生成工具生成的盐值
		ByteSource salt = ByteSource.Util.bytes(SALT);
		
		//根据加密的属性，生成对应的加密文件
		SimpleHash simpleHash = new SimpleHash(ALGORITHMNAME, source, salt, HASHITERATIONS);
				
		return simpleHash.toString();
	}
}
