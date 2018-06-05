<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="/common/css/customer_complain_edit.css" rel="stylesheet">
<body>
<sf:form id="form" name="form" action="/user/edit" method="post"
         modelAttribute="customerComplain" enctype="multipart/form-data">
<div class="panel">
    <div class="panel-heading">
        <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
        <h3 class="panel-title">
            <c:choose>
                <c:when test="${isNew}">
                    添加客户投诉记录
                </c:when>
                <c:otherwise>
                    查询客户投诉记录
                </c:otherwise>
            </c:choose>

        </h3>
    </div>
    <!-- BASIC FORM ELEMENTS -->
    <!--===================================================-->
    <div class="panel-body">
        <div class="row">

            <div class="ro">
                <div class="inline">
                    <label for="createTime" style="margin-left:  11px;" >接诉时间</label>
                    <fmt:formatDate value='${createTime}' var='turnOn' pattern='yyyy-MM-dd'/>
                    <sf:input  id="createTime"  value="${turnOn}"
                               class="form_datetime"  path="createTimeStr"/>
                </div>

                <div class="inline">
                    <label for="handleTime"  style="margin-left:  83px;">处理时间</label>
                    <fmt:formatDate value='${handleTime}' var='end' pattern='yyyy-MM-dd'/>
                    <sf:input  id="handleTime"  value="${end}"
                               class="form_datetime"  path="handleTimeStr"/>
                </div>
            </div>

            <div class="ro">
                <div class="inline">
                    <label class="" for="customer" style="margin-left:  11px;" >客户姓名&nbsp</label>
                    <sf:select class="selectpicker show-tick" data-live-search="true" items="${customerList}" id="customer"
                               style="width: 80px" itemLabel="realName" itemValue="id" path="customerStr">
                    </sf:select>
                </div>

                <div class="inline">
                    <label class="" for="complainType"  style="margin-left:  84px;">投诉类型&nbsp</label>
                    <sf:select class="selectpicker show-tick " items="${complainTypeList}" id="complainType"
                               style="width: 80px" itemLabel="name" itemValue="id" path="complainTypeStr">
                    </sf:select>
                </div>
            </div>
            <div class="ro">
                <div class="inline">
                    <label class="" for="complainReason" style="margin-left:  11px;" >投诉事由&nbsp</label>
                    <sf:select class="selectpicker show-tick "  items="${complainReasonList}" id="complainReason"
                               style="width: 80px" itemLabel="name" itemValue="id" path="complainReasonStr">
                    </sf:select>
                </div>

                <div class="inline">
                    <label class="" for="processingResults"  style="margin-left:  84px;">处理结果&nbsp</label>
                    <sf:select class="selectpicker show-tick " items="${processingResultsList}" id="processingResults"
                               style="width: 80px" itemLabel="name" itemValue="id" path="processingResultsStr">
                    </sf:select>
                </div>
            </div>

            <div class="ro">
                <div class="inline">
                    <label class="" for="transfer" style="margin-left:  11px;" >移交人员&nbsp</label>
                    <sf:select class="selectpicker show-tick " data-live-search="true" items="${transferList}" id="transfer"
                               style="width: 80px" itemLabel="realName" itemValue="id" path="transferStr">
                    </sf:select>
                </div>

                <div class="inline">
                    <label class="" for="complainSource"  style="margin-left:  84px;">投诉来源&nbsp</label>
                    <sf:select class="selectpicker show-tick " items="${complainSourceList}" id="complainSource"
                               style="width: 80px" itemLabel="name" itemValue="id" path="complainSourceStr">
                    </sf:select>
                </div>
            </div>

            <div class="row">
                <label class="" for="complainSource"  style="margin-left:  84px;">&nbsp</label>
            </div>

            <div class="row">
                <div>
                    <label class="control-label" for="trackingProcess">处理跟踪进程</label>
                    <sf:textarea path="trackingProcess" id="trackingProcess"
                                 style="height:  50px;" class="form-control" rows="8"/>
                </div>
            </div>
            <div class="row">
                <div>
                    <label class="control-label" for="remarks">备注</label>
                    <sf:textarea path="remarks" id="remarks"
                                 style="height:  50px;" class="form-control" rows="8"/>
                </div>
            </div>
            <div class="row">
                <div>
                    <label class="control-label" for="complainReasonDetailStr">投诉/咨询事由</label>
                    <sf:textarea path="complainReasonDetailStr" id="complainReasonDetailStr" class="form-control" rows="8"/>
                </div>
            </div>

    </div>
        <div class="panel-footer text-center">
            <sf:input type="hidden" id="demo-text-input"
                      class="form-control" placeholder="" path="id"/>
            <button class="btn btn-pink btn-rounded" type="button"  id="add">
                <c:choose>
                    <c:when test="${isNew}">
                        保存
                    </c:when>
                    <c:otherwise>
                        修改
                    </c:otherwise>
                </c:choose>
            </button>
            <button class="btn btn-info btn-rounded" type="button" id="cancel" >取消</button>
        </div>
    <!--===================================================-->
    <!-- END BASIC FORM ELEMENTS -->
</div>
</sf:form>
</body>
<script type="text/javascript">
    $(function () {
        /*取消跳回原页面*/
        $('#cancel').click( function () {
            $('#modelInfo').modal('hide');
        })
        $('#transfer').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#transfer').selectpicker('val', '${customerComplain.transferId}');

        $('#complainSource').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#complainSource').selectpicker('val', '${customerComplain.complainSourceId}');

        $('#complainReason').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#complainReason').selectpicker('val', '${customerComplain.complainReasonId}');

        $('#processingResults').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#processingResults').selectpicker('val', '${customerComplain.processingResultsId}');

        $('#customer').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#customer').selectpicker('val', '${customerComplain.customerId}');

        $('#complainType').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#complainType').selectpicker('val', '${customerComplain.complainTypeId}');

        $("#createTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var startTimeString = e.date;
            $("#handleTime").datetimepicker("setStartDate", startTimeString)
        });
        $("#handleTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var endTimeString = e.date;
            $("#createTime").datetimepicker("setEndDate", endTimeString)
        });
        $('#add').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/complain/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/complain/list");
                    }else{
                        alert(result.message);
                    }
                }
            });
        })
        $('#investType').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#investType').selectpicker('val', '${customer.investTypeId}');

        $('#operatingStyle').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#operatingStyle').selectpicker('val', '${customer.operatingStyleId}');

        $("#turnOnTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var startTimeString = e.date;
            $("#endTime").datetimepicker("setStartDate", startTimeString)
        });
        $("#endTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true
        }).on("changeDate", function (e) {
            var endTimeString = e.date;
            $("#turnOnTime").datetimepicker("setEndDate", endTimeString)
        });
    })
</script>
</html>
