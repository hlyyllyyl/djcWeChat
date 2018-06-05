<%@ page pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-sm-6">
		<div class="dataTables_info" id="demo-dt-basic_info" role="status" aria-live="polite">
			当前第${page.pageNum}页,总共${page.pages}
			页,总 ${page.total} 条记录
		</div>
	</div>
	<div class="col-sm-6">
		<div class="dataTables_paginate paging_simple_numbers" id="demo-dt-basic_paginate">
			<ul class="pagination">
				<li><a href="javascript:;" onclick="turnpage('${APP_PATH }?page=1')">首页</a></li>
				<!-- 上一页 -->
				<c:if test="${page.hasPreviousPage }">
					<li><a href="javascript:;" onclick="turnpage('${APP_PATH }?page=${page.pageNum-1}')"
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
						<li><a href="javascript:;" onclick="turnpage('${APP_PATH}?page=${page_Num }')">${page_Num }</a></li>
					</c:if>
				</c:forEach>
				<!-- 下一页 -->
				<c:if test="${page.hasNextPage }">
					<li><a href="javascript:;" onclick="turnpage('${APP_PATH}?page=${page.pageNum+1 }')"
						   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<li><a href="javascript:;" onclick="turnpage('${APP_PATH}?page=${page.pages}')">末页</a></li>
			</ul>
		</div>
	</div>
</div>
    
    
    
    
    
    
    