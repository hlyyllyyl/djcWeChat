<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="/common/css/customer_edit.css" rel="stylesheet">
<body>
<sf:form id="form" name="form" action="/user/edit" method="post"
         modelAttribute="customer" enctype="multipart/form-data">
<div class="panel">
    <div class="panel-heading">
        <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
        <h3 class="panel-title">
            <c:choose>
                <c:when test="${isNew}">
                    添加客户信息
                </c:when>
                <c:otherwise>
                    修改客户信息
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
                    <label class="" style="margin-left:  10px;" for="realName">客户姓名</label>
                        <sf:input type="text" id="realName"
                                  placeholder="" path="realName"/>
               </div>
                <div class="inline">
                    <label class=""  style="margin-left:  88px;" for="age">年龄</label>
                        <sf:input type="text" id="age" path="age"  placeholder=""/>
                </div>
            </div>
            <div class="ro">
                <div class="inline">
                    <label class="" for="team" style="margin-left:  36px;" >性别</label>
                        <sf:select path="gender" id="team" style="height: 25px;">
                            <sf:option value="">请选择</sf:option>
                            <sf:option value="1">男</sf:option>
                            <sf:option value="0">女</sf:option>
                            <sf:option value="-1">未知</sf:option>
                        </sf:select>
                </div>
                <div class="inline">
                    <label class=""  style="margin-left:  177px;" for="mobile">电话</label>
                        <sf:input type="text" id="mobile" path="mobile"  placeholder=""/>
                </div>
            </div>
            <div class="ro">
                <div class="inline">
                    <label class="" for="customerName" style="margin-left:  10px;" >客户登录名</label>
                        <sf:input type="text" id="customerName" path="customerName" placeholder=""/>
                </div>

                <div class="inline">
                    <label class=""  style="margin-left:  75px;" for="idCard">身份证号</label>
                        <sf:input type="text" id="idCard" path="idCard" placeholder=""/>
                </div>
            </div>
            <div class="ro">
                <div class="inline">
                    <label class="" for="wechatName" style="margin-left:  10px;" >微信昵称</label>
                    <sf:input type="text" id="wechatName" path="wechatName" placeholder=""/>
                </div>

                <div class="inline">
                    <label class=""  style="margin-left:  75px;" for="wechat">微信号</label>
                    <sf:input type="text" id="wechat" path="wechat" placeholder=""/>
                </div>
            </div>



            <div class="ro">

                <div class="inline">
                    <label class=""  style="margin-left:  75px;" for="remark">备注</label>
                    <sf:input type="text" id="remark" path="remark" placeholder=""/>
                </div>

                <div class="inline">
                    <label for="servicemanId" style="margin-left:  45px;" >客服</label>
                    <%--<sf:select class="selectpicker show-tick " data-live-search="true"
                               items="${serviceManList}" itemLabel="realName" multiple="true"
                               id="servicemanId" name="serviceMan"  itemValue="id" path="servicemanId">
                    </sf:select>--%>
                    <sf:select class="selectpicker show-tick selectRow " items="${serviceManList}"
                               id="servicemanId" style=" height: 15px;width: 150px;"
                               itemLabel="realName" itemValue="id" path="servicemanId">
                    </sf:select>
                </div>
            </div>

            <div class="ro">
                <div class="inline">
                    <label for="turnOnTime" style="margin-left:  12px;" >开通日期</label>
                    <fmt:formatDate value='${customer.turnOnTime}' var='turnOn' pattern='yyyy-MM-dd'/>
                    <sf:input  id="turnOnTime"  value="${turnOn}"
                               class="form_datetime"  path="turnOnTimeStr"/>
                </div>

                <div class="inline">
                    <label for="endTime"  style="margin-left:  35px;">结束日期</label>
                    <fmt:formatDate value='${customer.endTime}' var='end' pattern='yyyy-MM-dd'/>
                    <sf:input  id="endTime"  value="${end}"
                               class="form_datetime"  path="endTimeStr"/>
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
        $('#add').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/customer/customer_save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/customer/list");
                    }else{
                        alert(result.message);
                    }
                }
            });
        })
        /*取消跳回原页面*/
        $('#cancel').click( function () {
            $('#modelInfo').modal('hide');
        })
        $('#servicemanId').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#servicemanId').selectpicker('val', '${customer.servicemanId}');


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
