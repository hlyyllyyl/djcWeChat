<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<div class="boxed">

      <!--CONTENT CONTAINER-->
        <!--===================================================-->
        <div id="content-container">

            <!--Page Title-->
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <div id="page-title">
                <h1 class="page-header text-overflow">老师管理</h1>
            </div>
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <!--End page title-->

            <!--Page content-->
            <!--===================================================-->
            <form:form action="listQuery" namespace="/" id="domainForm" method="get">
            <div id="page-content">

                <!-- Basic Data Tables -->
                <!--===================================================-->
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">老师列表</h3>
                    </div>
                    <div class="panel-body">
                        <div id="demo-dt-basic_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="toolbar">
                                <div id="demo-custom-toolbar2" class="table-toolbar-left">
                                    <button type="button" id="demo-dt-addrow-btn" class="btn btn-primary btn-rounded"><i class="demo-pli-plus"></i>添加</button>
                                </div>
                                <div id="demo-custom-toolbar" class="table-toolbar-left">
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
                                <th class="sorting_asc" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 179px;" aria-sort="ascending" aria-label="Name: activate to sort column descending">老师姓名</th>
                                <th class="sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width:100px;" aria-label="Position: activate to sort column ascending">老师头像</th>
                                <th class="min-tablet sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 128px;" aria-label="Office: activate to sort column ascending">30日盈利率</th>
                                <th class="min-tablet sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Extn.: activate to sort column ascending">整体盈利率</th>
                                <th class="min-desktop sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Start date: activate to sort column ascending">30日成功率</th>
                                <th class="min-desktop sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Start date: activate to sort column ascending">整体成功率</th>
                                <th class="min-desktop sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Start date: activate to sort column ascending">操作</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${teachersList}" var="item">
                            <tr>
                                <td class="center">
                                    <div>
                                        <input class="magic-checkbox" id="${item.userId}" name="chckBox" value="${item.userId}" type="checkbox">
                                        <label for="${item.userId}"></label>
                                    </div>
                                </td>
                                <td>${item.userName}</td>
                                <td><img src="${item.headimg}"></td>
                                <td>${item.latestList.monthRate}%</td>
                                <td>${item.latestList.overallRate}%</td>
                                <td>${item.latestList.monthSuccessRate}%</td>
                                <td>${item.latestList.overallSuccessRate}%</td>
                                <td>
                                    <input type="hidden" name="userId"  value="${item.userId}"/>
                                    <button type="button"  onClick="updateDomain('/user/teacher_edit',${item.userId})" class="btn btn-purple btn-rounded">修改</button>
                                    <button class="btn btn-dark btn-rounded">删除</button>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                                </div>
                                </div>
                            </div>
                                <%--引入 分页栏 --%>
                            <%@ include file="/WEB-INF/views/common/page.jsp"%>
                        </div>
                    </div>
                </div>
                <!--===================================================-->
                <!-- End Striped Table -->
            </div>
            </form:form>
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
            $("#modelInfo .modal-body").load("/user/teacher_edit");
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