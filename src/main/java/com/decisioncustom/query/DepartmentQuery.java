package com.decisioncustom.query;

public class DepartmentQuery extends BaseQuery{
	//状态的查询
	private Integer state;
	
	
	private Long parentId;
	
	private Long managerId;
	

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "DepartmentQuery [state=" + state + ", parentId=" + parentId + ", managerId=" + managerId + "]";
	}

	
	
}
