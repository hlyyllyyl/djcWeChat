
package com.decisioncustom.wexin;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * 使用xmlpull解析请求
 * @author Administrator
 *
 */

public class XmlpullParserUtil {


/**
	 * 参数：
	 *   方案1：InputStream
	 *   方案2：Reader 采纳 为了方便把字符串格式xml进行解析测试(StringReader) 传入Reader
	 * 返回值：
	 *   方案1：把所有消息公共属性抽取为BaseMsg父类对象，为每种消息定制自己子类，在子类中完成自有属性封装.TextMsg,ImageMsg...
	 *   方案2：任何消息都通过Map进行封装，不同消息Map的key不一致而已。key就是标签名，value标签内容
	 * @return
	 */

	public static Map<String,String> parse(Reader reader) {
		
		Map<String,String> result = new HashMap<>();
		//alt+shift+z
		try {
			//获取xmlpull解析器
			XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
			//设置解析内容
			parser.setInput(reader);
			//进行解析
			//XmlPullParser.START_DOCUMENT //文档开始
			//XmlPullParser.END_DOCUMENT//文档结束
			//XmlPullParser.START_TAG //标签开始
			//XmlPullParser.END_TAG //标签结束
			int eventType = parser.getEventType();//当前事件类型
			//一直解析直到文档结束
			while (eventType != XmlPullParser.END_DOCUMENT ) {
				
				//解析时机标签开始并且标签名不为xml，解析内容就是下一个文本
				String tagName = parser.getName();
				if (eventType == XmlPullParser.START_TAG && !"xml".equals(tagName)) {
					String tagContent = parser.nextText();
					result.put(tagName, tagContent);
				}
				
				//当前事件接下完毕后，设置下一个解析
				eventType = parser.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		
		String xmlContent = 	
				"<xml>"
				+ "<ToUserName><![CDATA[gh_ae9b8f50b1b3]]></ToUserName>"
				+ "<FromUserName><![CDATA[oxLXms6cL0ECuVST7vQiDZdg4RbU]]></FromUserName>"
				+ "<CreateTime>1503643739</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[test]]></Content>"
				+ "<MsgId>6458100684400663655</MsgId>"
				+ "</xml>";
		StringReader sr = new StringReader(xmlContent);
		Map<String, String> result = parse(sr);
		
		
		//最常用，最规范的用法
		Set<Entry<String, String>> entrySet = result.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey()+"--->"+entry.getValue());
		}
		
	}
	
	
}
