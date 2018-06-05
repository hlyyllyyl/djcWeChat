<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-sm-6">
		<div class="dataTables_info" id="demo-dt-basic_info" role="status" aria-live="polite">
			当前第${page.pageNum}页,总共${page.pages}
			页,总 ${page.total} 条记录
		</div>
		<%--<div class="dataTables_length" id="demo-dt-basic_length">
			<label>
				<select name="demo-dt-basic_length" aria-controls="demo-dt-basic" class="form-control input-sm">
					<option value="10">10</option>
					<option value="25">25</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>项
			</label>
		</div>--%>
	</div>
	<div class="col-sm-6">
		<div class="dataTables_paginate paging_simple_numbers" id="demo-dt-basic_paginate">
			<ul class="pagination">
				<li><a href="javascript:;" onclick="goUrl('?page=1'+'&'+$('#domainForm').serialize())">首页</a></li>
				<!-- 上一页 -->
				<c:if test="${page.hasPreviousPage }">
					<li><a href="javascript:;" onclick="goUrl('?page=${page.pageNum-1}'+'&'+$('#domainForm').serialize())"
						   aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<!-- 中间的1-10 -->
				<c:forEach items="${page.navigatepageNums }" var="page_Num">
					<c:if test="${page_Num == page.pageNum }">
						<li class="active"><a href="#">${page_Num }</a></li>
					</c:if>
					<c:if test="${page_Num != page.pageNum }">
						<li><a href="javascript:;" onclick="goUrl('?page=${page_Num }'+'&'+$('#domainForm').serialize())">${page_Num }</a></li>
					</c:if>
				</c:forEach>
				<!-- 下一页 -->
				<c:if test="${page.hasNextPage }">
					<li><a href="javascript:;" onclick="goUrl('?page=${page.pageNum+1 }'+'&'+$('#domainForm').serialize())"
						   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<li><a href="javascript:;" onclick="goUrl('?page=${page.pages}'+'&'+$('#domainForm').serialize())">末页</a></li>
			</ul>
		</div>
	</div>
</div>
    
    
    
    
    
    
    