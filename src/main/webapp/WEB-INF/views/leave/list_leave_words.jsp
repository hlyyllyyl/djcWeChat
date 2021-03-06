<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <link href="/common/css/leave_words.css" rel="stylesheet">
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
                        <h1 class="page-header text-overflow">客户留言管理</h1>
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
                                    <h3 class="panel-title">客户留言列表</h3>
                                </div>
                                <div class="panel-body">
                                    <div id="demo-dt-basic_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                        <div class="toolbar">
                                            <div id="demo-custom-toolbar2" class="table-toolbar-left">
                                                <a type="button" id="demo-dt-delete-btn" class="demo-icon">
                                                    <i class="fa fa-minus-square"></i>
                                                    <span>删除</span>
                                                </a>
                                            </div>
                                            <div class="table-toolbar-right">
                                                <span>客户姓名:</span>
                                                <sf:input path="userName" id="userName" style="width: 80px"/>

                                                <shiro:hasPermission name="adviserDept:total">
                                                    <span>老师姓名:</span>
                                                    <sf:input path="teacherName" id="teacherName" style="width: 80px"/>
                                                </shiro:hasPermission>

                                                <span>留言时间:</span>
                                                <sf:input path="startTime" id="startTime"  class="form_datetime queryText" />
                                                至
                                                <sf:input path="endTime"  id="endTime" class="form_datetime queryText" />
                                            </div>
                                            <div>
                                                <div class="table-toolbar-right">
                                                    <a type="button"  id="query" class="demo-icon" >
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
                                                    <table id="myTable" class="table table-hover table-striped table-bordered" cellspacing="0" width="100%">
                                                        <thead>
                                                        <tr role="row">
                                                            <th class="center">
                                                                <div>
                                                                    <input class="magic-checkbox"  id="ckb" onClick="seltAll()" type="checkbox">
                                                                    <label for="ckb"></label>
                                                                </div>
                                                            </th>
                                                            <th  rowspan="1" colspan="1">老师姓名</th>
                                                            <th  rowspan="1" colspan="1">姓名</th>
                                                            <th  rowspan="1" colspan="1">联系电话</th>
                                                            <th  rowspan="1" colspan="1">留言内容</th>
                                                            <th  rowspan="1" colspan="1">留言日期</th>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${leaveWordsList}" var="item">
                                                            <tr id="${item.id}">
                                                                <td class="center">
                                                                    <div>
                                                                        <input class="magic-checkbox" id="${item.id}"
                                                                               name="chckBox" value="${item.id}" type="checkbox">
                                                                        <label for="${item.id}"></label>
                                                                    </div>
                                                                </td>
                                                                <td>${item.teacher.realName}</td>
                                                                <td>${item.userName}</td>
                                                                <td>${item.phoneNumber}</td>
                                                                <td>${item.leaveText}</td>
                                                                <td>
                                                                    <fmt:formatDate value="${item.leaveDate}" pattern="yyyy-MM-dd"/>
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
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<!-- 这里是第一个模态框 -->
<div class="modal fade" id="modelInfo" data-backdrop="static" data-keyboard="false">
    <div id="modalDialog" class="modal-dialog" style="width: auto">
        <div class="modal-content">
            <div class="modal-body">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script type="text/javascript">

    $(function() {
        $("#empty").click(function () {
            $("#userName").val("");
            $("#teacherName").val("");
            $("#startTime").val("");
            $("#endTime").val("");
            goUrl("/leave_words/list?" + $('#domainForm').serialize())
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
        $("#query").click(function () {
            goUrl("/leave_words/list?" + $('#domainForm').serialize())
        });
        /*select*/
        $('#demo-cs-serviceManList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        var timer = null
       /* $("#myTable tr td").dblclick(function() {
            clearTimeout(timer);
            var id = $(this).parent('tr').attr('id');
            $("#modelInfo").modal();
            $("#modelInfo .modal-body").load("/customer/customer_edit?id="+id);
            $("#modelInfo").on("shown.bs.modal",function() {
                $(this).draggable();
                $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
            })
            $(this).parent('tr').css("background-color","");
        });*/
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
                    url:'/leave_words/del',
                    data:JSON.stringify(booksid),
                    type:'post',
                    success:function(result){
                        if(result.success){
                            alert("删除成功");
                            goUrl("/leave_words/list");
                        }else{
                            alert("删除失败");
                        }
                    }
                });
            }})
    });
</script>
</html>