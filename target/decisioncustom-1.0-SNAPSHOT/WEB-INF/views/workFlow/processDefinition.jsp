<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
	<title>Dashboard | Nifty - Admin Template</title>
	<%--引入 css和js --%>
	<%@ include file="/WEB-INF/views/common/common.jsp"%>
	<%--引入 设置栏 --%>
	<%@ include file="/WEB-INF/views/common/set.jsp"%>
</head>
<body>
<div id="container" class="effect aside-float aside-bright mainnav-lg">
	<%--引入头部，侧边菜单栏，脚部--%>
	<%@ include file="/WEB-INF/views/common/public.jsp"%>

	<%--右侧页面数据--%>
	<div class="col-sm-12" id="right-content">
		<div class="boxed">

			<!--CONTENT CONTAINER-->
			<!--===================================================-->
			<div id="content-container">

				<!--Page Title-->
				<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
				<div id="page-title">
					<h1 class="page-header text-overflow">流程定义管理</h1>
				</div>
				<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
				<!--End page title-->

				<!--Page content-->
				<!--===================================================-->
				<sf:form action="listQuery" namespace="/" id="domainForm" method="get">
					<div id="page-content">

						<!-- Basic Data Tables -->
						<!--===================================================-->
						<div class="panel">
							<div class="panel-heading">
								<h3 class="panel-title">流程列表</h3>
							</div>
							<div class="panel-body">
								<div id="demo-dt-basic_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="toolbar">
										<div id="demo-custom-toolbar2" class="table-toolbar-left">
											<button type="button" id="demo-dt-addrow-btn" class="btn btn-primary btn-rounded">
												<i class="demo-pli-plus"></i>添加</button>
											<button type="button" id="demo-dt-delete-btn" class="btn btn-dark btn-rounded">
												<i class="demo-pli-cross"></i> 删除</button>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<div class="table-responsive">
												<table id="demo-dt-delete" class="table table-striped table-bordered" cellspacing="0" width="100%">
													<thead>
													<tr role="row">
														<th class="center">
															<div>
																<input class="magic-checkbox"  id="ckb" onClick="seltAll()" type="checkbox">
																<label for="ckb"></label>
															</div>
														</th>
														<th >ID</th>
														<th >名称</th>
														<th >Key</th>
														<th >版本</th>
														<th >部署ID</th>
														<th >bmpn文件资源名</th>
														<th >bmpn文件资源名</th>
														<th >描述</th>
													</thead>
													<tbody>
													<c:forEach items="${processDefinitions}" var="item">
														<tr>
															<td class="center">
																<div>
																	<input class="magic-checkbox" id="${item.id}" name="chckBox" value="${item.id}" type="checkbox">
																	<label for="${item.id}"></label>
																</div>
															</td>
															<td>${item.id}</td>
															<td>${item.name}</td>
															<td>${item.key}</td>
															<td>${item.version}</td>
															<td>${item.deploymentId}</td>
															<td>${item.resourceName}</td>
															<td>${item.diagramResourceName}</td>
															<td>${item.description}</td>
														</tr>
													</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--===================================================-->
						<!-- End Striped Table -->
					</div>
				</sf:form>
			</div>
		</div>
	</div>
	<!-- 这里是一个模态框 -->
	<div class="modal fade" id="modelInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<%--  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                      <h4 class="modal-title">错误提示</h4>
                  </div>--%>
				<div class="modal-body">
				</div>
				<%-- <div class="modal-footer">
                     <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                 </div>--%>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<script type="text/javascript">
        $(function() {
            $('#demo-dt-addrow-btn').click( function () {
                $("#modelInfo .modal-body").load("/workFlow/edit");
                var dialog = $("#modelInfo").modal();
                /*dialog.on("shown.bs.modal",function(){
                    $(".close").click();
                })*/
            });
            $('#demo-dt-delete tbody').on( 'click', 'tr', function () {
                $(this).toggleClass('selected');
            });
        });
	</script>
</div>
</body>
</html>