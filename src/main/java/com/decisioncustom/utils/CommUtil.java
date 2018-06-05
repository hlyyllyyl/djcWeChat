package com.decisioncustom.utils;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommUtil {

	private static final String PATTERN = "yyyy-MM-dd";

	/**
	 * 把指定的复杂对象属性，按照指定的内容，封装到新的map中
	 * @param source 目标对象
	 * @param ps     需要封装到map中的属性
	 * @return
	 */
	public static Map<String, Object> obj2map(Object source, String[] ps) {
		Map<String, Object> map = new HashMap<>();
		if (source == null)
			return null;
		if (ps == null || ps.length < 1) {
			return null;
		}
		for (String p : ps) {
			PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(
					source.getClass(), p);
			if (sourcePd != null && sourcePd.getReadMethod() != null) {
				try {
					Method readMethod = sourcePd.getReadMethod();
					if (!Modifier.isPublic(readMethod.getDeclaringClass()
							.getModifiers())) {
						readMethod.setAccessible(true);
					}
					//获取到的值,其中就有Date
					Object value = readMethod.invoke(source, new Object[0]);
					if (value instanceof Date) {
						//日期类型
						Date dateValue = (Date) value;
						DateFormat df = new SimpleDateFormat(PATTERN);
						String dateStr = df.format(dateValue);
						map.put(p, dateStr);
					}else{
						map.put(p, value);
					}
				} catch (Exception ex) {
					throw new RuntimeException(
							"Could not copy properties from source to target",
							ex);
				}
			}
		}
		return map;
	}

	
}
