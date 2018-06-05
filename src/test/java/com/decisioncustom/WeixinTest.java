package com.decisioncustom;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.decisioncustom.wexin.HttpClientUtil;
import com.decisioncustom.wexin.WeixinConstants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class WeixinTest {
	// https请求方式: GET httpclient
	// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET 
	//抽常量存放请求地址，以后官方吧地址改了以后，只需要修改常量就能完成整体修改
	@Test
	public void testAccessToken() {
		try {
			String url = WeixinConstants.GET_ACCESSTOKEN_URL
					.replace("APPID", WeixinConstants.getProperty("APPID"))
					.replace("APPSECRET", WeixinConstants.getProperty("APPSECRET"));
			//创建执行对象
			HttpClient execution = new DefaultHttpClient();
			//创建请求对象
			HttpGet httpGet = new HttpGet(url);
			//通过执行对象传入请求对象执行请求获取响应对象
			HttpResponse response = execution.execute(httpGet);
			//400 500 404 200
			System.out.println("statusCode:"+response.getStatusLine().getStatusCode());
			//通过响应对象获取响应实体，把它转换为json
			HttpEntity responseEntity = response.getEntity();
			System.out.println(EntityUtils.toString(responseEntity));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * statusCode:200
{"errcode":46003,"errmsg":"menu no exist hint: [o_PaNa0872vr25]"}


{
    "menu": {//添加时没有这一层
        "button": [
            {
                "type": "view",
                "name": "é¦é¡µ",
                "url": "http://jd.com",
                "sub_button": []
            },
            {
                "name": "åè½èå",
                "sub_button": [
                    {
                        "type": "view",
                        "name": "ç»å®",
                        "url": "http://weixin20170405.tunnel.qydev.com/binder",
                        "sub_button": []
                    },
                    {
                        "type": "view",
                        "name": "å®¢æ·",
                        "url": "http://weixin20170405.tunnel.qydev.com/customer",
                        "sub_button": []
                    }
                ]
            }
        ]
    }
}
	看到错误码，直接和文档中接口调用返回码进行比较。
	 * @throws Exception
	 */
	@Test
	public void testGetMenu() throws Exception {
		// http请求方式：GET
		// https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN
		String url = WeixinConstants.GET_MENU_URL
				.replace("ACCESS_TOKEN", WeixinConstants.ACCESSTOKEN);
		
		String jsonStr = HttpClientUtil.httpGet(url);
		System.out.println(jsonStr);
		
	}
	
	
	@Test
	public void testDelMenu() throws Exception {
		// http请求方式：GET
		// https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN
		String url = WeixinConstants.DEL_MENU_URL
				.replace("ACCESS_TOKEN", WeixinConstants.ACCESSTOKEN);
		String jsonStr = HttpClientUtil.httpGet(url);
		System.out.println(jsonStr);
		
	}
	
	@Test
	public void testAddMenu() throws Exception {
		// http请求方式：POST（请使用https协议）
		// https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
		String url = WeixinConstants.ADD_MENU_URL
				.replace("ACCESS_TOKEN", WeixinConstants.ACCESSTOKEN);
		
		String paramJsonStr = getMenuJsonStr();
		String jsonStr = HttpClientUtil.httpPost(url, paramJsonStr );
		System.out.println(jsonStr);
	}

	/**
	 * 生成json字符串的方式有两种：
	 *    1）拼接字符串
	 *    2）使用Json框架来转换（采纳）
	 *       我们的菜单是什么样的？
	 *       使用Json框架来转换？
	 *       
	 *       
	 *       {
    "button": [
        {
            "name": "首页",
            "type": "view",
            "url": "http://jd.com"
        },
        {
            "name": "功能菜单",
            "sub_button": [
                {
                    "name": "绑定",
                    "type": "view",
                    "url": "http://weixin20170405.tunnel.qydev.com/binder"
                },
                {
                    "name": "客户",
                    "type": "view",
                    "url": "http://weixin20170405.tunnel.qydev.com/customer"
                }
            ]
        }
    ]
}
	 * @return
	 */
	private static String getMenuJsonStr() {
		//菜单的根对象
		JSONObject root = new JSONObject();
		
		//以button的属性放一级菜单数组
		JSONArray oneLevelMemus = new JSONArray();
		
		// "type":"view",
		// "name":"搜索",
		// "url":"http://www.soso.com/"
		JSONObject index = new JSONObject();
		index.put("type", "view");
		index.put("name", "首页");
		index.put("url", "http://scdjc2018.tunnel.qydev.com/djc/index");
		/*JSONObject function = new JSONObject();
		function.put("type", "view");
		function.put("name", "红马甲");
		function.put("url", "http://wangyadong0920.tunnel.qydev.com");*/

		//功能菜单的一级菜单具有两个二级菜单
		/*JSONArray functionSecondLevelMenus = new JSONArray();
		JSONObject binder = new JSONObject();
		binder.put("type", "view");
		binder.put("name", "红马甲");
		binder.put("url", "http://djccjgvip.djc888.com/toStockPool.htm?82431=");
		JSONObject customer = new JSONObject();
		customer.put("type", "view");
		customer.put("name", "红马甲1");
		customer.put("url", "http://djccjgvip.djc888.com/toStockPool.htm");
		functionSecondLevelMenus.add(binder);
		functionSecondLevelMenus.add(customer);
		
		function.put("sub_button", functionSecondLevelMenus);*/
		
		oneLevelMemus.add(index);
	/*	oneLevelMemus.add(function);*/
		/*oneLevelMemus.add(function1);*/
		root.put("button", oneLevelMemus);
		return root.toJSONString();
	}

	private static String getServiceJsonStr() {
		//菜单的根对象
		JSONObject root = new JSONObject();

		//以button的属性放一级菜单数组
		JSONArray oneLevelMemus = new JSONArray();

		// "type":"view",
		// "name":"搜索",
		// "url":"http://www.soso.com/"
		JSONObject index = new JSONObject();
		index.put("type", "view");
		index.put("name", "首页");
		index.put("url", "http://scdjc2018.tunnel.qydev.com/djc/index");
		/*JSONObject function = new JSONObject();
		function.put("type", "view");
		function.put("name", "红马甲");
		function.put("url", "http://wangyadong0920.tunnel.qydev.com");*/

		//功能菜单的一级菜单具有两个二级菜单
		/*JSONArray functionSecondLevelMenus = new JSONArray();
		JSONObject binder = new JSONObject();
		binder.put("type", "view");
		binder.put("name", "红马甲");
		binder.put("url", "http://djccjgvip.djc888.com/toStockPool.htm?82431=");
		JSONObject customer = new JSONObject();
		customer.put("type", "view");
		customer.put("name", "红马甲1");
		customer.put("url", "http://djccjgvip.djc888.com/toStockPool.htm");
		functionSecondLevelMenus.add(binder);
		functionSecondLevelMenus.add(customer);

		function.put("sub_button", functionSecondLevelMenus);*/

		oneLevelMemus.add(index);
	/*	oneLevelMemus.add(function);*/
		/*oneLevelMemus.add(function1);*/
		root.put("button", oneLevelMemus);
		return root.toJSONString();
	}
	
	public static void main(String[] args) {
		System.out.println(getMenuJsonStr());
	}
	
	
	@Test
	public void testFastJson() throws Exception {
		// 导入jar包
		// 使用：
			// 通过fastJson创建json对象，并且给对象添加属性
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", "zs");
			jsonObj.put("password", "123");
			System.out.println(jsonObj.toJSONString());
			System.out.println("================================");
			// 通过fastJson创建json数组，并且给数组添加对象
			JSONArray jsonArray = new JSONArray();
			jsonArray.add(jsonObj);
			jsonArray.add(jsonObj);
			System.out.println(jsonArray.toJSONString());
	}
	
	

}
