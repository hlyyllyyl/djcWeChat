<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>Dashboard | Nifty - Admin Template</title>
    <%--引入 css和js --%>
    <%@ include file="/WEB-INF/views/common/common.jsp"%>
    <%--引入 设置栏 --%>
    <%@ include file="/WEB-INF/views/common/set.jsp"%>
    <link href="/common/css/password_edit.css" rel="stylesheet">
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
                        <h1 class="page-header text-overflow">密码修改</h1>
                    </div>
                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                    <!--End page title-->

                    <!--Page content-->
                    <!--===================================================-->
                    <div id="page-content">

                        <!-- Basic Data Tables -->
                        <!--===================================================-->
                        <div class="panel text-center" >
                            <div class="panel-heading">
                                <h3 class="panel-title">修改密码</h3>
                            </div>
                            <div class="panel-body">
                                <sf:form action="listQuery" namespace="/" id="domainForm"
                                         modelAttribute="customer"  method="get">
                                <div id="error_box"></div>
                                <table align="center">
                                    <tr>
                                        <label class=" col-sm-5 control-label" style="padding-top: 5px;padding-left: 255px;"
                                               for="demo-hor-inputemail">用户名</label>
                                        <sf:input path="customerName" placeholder="Email" readonly="true" id="demo-hor-inputemail" class="form-control"/>
                                    </tr>
                                    <tr>
                                        <label></label>
                                    </tr>
                                    <tr>
                                        <label class="col-sm-5 control-label" style="padding-top: 11px;padding-left: 248px;"
                                               for="demo-hor-password">原密码</label>
                                        <sf:input path="password" placeholder="请输入原密码" type="password" id="demo-hor-password" class="form-control"/>
                                    </tr>
                                    <tr>
                                        <label></label>
                                    </tr>
                                    <tr>
                                        <label class="col-sm-5 control-label" style="padding-top: 5px;padding-left: 248px;"
                                               for="demo-hor-newPassword">新密码</label>
                                        <sf:input path="newPassword" placeholder="请输入新密码" type="password" id="demo-hor-newPassword" class="form-control"/>
                                    </tr>
                                    <tr>
                                        <label></label>
                                    </tr>
                                    <tr>
                                        <label class="col-sm-5 control-label" style="padding-top: 5px;padding-left: 248px;"
                                               for="demo-hor-nPassword">重复密码</label>
                                        <input path="nPassword" placeholder="请再次输入新密码" type="password" id="demo-hor-nPassword" class="form-control"/>
                                    </tr>
                                </table>
                            </div>
                            <div class="panel-footer text-center">
                                <button class="btn btn-pink btn-rounded" id="changePassword" type="button">确定修改</button>
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
</body>
<script type="text/javascript">
    $(function() {
        $('#changePassword').click( function () {
            var oError = document.getElementById("error_box");
            var password = $("#demo-hor-password").val();
            var newPassword = $("#demo-hor-newPassword").val();
            var nPassword = $("#demo-hor-nPassword").val();
            var isNotError = true;
            if(password==""){
                oError.innerHTML = "<font color='red'>原密码为空</font> ";
                isNotError = false;
                $("#demo-hor-password").focus();
                return;
            }
            if(newPassword==""){
                oError.innerHTML = "<font color='red'>新密码为空</font>";
                isNotError = false;
                $("#demo-hor-newPassword").focus();
                return;
            }
            if(nPassword==""){
                oError.innerHTML = "<font color='red'>请重复输入新密码</font>";
                isNotError = false;
                $("#demo-hor-nPassword").focus();
                return;
            }
            if(nPassword!=newPassword){
                oError.innerHTML = "<font color='red'>两次密码输入不一致</font>";
                isNotError = false;
                $("#demo-hor-nPassword").focus();
                return;
            }
            $.ajax({
                cache: false,
                type: "POST",
                url:"/customer/savePassword", //把表单数据发送到ajax.jsp
                data:$('#domainForm').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.message=="修改成功"){
                        alert("修改成功");
                           window.location.href ='/logout';
                    }else{
                        alert(result.message);
                    }
                }
            });
        });
        $('#demo-dt-addrow-btn').click( function () {
            $("#modelInfo .modal-body").load("/user/user_edit");
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