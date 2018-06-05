<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<div class="boxed">

      <!--CONTENT CONTAINER-->
        <!--===================================================-->
        <div id="content-container">

            <!--Page Title-->
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <div id="page-title">
                <h1 class="page-header text-overflow">机构情报管理</h1>
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
                        <h3 class="panel-title">最新研究成果</h3>
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
                                <th class="sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 100px;" aria-label="Position: activate to sort column ascending">图片</th>
                                <th class="min-tablet sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 128px;" aria-label="Office: activate to sort column ascending">标题</th>
                                <th class="min-tablet sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 79px;" aria-label="Extn.: activate to sort column ascending">创建时间</th>
                                <th class="min-desktop sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Start date: activate to sort column ascending">修改时间</th>
                                <th class="min-desktop sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Start date: activate to sort column ascending">是否原创</th>
                                <th class="min-desktop sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Start date: activate to sort column ascending">阅读量</th>
                                <th class="min-desktop sorting" tabindex="0" aria-controls="demo-dt-basic" rowspan="1" colspan="1" style="width: 132px;" aria-label="Start date: activate to sort column ascending">操作</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${researchResultList}" var="item">
                            <tr>
                                <td class="center">
                                    <div>
                                        <input class="magic-checkbox" id="${item.id}" name="chckBox" value="${item.id}" type="checkbox">
                                        <label for="${item.id}"></label>
                                    </div>
                                </td>
                                <td>${item.employee.realname}</td>
                                <td><img src="${item}"></td>
                                <td>${item.title}</td>
                                <td>
                                    <fmt:formatDate value="${item.creationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <c:if test="${item.original==1}">
                                    <td>原创</td>
                                </c:if>
                                <c:if test="${item.original==0}">
                                    <td>非原创</td>
                                </c:if>
                                <td>${item.readingQuantity}</td>
                                <td>
                                    <input type="hidden" name="id" value="${item.textId}" />
                                    <button type="button"  onClick="updateDomain('/text/edit',${item.textId})" class="btn btn-purple btn-rounded">修改</button>
                                    <button type="button" onClick="researchResultDel(${item.textId})" class="btn btn-dark btn-rounded">删除</button>
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
            turnpage("/text/edit");
        });
        $('#demo-dt-delete-btn').click( function () {
            var countsCheckBox = $("input[type='checkbox']:checked");
            var booksid = [];
            for(var i=0;i<countsCheckBox.length;i++){
                //使用[]取得元素是是一个domElement元素，取值需要使用.value，
                //如果使用countsCheckBox.eq(i) 则是一个Obkject元素，就可以使用val()取值
                //alert(countsCheckBox[i].value);
                mysendbook_id = {};
                mysendbook_id['book_id'] = countsCheckBox[i].value;
                booksid[i] = mysendbook_id;
            }
            var confirmdel= confirm('确认要删除吗?');
            if(confirmdel){
                //开始请求删除
                $.ajax({
                    url:'/text/text_select_del',
                    data:JSON.stringify(booksid),
                    type:'post',
                    success:function(result){
                        if(result.success){
                            alert("删除成功");
                                turnpage("/researchResult/list");
                        }else{
                            alert("删除失败");
                        }
                    }
                });
            }})
    });
</script>