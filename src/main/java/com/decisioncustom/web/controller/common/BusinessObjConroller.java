package com.decisioncustom.web.controller.common;

import com.decisioncustom.utils.AjaxResult;

import java.util.Map;


/**
 * 业务对象Controller约束接口
 *     只要是业务对象,那么它的Controller就要是实现这个接口
 * @author Administrator
 *
 */
public interface BusinessObjConroller {
	//===================流程相关方法==========================================
	 /**
	  * 启动业务对象所对应的流程
	 * @param businessObjId
	 * @return
	 */
	AjaxResult startProcess(Long businessObjId);
	
	//一forward方式跳转到formKey所对应的表单结构页面
	 /**
	  * 加载表单结构
	 * @param formKey
	 * @return
	 */
	String loadForm(String formKey);
	
	 /**
	  * 加载表单数据
	 * @param businessObjId
	 * @return
	 */
	Map<String, String> loadFormData(Long businessObjId);
	//===================流程相关方法==========================================
}
