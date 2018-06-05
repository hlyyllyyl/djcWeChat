<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <link href="/common/css/service_dept.css" rel="stylesheet">
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
                        <h1 class="page-header text-overflow">操作记录表</h1>
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
                                    <h3 class="panel-title">操作记录表</h3>
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
                                                    <table id="myTable" class="table table-hover table-striped table-bordered" cellspacing="0" width="100%">
                                                        <thead>
                                                        <tr role="row">
                                                            <th class="center">
                                                                <div>
                                                                    <input class="magic-checkbox"  id="ckb" onClick="seltAll()" type="checkbox">
                                                                    <label for="ckb"></label>
                                                                </div>
                                                            </th>
                                                            <th  rowspan="1" colspan="1" >推荐时间</th>
                                                            <th  rowspan="1" colspan="1" >股票代码</th>
                                                            <th  rowspan="1" colspan="1" >股票名称</th>
                                                            <th  rowspan="1" colspan="1" >推荐买价(元)</th>
                                                            <th  rowspan="1" colspan="1" >推荐仓位(%)</th>
                                                            <th  rowspan="1" colspan="1" >推荐止盈(%)</th>
                                                            <th  rowspan="1" colspan="1" >推荐止损(%)</th>
                                                            <th  rowspan="1" colspan="1" >投顾</th>
                                                            <th  rowspan="1" colspan="1" >最新收盘价(元)</th>
                                                            <th  rowspan="1" colspan="1" >实际买入时间</th>
                                                            <th  rowspan="1" colspan="1" >实际买价(元)</th>
                                                            <th  rowspan="1" colspan="1" >实际卖出时间</th>
                                                            <th  rowspan="1" colspan="1" >实际卖价(元)</th>
                                                            <th  rowspan="1" colspan="1" >实际仓位(%)</th>
                                                            <th  rowspan="1" colspan="1" >风险提示</th>
                                                            <th  rowspan="1" colspan="1" >客户出仓实际盈亏比例(%)</th>
                                                            <th  rowspan="1" colspan="1" >客户未出仓账面盈亏比例(%)</th>
                                                            <th  rowspan="1" colspan="1" >客服</th>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${operatingRecords}" var="item">
                                                            <tr id="${item.id}">
                                                                <td class="center">
                                                                    <div>
                                                                        <input class="magic-checkbox" id="${item.id}" name="chckBox" value="${item.id}" type="checkbox">
                                                                        <label for="${item.id}"></label>
                                                                    </div>
                                                                </td>
                                                                <td>
                                                                    <fmt:formatDate value="${item.recommendDate}" pattern="yyyy-MM-dd"/>
                                                                </td>
                                                                <td>${item.stockCode}</td>
                                                                <td>${item.stockName}</td>
                                                                <td>${item.recommendBidPrice}</td>
                                                                <td>${item.recommendPosition}</td>
                                                                <td>${item.recommendStopProfit}</td>
                                                                <td>${item.recommendStopLoss}</td>
                                                                <td>${item.adviser.realName}</td>
                                                                <td>${item.latestClosingPrice}</td>
                                                                <td>
                                                                    <fmt:formatDate value="${item.actualBuyingTime}" pattern="yyyy-MM-dd"/>
                                                                </td>
                                                                <td>${item.actualBidPrice}</td>
                                                                <td>
                                                                    <fmt:formatDate value="${item.actualSellingTime}" pattern="yyyy-MM-dd"/>
                                                                </td>
                                                                <td>${item.actualSellingPrice}</td>
                                                                <td>${item.actualPosition}</td>
                                                                <td>${item.riskWarning}</td>
                                                                <td>${item.outOfPosition}</td>
                                                                <td>${item.notOutOfPosition}%</td>
                                                                <td>
                                                                    <c:forEach items="${item.employees}" var="items">
                                                                        ${items.realName}
                                                                    </c:forEach>
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
        </div>
    </div>
</div>
</body>
<!-- 这里是一个模态框 -->
<div class="modal fade" id="modelInfo" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: auto">
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
        var timer = null
        $("#myTable tr td").dblclick(function() {
            clearTimeout(timer);
            var id = $(this).parent('tr').attr('id');
            $("#modelInfo").modal();
            $("#modelInfo .modal-body").load("/operating_record/edit?id="+id);
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
            $("#modelInfo .modal-body").load("/operating_record/edit");
            var dialog = $("#modelInfo").modal();
            dialog.on("shown.bs.modal",function() {
                $(this).draggable();
                $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
            })
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
                    url:'/operating_record/select_del',
                    data:JSON.stringify(booksid),
                    type:'post',
                    success:function(result){
                        if(result.success){
                            alert("删除成功");
                            goUrl("/operating_record/list");
                        }else{
                            alert("删除失败");
                        }
                    }
                });
            }})
    });
</script>
</html>