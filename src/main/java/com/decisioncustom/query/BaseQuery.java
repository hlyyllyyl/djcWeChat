package com.decisioncustom.query;
/**
 * 
 * 鍩虹鐨勬煡璇㈠璞★紝灏佽鐨勬槸鍏叡鐨勬煡璇㈡潯浠�
 * 鍏蜂綋鐨刣omian鐨勬煡璇㈡潯浠堕渶瑕佺户鎵夸粬锛屽湪鑷繁杩涜澧炲姞
 * @author Administrator
 *
 */
public class BaseQuery {
	/**
	 * 姣忎釜椤甸潰閮借杩涜鍒嗛〉锛屾墍浠ュ垎椤垫斁鍦ㄥ叕鍏�
	 */
	
	//褰撳墠椤�,榛樿鍊间负绗竴椤�
	private int page = 1;
	//姣忛〉鏄剧ず澶氬皯鏉★紝榛樿涓�10
	private int rows = 10;
	
	//公共的模糊查询
	private String q ;
	private Long  traceUserId;

	private String sort;
	private String order;
	
	
	public Long getTraceUserId() {
		return traceUserId;
	}

	public void setTraceUserId(Long traceUserId) {
		this.traceUserId = traceUserId;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	
	
	
	
	
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	} 
	
	
	/**
	 * 分页的完成，获取分页后的，第一条数据的位置
	 */
	public int getStart(){
		
		return (page-1)*rows;
	}
	
}
