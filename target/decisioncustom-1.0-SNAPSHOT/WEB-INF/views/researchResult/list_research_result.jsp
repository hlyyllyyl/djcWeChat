<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="/common/css/query_text.css" rel="stylesheet">
</head>
<body>
<div id="container" class="effect aside-float aside-bright mainnav-lg">
    <%--引入头部，侧边菜单栏，脚部--%>
    <%@ include file="/WEB-INF/views/common/public.jsp"%>

    <%--右侧页面数据--%>
    <div class="col-sm-12" id="right-content">
        <div class="mainbox">
            <div class="boxed">

                <!--CONTENT CONTAINER-->
                <!--===================================================-->
                <div id="content-container">

                    <!--Page Title-->
                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                    <div id="page-title">
                        <h1 class="page-header text-overflow">最新研究成果管理</h1>
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
                                    <h3 class="panel-title">最新研究成果</h3>
                                </div>
                                <div class="panel-body">
                                    <div id="demo-dt-basic_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                        <div class="toolbar">
                                            <div id="demo-custom-toolbar2" class="table-toolbar-left">
                                                <button type="button" id="demo-dt-addrow-btn" class="btn btn-primary btn-rounded">
                                                    <i class="demo-pli-plus"></i>添加</button>
                                                <button type="button" id="add_top" class="btn btn-primary btn-rounded">
                                                    <i class="demo-pli-plus"></i>置顶</button>
                                                <button type="button" id="demo-dt-delete-btn" class="btn btn-dark btn-rounded">
                                                    <i class="demo-pli-cross"></i> 删除</button>
                                            </div>
                                            <div class="table-toolbar-right">
                                                <span>标题:</span>
                                                <sf:input path="title" class="queryText" id="title"/>
                                                <span>老师姓名:</span>
                                                <sf:input path="teacherName" class="queryText" id="teacherName"/>
                                                <span>是否原创</span>
                                                <sf:select path="original" class="selectQuery" id="original">
                                                    <sf:option value="2">所有</sf:option>
                                                    <sf:option value="1">原创</sf:option>
                                                    <sf:option value="0">非原创</sf:option>
                                                </sf:select>
                                                <span>更新时间</span>
                                                <sf:input path="startTime" id="startTime"  class="form_datetime queryText" />
                                                至
                                                <sf:input path="endTime"  id="endTime" class="form_datetime queryText" />
                                            </div>
                                            <div>
                                                <div class="table-toolbar-right">
                                                    <a type="submit"  id="query" class="demo-icon" >
                                                        <i class="fa fa-search"></i>
                                                        <span>提交</span>
                                                    </a>
                                                    <a  type="button" id="empty"  class="demo-icon">
                                                        <i class="fa fa-square-o"></i>
                                                        <span>清空选择条件</span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="myTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                                        <thead>
                                                        <tr role="row">
                                                            <th class="center">
                                                                <div>
                                                                    <input class="magic-checkbox"  id="ckb" onClick="seltAll()" type="checkbox">
                                                                    <label for="ckb"></label>
                                                                </div>
                                                            </th>
                                                            <th  rowspan="1" colspan="1">老师姓名</th>
                                                            <th  rowspan="1" colspan="1">图片</th>
                                                            <th  rowspan="1" colspan="1">标题</th>
                                                            <th  rowspan="1" colspan="1">创建时间</th>
                                                            <th  rowspan="1" colspan="1">更新时间</th>
                                                            <th  rowspan="1" colspan="1">是否原创</th>
                                                            <th  rowspan="1" colspan="1">是否置顶</th>
                                                            <th  rowspan="1" colspan="1">阅读量</th>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${researchResultList}" var="item">
                                                            <tr id="${item.id}" class="${item.top}">
                                                                <td class="center">
                                                                    <div>
                                                                        <input class="magic-checkbox" id="${item.id}" name="chckBox" value="${item.id}" type="checkbox">
                                                                        <label for="${item.id}"></label>
                                                                    </div>
                                                                </td>
                                                                <td>${item.employee.realName}</td>
                                                                <td><img src="${item.img}"></td>
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
                                                                <c:if test="${item.top==1}">
                                                                    <td>是</td>
                                                                </c:if>
                                                                <c:if test="${item.top==0}">
                                                                    <td>否</td>
                                                                </c:if>
                                                                <td>${item.readingQuantity}</td>
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
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 这里是第一个模态框 -->
<div class="modal fade" id="modelInfo" data-backdrop="static" data-keyboard="false">
    <div id="modalDialog" class="modal-dialog" style="width: auto">
        <div class="modal-content">
            <div class="modal-body">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<script type="text/javascript">
    $(function() {
        $("#query").click(function () {
            goUrl('/researchResult/list'+'?'+$('#domainForm').serialize());
        });
        $("#empty").click(function () {
            $("#title").val("");
            $("#endTime").val("");
            $("#original").val("");
            $("#startTime").val("");
            $("#teacherName").val("");
            goUrl('/researchResult/list');
        });
        $("#startTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var startTime = e.date;
            $("#endTime").datetimepicker("setStartDate", startTime)
        });
        $("#endTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var endTime = e.date;
            $("#startTime").datetimepicker("setEndDate", endTime)
        });
        var timer = null
        $("#myTable tr td").dblclick(function() {
            clearTimeout(timer);
            var id = $(this).parent('tr').attr('id');
            goUrl("/text/edit?id="+id);
        });
        $("#myTable tr td").click(function() {
            clearTimeout(timer);
            timer = setTimeout(function () {　  // 这里采用执行自定义事件的方式,判断是单击还是双击
            }, 300); 　　// 延迟300ms执行单击事件
            var checkbox  = $(this).parent('tr').find("input[type='checkbox']");
            /*checkbox 选中与取消选中 及颜色设置*/
            var s = checkbox.prop('checked');
            checkbox.prop('checked',!s);
            if(s){
                $(this).parent('tr').css("background-color","");
            }else{
                $(this).parent('tr').css("background-color","moccasin");
            }
        });
        $('#demo-dt-addrow-btn').click( function () {
            goUrl("/text/edit");
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
                                goUrl("/researchResult/list");
                        }else{
                            alert("删除失败");
                        }
                    }
                });
            }})
        $('#add_top').click( function () {
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
            var confirmdel= confirm('确认要置顶吗?');
            if(confirmdel){
                //开始请求置顶
                $.ajax({
                    url:'/text/text_select_top',
                    data:JSON.stringify(booksid),
                    type:'post',
                    success:function(result){
                        if(result.success){
                            alert(result.message);
                            goUrl("/researchResult/list");
                        }else{
                            alert("置顶失败");
                        }
                    }
                });
            }})
    });
</script>
</html>