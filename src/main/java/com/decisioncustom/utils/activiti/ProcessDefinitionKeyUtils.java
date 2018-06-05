package com.decisioncustom.utils.activiti;

/**
 * 流程定义key的帮助类
 * @author Administrator
 *
 */
public class ProcessDefinitionKeyUtils {

	/**
	 * 通过业务对象类型获取流程定义key
	 *    类名+Flow
	 * @param businessObjType
	 * @return
	 */
	public static String buildProcessDefinitionKey(Class businessObjType) {
		return businessObjType.getSimpleName()+"Flow";
	}

}
