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
    <link href="/common/css/day_customer_complain.css" rel="stylesheet">
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
                        <h1 class="page-header text-overflow">客户投诉日统计</h1>
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
                                    <h3 class="panel-title">客户投诉日统计</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="toolbar">
                                        <div class="table-toolbar-right">
                                            <label>按天</label>
                                            <sf:input path="dayStr" id="dayStr"  class="form_datetime" />
                                            <label>按月</label>
                                            <sf:input path="monthStr" id="monthStr"  class="form_datetime" />
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
                                                        <th  rowspan="1" colspan="1" >公司名称</th>
                                                        <th  rowspan="1" colspan="1" >日期</th>
                                                        <th  rowspan="1" colspan="1" >内诉</th>
                                                        <th  rowspan="1" colspan="1" >外诉</th>
                                                        <th  rowspan="1" colspan="1" >亏损</th>
                                                        <th  rowspan="1" colspan="1" >没人联系</th>
                                                        <th  rowspan="1" colspan="1" >亏损没人联系</th>
                                                        <th  rowspan="1" colspan="1" >服务不满意</th>
                                                        <th  rowspan="1" colspan="1" >未签合同</th>
                                                        <th  rowspan="1" colspan="1" >态度不好</th>
                                                        <th  rowspan="1" colspan="1" >不想做了</th>
                                                        <th  rowspan="1" colspan="1" >不认同产品</th>

                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${customerComplainList}" var="item">
                                                        <tr >
                                                            <td>${item.companyName}</td>
                                                            <td>
                                                                <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/>
                                                            </td>
                                                            <td>${item.outside}</td>
                                                            <td>${item.inside}</td>
                                                            <td>${item.loss}</td>
                                                            <td>${item.notContact}</td>
                                                            <td>${item.lossNotContact}</td>
                                                            <td>${item.serviceDissatisfaction}</td>
                                                            <td>${item.notCompact}</td>
                                                            <td>${item.badAttitude}</td>
                                                            <td>${item.notWant}</td>
                                                            <td>${item.disapprovingProduct}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr id="totalRow">
                                                        <td>合计</td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
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
          var sum = new Array(11).fill(0);
        $('#myTable tbody tr').each(function () {
            $(this).children('td:not(:first-child)').each(function () {
                var index = $(this).index() - 1;
                sum[index] += +$(this).text();
            });
        });
        $('#myTable #totalRow td:not(:first-child)').each(function () {
            var index = $(this).index() - 1;
            if(!isNaN(sum[index])){
                $(this).text(sum[index]);
            }
        });
        $("#query").click(function () {
            goUrl('/complain/day_count'+'?'+$('#domainForm').serialize());
        });
        $("#empty").click(function () {
            $("#dayStr").val("");
            $("#monthStr").val("");
            goUrl("/complain/day_count?" + $('#domainForm').serialize())
        });
        $("#dayStr").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        });
        $("#monthStr").datetimepicker({
            format: 'yyyy-mm',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        });

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