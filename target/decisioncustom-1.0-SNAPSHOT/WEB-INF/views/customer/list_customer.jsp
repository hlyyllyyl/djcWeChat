<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
<style>
    .bootstrap-select>.dropdown-toggle {
        width: 100%;
        padding-right: 25px;
        z-index: 1;
        height: 30px;
        outline: 0;
        margin-top: -4px;
    }
    .bootstrap-select:not([class*="col-"]):not([class*="form-control"]):not(.input-group-btn) {
        width: 130px;
    }
</style>
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
                        <h1 class="page-header text-overflow">客户管理</h1>
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
                                    <h3 class="panel-title">客户列表</h3>
                                </div>
                                <div class="panel-body">
                                    <div id="demo-dt-basic_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                        <div class="toolbar">
                                            <div id="demo-custom-toolbar2" class="table-toolbar-left">
                                                <a type="button" id="demo-dt-addrow-btn" class="demo-icon">
                                                    <i class="fa fa-plus-square"></i>
                                                    <span>添加</span>
                                                </a>
                                                <a type="button" id="demo-dt-delete-btn" class="demo-icon">
                                                    <i class="fa fa-minus-square"></i>
                                                    <span>删除</span>
                                                </a>
                                                <a type="button"  id="show"  class="demo-icon">
                                                    <i class="fa fa-dot-circle-o"></i>
                                                    <span>查看</span>
                                                </a>
                                            </div>
                                            <div class="table-toolbar-right">
                                                <span>客户姓名:</span>
                                                <sf:input path="realName" id="realName" style="width: 80px"/>
                                                <span>客服:&nbsp</span>
                                                <sf:select class="selectpicker show-tick " data-live-search="true"
                                                           items="${serviceManList}" itemLabel="realName" multiple="true"
                                                           id="demo-cs-serviceManList" name="serviceMan"  itemValue="id" path="servicemanStr">
                                                </sf:select>
                                                <span>到期时间:</span>
                                                <sf:input path="endTime"  id="serviceEndTime" class="form_datetime" style="width: 80px" />
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
                                                            <th  rowspan="1" colspan="1">客户登录名</th>
                                                            <th  rowspan="1" colspan="1">客户姓名</th>
                                                            <th  rowspan="1" colspan="1">身份证号</th>
                                                            <th  rowspan="1" colspan="1">年龄</th>
                                                            <th  rowspan="1" colspan="1">性别</th>
                                                            <th  rowspan="1" colspan="1">电话</th>
                                                            <th  rowspan="1" colspan="1">微信昵称</th>
                                                            <th  rowspan="1" colspan="1">微信号</th>
                                                            <th  rowspan="1" colspan="1">开通日期</th>
                                                            <th  rowspan="1" colspan="1">结束日期</th>
                                                            <th  rowspan="1" colspan="1">注册日期</th>
                                                            <th  rowspan="1" colspan="1">客服</th>
                                                            <th  rowspan="1" colspan="1">录入人</th>
                                                            <th  rowspan="1" colspan="1">状态</th>
                                                            <th  rowspan="1" colspan="1">备注</th>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${customerList}" var="item">
                                                            <tr id="${item.id}">
                                                                <td class="center">
                                                                    <div>
                                                                        <input class="magic-checkbox" id="${item.id}"
                                                                               name="chckBox" value="${item.id}" type="checkbox">
                                                                        <label for="${item.id}"></label>
                                                                    </div>
                                                                </td>
                                                                <td>${item.customerName}</td>
                                                                <td>${item.realName}</td>
                                                                <td>${item.idCard}</td>
                                                                <td>${item.age}</td>
                                                                <td>
                                                                    <c:if test="${item.gender==0}">
                                                                        女
                                                                    </c:if>
                                                                    <c:if test="${item.gender==1}">
                                                                        男
                                                                    </c:if>
                                                                    <c:if test="${item.gender==-1}">
                                                                        未知
                                                                    </c:if>
                                                                </td>
                                                                <td>${item.mobile}</td>
                                                                <td>${item.wechatName}</td>
                                                                <td>${item.wechat}</td>
                                                                <td>
                                                                    <fmt:formatDate value="${item.turnOnTime}" pattern="yyyy-MM-dd"/>
                                                                </td>
                                                                <td>
                                                                    <fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd"/>
                                                                </td>
                                                                <td>
                                                                    <fmt:formatDate value="${item.registerTime}" pattern="yyyy-MM-dd"/>
                                                                </td>
                                                                <td>${item.serviceMan.realName}</td>
                                                                <td>${item.inputMan.realName}</td>
                                                                <td>
                                                                    <c:if test="${item.state==0}">
                                                                        正常
                                                                    </c:if>
                                                                </td>
                                                                <td>${item.remark}</td>
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
<!-- 这里是第二个模态框 -->
<div class="modal fade" id="myModelInfo" data-backdrop="static" data-keyboard="false">
    <div id="dialog" class="modal-dialog" style="width: auto">
        <div class="modal-content">
            <div class="modal-body">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 这里是第三个模态框 -->
<div class="modal fade" id="detailsModelInfo" data-backdrop="static" data-keyboard="false">
    <div id="detailsDialo" class="modal-dialog" style="width: auto">
        <div class="modal-content">
            <div class="modal-body">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<script type="text/javascript">

    $(function() {
        $("#empty").click(function () {
            $("#demo-cs-serviceManList").val("");
            $("#realName").val("");
            $("#serviceEndTime").val("");
            $("#team").val("");
            goUrl("/customer/list?" + $('#domainForm').serialize())
        });
        $("#serviceEndTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
        });
        $("#query").click(function () {
            goUrl("/customer/list?" + $('#domainForm').serialize())
        });
        /*select*/
        $('#demo-cs-serviceManList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        var timer = null
        $("#myTable tr td").dblclick(function() {
            clearTimeout(timer);
            var id = $(this).parent('tr').attr('id');
            $("#modelInfo").modal();
            $("#modelInfo .modal-body").load("/customer/customer_edit?id="+id);
            $("#modelInfo").on("shown.bs.modal",function() {
                $(this).draggable();
                $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
            })
            $(this).parent('tr').css("background-color","");
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
            $("#modelInfo .modal-body").load("/customer/customer_edit");
            var dialog = $("#modelInfo").modal();
            dialog.on("shown.bs.modal",function() {
                $(this).draggable();
                $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
            })
        });

        $('#show').click( function () {
            var countsCheckBox = $("input[type='checkbox']:checked");

            if(countsCheckBox.length-10==0){
                alert("请至少选择一条记录")
            }
            if(countsCheckBox.length-10>1){
                alert("请选择一条记录")
            }
            if(countsCheckBox.length-10==1){

                for(var i=0;i<countsCheckBox.length;i++){
                    //使用[]取得元素是是一个domElement元素，取值需要使用.value，
                    //如果使用countsCheckBox.eq(i) 则是一个Obkject元素，就可以使用val()取值
                    //alert(countsCheckBox[i].value);
                    var bookid= countsCheckBox.eq(i).val()
                    var regName = new RegExp("^[0-9]*$");
                    if(regName.test(bookid)){
                        $("#modelInfo .modal-body").load("/customer/show?id="+bookid);
                        var dialog = $("#modelInfo").modal();
                        dialog.on("shown.bs.modal",function() {
                            $(this).draggable();
                            $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
                        })
                    }
                }
            }
        })
        $('#track').click( function () {
            var countsCheckBox = $("input[type='checkbox']:checked");

            if(countsCheckBox.length-10==0){
                alert("请至少选择一条记录")
            }
            if(countsCheckBox.length-10>1){
                alert("请选择一条记录")
            }
            if(countsCheckBox.length-10==1){

                for(var i=0;i<countsCheckBox.length;i++){
                    //使用[]取得元素是是一个domElement元素，取值需要使用.value，
                    //如果使用countsCheckBox.eq(i) 则是一个Obkject元素，就可以使用val()取值
                    //alert(countsCheckBox[i].value);
                    var bookid= countsCheckBox.eq(i).val()
                    var regName = new RegExp("^[0-9]*$");
                    if(regName.test(bookid)){
                        $("#modelInfo .modal-body").load("/customer/track_list?id="+bookid);

                        var dialog = $("#modelInfo").modal();
                        dialog.on("shown.bs.modal",function() {
                            $(this).draggable();
                            $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
                        })
                    }
                }
            }
        })

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
                    url:'/customer/customer_select_del',
                    data:JSON.stringify(booksid),
                    type:'post',
                    success:function(result){
                        if(result.success){
                            alert("删除成功");
                            goUrl("/customer/list");
                        }else{
                            alert("删除失败");
                        }
                    }
                });
            }})
    });
</script>
</html>