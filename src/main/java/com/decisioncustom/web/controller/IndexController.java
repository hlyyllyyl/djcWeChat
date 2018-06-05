package com.decisioncustom.web.controller;

import com.decisioncustom.domain.TSystemDictionaryItem;
import com.decisioncustom.service.ISystemDictionaryItemService;
import com.decisioncustom.wexin.SecurityUtil;
import com.decisioncustom.wexin.XmlpullParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

@Controller
@RequestMapping("/wx/index")
public class IndexController {

	@Autowired
	private ISystemDictionaryItemService systemDictionaryItemService;

	/**
	 * 处理微信认证，get提交
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void signature(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("signature..................");
		// 明文认证方式，直接回显token
		// response.getWriter().println("daJueChe");
		
		//使用加密认证方式
		//一 接收四个参数
		// signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = request.getParameter("signature");
		// timestamp 时间戳
		String timestamp = request.getParameter("timestamp");
		// nonce 随机数
		String nonce = request.getParameter("nonce");
		// echostr 随机字符串
		String echostr = request.getParameter("echostr");
		System.out.println("signature:"+signature);
		System.out.println("timestamp:"+timestamp);
		System.out.println("nonce:"+nonce);
		System.out.println("echostr:"+echostr);
		//二 按照官方文档步骤进行加密认证
		// 1）将token、timestamp、nonce三个参数进行字典序排序
		String[] params ={"daJueChe",timestamp,nonce};
		Arrays.sort(params);
		// 2）将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuilder sb = new StringBuilder();
		for (String param : params) {
			sb.append(param);
		}
		String content = sb.toString();
		String sha1Content = SecurityUtil.sha1(content);
		// 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if (signature.equals(sha1Content)) {
			System.out.println("认证成功！");
			response.getWriter().print(echostr);
		}else{
			System.out.println("认证失败！");
			throw new RuntimeException();
		}
	}
	
	/**
	 * 
	 * index.................
		<xml>
		<ToUserName><![CDATA[gh_ae9b8f50b1b3]]></ToUserName> 接收者
		<FromUserName><![CDATA[oxLXms6cL0ECuVST7vQiDZdg4RbU]]></FromUserName> 发送者
		<CreateTime>1503643739</CreateTime> 创建时间
		<MsgType><![CDATA[text]]></MsgType> 消息类型
		<Content><![CDATA[test]]></Content> 消息内容
		<MsgId>6458100684400663655</MsgId>  唯一标示
		</xml>
	 * Post请求用来接收来自微信服务器转发微信用户的请求
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("index.................");
		response.setContentType("text/html; charset=UTF-8");//响应中文乱码解析
		//1 接收并打印用户的请求内容
		/*ServletInputStream inputStream = request.getInputStream();//字节输入流
		InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");//字符转换流
		BufferedReader br = new BufferedReader(isr);//为了一行一行读，需要转换为缓冲流
		String content = null;
		while ((content = br.readLine())!=null) {
			System.out.println(content);
		}*/
		
		//2接收并进行xml解析
		ServletInputStream inputStream = request.getInputStream();//字节输入流
		InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");//字符转换流

		System.out.println("isr====="+isr);
		Map<String, String> result = XmlpullParserUtil.parse(isr);
		System.out.println("result====="+result);
		print(result);

		TSystemDictionaryItem systemDictionaryItem= systemDictionaryItemService.findOne(67L);
		//判断如果是关注消息，回复“成都大决策欢迎您！”的文本消息。
		String msgType = result.get("MsgType");
		String event = result.get("Event");
		//为了让响应消息时间比较准确，获取当前时间来进行设置
		result.put("CreateTime", new Date().getTime()+"");
		if ("event".equals(msgType)&&"subscribe".equals(event)) {
			//关注消息 
			//响应就是设置result的MsgType为text，由weixin.jsp根据类型进行动态响应
			/*result.put("MsgType", "image");
			result.put("MediaId", systemDictionaryItem.getIntro());*/
			result.put("MsgType", "text");
			result.put("Content", systemDictionaryItem.getIntro());

			PrintWriter out = response.getWriter();
			out.print(buildXmlMsg(result));
			out.flush();

		}
		
		//两种获取微信号的不可行方案：
		//方案1： 传递
		/*if ("event".equals(msgType)&&"VIEW".equals(event)) {
			String url = result.get("EventKey")+"?fromUserName="+result.get("FromUserName");
			System.out.println(url);
			request.getRequestDispatcher(url).forward(request, response);
			return null;
		}*/
		//方案2:session共享
		System.out.println(request.getSession());
		request.getSession().setAttribute("fromUserName", result.get("FromUserName"));
		
		
		//3 响应请求
		//3.1 拼接字符串进行响应
		PrintWriter out = response.getWriter();
		if(result.get("Content").equals("大")){
			out.print(buildXmlMsg(result));
			out.flush();
			System.out.println(buildXmlMsg(result));
		}else {
			out.print(serviceXmlMsg(result));
			out.flush();
			System.out.println(serviceXmlMsg(result));
		}

		//3.2 通过跳转jsp页面完成响应，jsp是一个特殊的Servlet，最终jsp的一样一样代码都会使用PrintWriter来进行响应
		
		String view = "weixin";//视图，加上前缀和后缀就形成完成的访问地址
		String modelName = "map";//模型名称，视图里面用到模型名称
		Object modelObject = result;//模型对象，
		/*return new ModelAndView(view, modelName , modelObject);*/


	}
	
  	
	private String buildXmlMsg(Map<String, String> result) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		sb.append("<ToUserName>"+result.get("FromUserName")+"</ToUserName>");//原来的发送者就是接收者
		sb.append("<FromUserName>"+result.get("ToUserName")+"</FromUserName>");
		sb.append("<CreateTime>"+new Date().getTime()+"</CreateTime>");
		String msgType = result.get("MsgType");
		if ("image".equals(msgType)) {
			sb.append("<MsgType><![CDATA[image]]></MsgType>");
			//图片消息
			sb.append("<Image>");
			sb.append("<MediaId>"+result.get("MediaId")+"</MediaId>");
			sb.append("</Image>");
		} else if("voice".equals(msgType)){
			sb.append("<MsgType><![CDATA[voice]]></MsgType>");
			//图片消息
			sb.append("<Voice>");
			sb.append("<MediaId>"+result.get("MediaId")+"</MediaId>");
			sb.append("</Voice>");
		}else{
			//文本消息
			sb.append("<MsgType><![CDATA[text]]></MsgType>");
			sb.append("<Content>"+result.get("Content")+"</Content>");
		}
		sb.append("</xml>");
		return sb.toString();
	}
	private String serviceXmlMsg(Map<String, String> result) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		sb.append("<ToUserName>"+result.get("FromUserName")+"</ToUserName>");//原来的发送者就是接收者
		sb.append("<FromUserName>djccjg</FromUserName>");
		sb.append("<CreateTime>"+new Date().getTime()+"</CreateTime>");
		sb.append("<MsgType><![CDATA[transfer_customer_service]]></MsgType>");
		sb.append("</xml>");
		return sb.toString();
	}
	private void print(Map<String, String> result) {
		// 最常用，最规范的用法
		Set<Entry<String, String>> entrySet = result.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + "--->" + entry.getValue());
		}
	}
}
