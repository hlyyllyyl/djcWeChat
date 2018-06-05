package com.decisioncustom.wexin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 微信相关的常量
 * 
 * @author Administrator
 *
 */
public class WeixinConstants {
	// 第三方用户唯一凭证
	/*public static final String APPID = "wx993fec2a857607a9";*/
	// 第三方用户唯一凭证密钥，即appsecret
	/*public static final String APPSECRET = "9ab66550fc4d3608ab14ab1051851e0d";*/
	
	//接口调用凭证
	public static String ACCESSTOKEN = "9_jvsimH523DsIvWg1I7l17MmgpYPpOEFCjLUBG9Ve61nXHvxxd8j3VbG7Dy_5uIR1X8AS2dNAcJbqJCJ438cZ9W8MoMjOsneCNi4eetiGP4YIzctcW_zz_heK62Fd26sUSbm_4UYyXuw9cPAbQUZaAEACGL";

	// 获取AccessToken的url地址
	public static final String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	//获取菜单url
	public static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	//删除菜单url
	public static final String DEL_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//添加菜单url
	public static final String ADD_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//获取微信号请求
	public static final String AUTH_GET_OID = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//发起授权请求url地址
	public static final String AUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//拉取用户信息
	public static final String AUTH_INFORMATION = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	private static final Logger logger = LoggerFactory.getLogger(WeixinConstants.class);
	private static Properties props;
	static{
		loadProps();
	}

	synchronized static private void loadProps(){
		logger.info("开始加载properties文件内容.......");
		props = new Properties();
		InputStream in = null;
		try {
                    /*第一种，通过类加载器进行获取properties文件流*/
			in = WeixinConstants.class.getClassLoader().getResourceAsStream("jdbc.properties");
                    /*第二种，通过类进行获取properties文件流*/
			//in = P.class.getResourceAsStream("/jdbc.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			logger.error("jdbc.properties文件未找到");
		} catch (IOException e) {
			logger.error("出现IOException");
		} finally {
			try {
				if(null != in) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("jdbc.properties文件流关闭出现异常");
			}
		}
		logger.info("加载properties文件内容完成...........");
		logger.info("properties文件内容：" + props);
	}

	public static String getProperty(String key){
		if(null == props) {
			loadProps();
		}
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		if(null == props) {
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}
	
}
