package com.decisioncustom.utils;

/**
 * 只需获取操作是否成功，及失败信息请求的响应对象
 *   一般增删改都返回它
 * @author Administrator
 *
 */
public class AjaxResult {

	//操作是否成功
	private boolean success = true;//默认成功
	//提示信息
	private String message = "操作成功！";//默认提示

	// 错误码（前台可以根据错误码，进行特殊处理）
	private Integer errorCode = -99;

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AjaxResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	/**
	 * 失败时传入信息
	 * @param message
	 */
	public AjaxResult(String message) {
		super();
		this.success = false;//表示失败
		this.message = message; //失败的提示信息
	}
	/**
	 *  错误时
	 * @param message  错误消息
	 * @param errorCode 错误码
	 */
	public AjaxResult(String message, Integer errorCode) {
		super();
		this.success = false;
		this.message = message;
		this.errorCode = errorCode;
	}
	/**
	 * 没有报错的时候用 使用默认属性
	 */
	public AjaxResult() {
		super();
	}
	
	
}
