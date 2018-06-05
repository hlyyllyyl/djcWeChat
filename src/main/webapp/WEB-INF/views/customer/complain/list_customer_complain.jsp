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
    <style>
        .bootstrap-select:not([class*="col-"]):not([class*="form-control"]):not(.input-group-btn) {
            width: 80px;
        }
        .bootstrap-select>.dropdown-toggle {
            width: 80px;
            padding-right: 25px;
            z-index: 1;
            height: 28px;
            margin-top: 10px;
        }
    </style>
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
                        <h1 class="page-header text-overflow">客户投诉管理</h1>
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
                                    <h3 class="panel-title">客户投诉情况列表</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="toolbar">
                                        <div id="demo-custom-toolbar2" class="table-toolbar-left">
                                            <a type="button" id="addComplain" class="demo-icon">
                                                <i class="fa fa-plus-square"></i>
                                                <span>添加</span>
                                            </a>
                                            <a type="button" id="delete" class="demo-icon">
                                                <i class="fa fa-minus-square"></i>
                                                <span>删除</span>
                                            </a>
                                        </div>
                                        <div class="table-toolbar-right">
                                            <span>客户姓名:</span>
                                            <sf:input path="realName" id="realName" style="width: 80px"/>
                                            <span>客服老师:</span>
                                            <sf:input path="serviceManName" id="serviceManName" style="width: 80px"/>
                                            <span>投诉类型：</span>
                                            <sf:select class="selectpicker show-tick "
                                                       items="${complainTypeList}" itemLabel="name"
                                                       id="demo-cs-complainTypeList" name="complainType"  itemValue="id" path="complainTypeId">
                                            </sf:select>
                                            <span>所属公司：</span>
                                            <sf:select class="selectpicker show-tick "
                                                       items="${companyList}" itemLabel="name"
                                                       id="demo-cs-companyList" name="company"  itemValue="id" path="companyId">
                                            </sf:select>
                                            <span>投诉事由：</span>
                                            <sf:select class="selectpicker show-tick "  items="${complainReasonList}" id="demo-cs-complainReasonList"
                                                       style="width: 80px" itemLabel="name" itemValue="id" path="complainReasonId">
                                            </sf:select>
                                            <span>处理结果：</span>
                                            <sf:select class="selectpicker show-tick "
                                                       items="${processingResultsList}" itemLabel="name" multiple="false"
                                                       id="demo-cs-processingResultsList" name="processingResults"  itemValue="id" path="processingResultsId">
                                            </sf:select>
                                            <span>投诉来源：</span>
                                            <sf:select class="selectpicker show-tick "
                                                       items="${complainSourceList}" itemLabel="name" multiple="false"
                                                       id="demo-cs-complainSourceList" name="complainSource"  itemValue="id" path="complainSourceId">
                                            </sf:select>
                                        </div>
                                        <div>
                                            <div class="table-toolbar-right">
                                                <a type="submit"  id="query" class="demo-icon" >
                                                    <i class="fa fa-search"></i>
                                                    <span>提交</span>
                                                </a>
                                                <span></span>
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
                                                <table id="myTable" class="table table-hover table-striped table-bordered"  cellspacing="0" width="100%">
                                                    <thead style="word-break:  keep-all;">
                                                    <tr role="row">
                                                        <th class="center">
                                                            <div>
                                                                <input class="magic-checkbox"  id="ckb" onClick="seltAll()" type="checkbox">
                                                                <label for="ckb"></label>
                                                            </div>
                                                        </th>
                                                        <th  rowspan="1" colspan="1" >接诉时间</th>
                                                        <th  rowspan="1" colspan="1" >处理时间</th>
                                                        <th  rowspan="1" colspan="1" >客户姓名</th>
                                                        <th  rowspan="1" colspan="1" >缴费金额</th>
                                                        <th  rowspan="1" colspan="1" >投诉类型</th>
                                                        <th  rowspan="1" colspan="1" >所属公司</th>
                                                        <th  rowspan="1" colspan="1" >客服老师</th>
                                                        <th  rowspan="1" colspan="1" >业务人员</th>
                                                        <th  rowspan="1" colspan="1" >服务开始时间</th>
                                                        <th  rowspan="1" colspan="1" >服务结束时间</th>
                                                        <th  rowspan="1" colspan="1" >投诉事由</th>
                                                            <%--<th  rowspan="1" colspan="1" >投诉咨询事由</th>--%>
                                                        <th  rowspan="1" colspan="1" >移交部门及人员</th>
                                                            <%--<th  rowspan="1" colspan="1" >处理跟踪进程</th>--%>
                                                        <th  rowspan="1" colspan="1" >处理结果</th>
                                                            <%-- <th  rowspan="1" colspan="1" >备注</th>--%>
                                                        <th  rowspan="1" colspan="1" >投诉来源</th>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${customerComplainList}" var="item">
                                                        <tr  id="${item.id}">
                                                            <td class="center">
                                                                <div>
                                                                    <input class="magic-checkbox" id="${item.id}"
                                                                           name="chckBox" value="${item.id}" type="checkbox">
                                                                    <label for="${item.id}"></label>
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/>
                                                            </td>
                                                            <td>
                                                                <fmt:formatDate value="${item.handleTime}" pattern="yyyy-MM-dd"/>
                                                            </td>
                                                            <td>${item.customer.realName}</td>
                                                            <td>${item.customer.payment}</td>
                                                            <td>${item.complainType.name}</td>
                                                            <td>${item.customer.customerCompany.name}</td>
                                                            <td>${item.customer.serviceMan.realName}</td>
                                                            <td>
                                                                <c:forEach items="${item.saleMans}" var="items">
                                                                    ${items.realName}.
                                                                </c:forEach>
                                                            </td>
                                                            <td>
                                                                <fmt:formatDate value="${item.customer.turnOnTime}" pattern="yyyy-MM-dd"/>
                                                            </td>
                                                            <td>
                                                                <fmt:formatDate value="${item.customer.endTime}" pattern="yyyy-MM-dd"/>
                                                            </td>
                                                            <td>${item.complainReason.name}</td>
                                                                <%--<td>${item.complainReasonDetail.complainReasonDetail}</td>--%>
                                                            <td>${item.transfer.transferCompany.name}/${item.transfer.realName}</td>
                                                                <%--<td>${item.trackingProcess}</td>--%>
                                                            <td>${item.processingResults.name}</td>
                                                                <%-- <td>${item.remarks}</td>--%>
                                                            <td>${item.complainSource.name}</td>
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
                            <!--===================================================-->
                            <!-- End Striped Table -->
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 这里是一个模态框 -->
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
            goUrl('/complain/list'+'?'+$('#domainForm').serialize());
        });
        $("#empty").click(function () {
            $("#realName").val("");
            $("#serviceManName").val("");
            $("#demo-cs-companyList").val("");
            $("#demo-cs-complainTypeList").val("");
            $("#demo-cs-complainReasonList").val("");
            $("#demo-cs-processingResultsList").val("");
            $("#demo-cs-complainSourceList").val("");
            goUrl("/complain/list?" + $('#domainForm').serialize())
        });
        /*select*/
        $('#demo-cs-complainTypeList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#demo-cs-complainTypeList').selectpicker('val', '${command.complainTypeId}');

        $('#demo-cs-companyList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#demo-cs-companyList').selectpicker('val', '${command.companyId}');

        $('#demo-cs-complainReasonList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#demo-cs-complainReasonList').selectpicker('val', '${command.complainReasonId}');

        $('#demo-cs-processingResultsList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#demo-cs-processingResultsList').selectpicker('val', '${command.processingResultsId}');

        $('#demo-cs-complainSourceList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#demo-cs-complainSourceList').selectpicker('val', '${command.complainSourceId}');


        $('#delete').click( function () {
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
                    url:'/complain/del',
                    data:JSON.stringify(booksid),
                    type:'post',
                    success:function(result){
                        if(result.success){
                            alert("删除成功");
                            goUrl("/complain/list");
                        }else{
                            alert("删除失败");
                        }
                    }
                });
            }})

        var timer = null
        $("#myTable tr td").dblclick(function() {
            clearTimeout(timer);
            var id = $(this).parent('tr').attr('id');
            $("#modelInfo").modal();
            $("#modelInfo .modal-body").load("/complain/edit?id="+id);
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

        $('#addComplain').click( function () {
            $("#modelInfo .modal-body").load("/complain/edit");
            var dialog = $("#modelInfo").modal();
            dialog.on("shown.bs.modal",function() {
                $(this).draggable();
                $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
            })
        });

        $("form :input").blur(function(){
            //失去焦点处理函数
            var $parent = $(this).parent();
            $parent.find(".msg").remove(); //删除以前的提醒元素（find()：查找匹配元素集中元素的所有匹配元素）
            //验证姓名
            if($(this).is("#presentPrice")){
                var nameVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
                var regName = /[~#^$@%&!*()<>:;'"{}【】  ]/;
                if(nameVal == "" || nameVal.length < 6 || regName.test(nameVal)){
                    var errorMsg = " 股票名称非空，长度6位以上！";
                    //class='msg onError' 中间的空格是层叠样式的格式
                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
                }
                else{
                    var okMsg=" 输入正确";
                    $parent.find(".high").remove();
                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
                }
            }
            //验证姓名
            if($(this).is("#costPrice")){
                var nameVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
                var regName = /[~#^$@%&!*()<>:;'"{}【】  ]/;
                if(nameVal == "" || nameVal.length < 2 || regName.test(nameVal)){
                    var errorMsg = " 股票价格非空！";
                    //class='msg onError' 中间的空格是层叠样式的格式
                    alert(errorMsg);
                }
                else{
                    var okMsg=" 输入正确";
                    $parent.find(".high").remove();
                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
                }
            }
        }).keyup(function(){
            //triggerHandler 防止事件执行完后，浏览器自动为标签获得焦点
            $(this).triggerHandler("blur");
        }).focus(function(){
            $(this).triggerHandler("blur");
        });
    });
</script>
</html>