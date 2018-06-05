package com.decisioncustom.utils.page;

import java.util.ArrayList;
import java.util.List;

//分页类
public class PageList<T> {

	private int currentPage;//当前页 -> 前台页面传过来
	
	private int pageSize;//每页多少条数据 -> 前台页面传过来
	
	private int totalCount;//总条数 -> 从数据库中查询出来
	
	private int totalPage;//总页数 -> 计算出来的
	
	private List<T> result = new ArrayList<>(); //当前页的数据 -> 从数据库中查询出来
	
	//提供一个公共无参的构造器
	public PageList() {}
	//有数据的时候使用的构造器
	public PageList(int currentPage,int pageSize,int totalCount) {
		//如果当前页小于1，那么我们就纠正它为1，否则还是之前的值
		this.currentPage = currentPage <1?1:currentPage;
		//如果每页条数小于1，那么我们纠正它为10，否则还是之前的值
		this.pageSize = pageSize<1?10:pageSize;
		
		this.totalCount = totalCount;
		//计算总页数
		//this.totalPage = this.totalCount%this.pageSize>0?this.totalCount/this.pageSize+1:this.totalCount/this.pageSize;
		this.totalPage = (int) Math.ceil((double)this.totalCount/this.pageSize);
		
		//如果当前页大于最后一页，就让它等于最后一页
		//这句代码必需放在计算完totalPage之后
		this.currentPage = this.currentPage > this.totalPage?this.totalPage:this.currentPage;
	}

	/**
	 * <li class="prev disabled"><a href="#"><i
				class="icon-double-angle-left"></i></a></li>
		<li class="active"><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li class="next"><a href="#"><i
				class="icon-double-angle-right"></i></a></li>
	 * @return
	 */
	public String getPage(){
		StringBuilder page = new StringBuilder();
		//当前页大于1，代表还可以点上一页，第一页还可以点击
		if(currentPage>1){
			page.append("<li><a href='javascript:goPage(1)'>首页</a></li>");
			page.append("<li><a href='javascript:goPage("+(currentPage-1)+")'>上一页</a></li>");
		}else{
			page.append("<li class='disabled'><a href='#'>首页</a></li>");
			page.append("<li class='disabled'><a href='#'>上一页</a></li>");
		}
		
		//根据PageIndex计算当前我们需要展示的页数
		/**
		 * totalIndexCount:在这页显示多少个页码
		 * currentPage：当前页
		 * totalPage:总页数
		 */
		PageIndex pageIndex = PageIndex.getPageIndex(5, currentPage, totalPage);
		for (int i = pageIndex.getBeginIndex(); i <=pageIndex.getEndIndex() ; i++) {
			//当前页要修改它的样式
			if(i == currentPage){
				page.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{
				page.append("<li><a href='javascript:goPage("+i+")'>"+i+"</a></li>");
			}
		}
		
		//当前页大于或者等于最后一页，下一页与最后一页就不能点击
		if(currentPage>=totalPage){
			page.append("<li class='disabled'><a href='#'>下一页</a></li>");
			page.append("<li class='disabled'><a href='#'>尾页</a></li>");
		}else{
			page.append("<li><a href='javascript:goPage("+(currentPage+1)+")'>下一页</a></li>");
			page.append("<li><a href='javascript:goPage("+totalPage+")'>尾页</a></li>");
		}
		
		return page.toString();
	}
	
	//从每几条数据开始 : 展示给普通用户,从1开始计算
	public int getBegin(){
		return (currentPage-1)*pageSize + 1;
	}
	//计算当前的最后一条数据
	public int getEnd(){
		int end = currentPage*pageSize;
		end = end>totalCount?totalCount:end; //最后一条不能大于总条数
		return end;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "PageList [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", result=" + result.size() + "]";
	}
	
}
