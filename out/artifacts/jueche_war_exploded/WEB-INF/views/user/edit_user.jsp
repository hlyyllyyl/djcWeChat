<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="/common/css/edit_user.css" rel="stylesheet">
<body>
<sf:form id="form" name="form" action="/user/edit" method="post"
         modelAttribute="user" enctype="multipart/form-data">
<div class="panel">
    <div class="panel-heading">
        <button type="button" class="close pli-arrow-x-left" data-dismiss="modal" aria-hidden="true">
            <font size="3" color="red">
                X
            </font>
        </button>
        <h3 class="panel-title">
            <c:choose>
                <c:when test="${isNew}">
                    添加用户
                </c:when>
                <c:otherwise>
                    修改用户
                </c:otherwise>
            </c:choose>

        </h3>
    </div>
    <!-- BASIC FORM ELEMENTS -->
    <!--===================================================-->
    <table id="baseInfo" width="100%" align="center" class="list" border="0"
           cellpadding="0" cellspacing="0">
        <!--Text Input-->
        <div class="form-group">
            <label class="col-md-3 control-label" for="demo-text-input">用户名</label>
            <div class="col-md-9">
                <sf:input type="text" id="demo-text-input"  class="form-control" placeholder="" path="userName"/>
                <small class="help-block">请输入用户名</small>
            </div>
        </div>

        <!--Email Input-->
        <div class="form-group">
            <label class="col-md-3 control-label" for="demo-email-input">账号(身份证号)</label>
            <div class="col-md-9">
                <sf:input type="text" id="demo-email-input"
                          class="form-control" placeholder="" path="idCard"/>
                <small class="help-block">请输入身份证号</small>
            </div>
        </div>

        <!--Email Input-->
        <div class="form-group">
            <label class="col-md-3 control-label" for="demo-email-input">手机号</label>
            <div class="col-md-9">
                <sf:input type="text" id="demo-email-inpu" path="mobile" class="form-control" placeholder=""/>
                <small class="help-block">请输入手机号</small>
            </div>
        </div>
        <!--Email Input-->
        <div class="form-group">
            <label class="col-md-3 control-label" for="demo-email-input">微信号</label>
            <div class="col-md-9">
                <sf:input type="text" id="demo-email-inp" path="wechat" class="form-control" placeholder=""/>
                <small class="help-block">请输入微信号</small>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">上传头像</label>
            <div class="col-md-9">
                <c:choose>
                    <c:when test="${headImgExist}">
                        <img src="${headImg}"  width="100" height="100"/>
                    </c:when>
                    <c:otherwise/>
                </c:choose>
                <span class="btn btn-primary btn-rounded btn btn-primary btn-file"> 浏览...
                    <input type="file">
				 </span>
            </div>
        </div>
    </table>
        <div class="panel-footer text-center">
            <button class="btn btn-pink btn-rounded" type="button">提交</button>
            <button class="btn btn-info btn-rounded" type="button" data-dismiss="modal">取消</button>
        </div>
    <!--===================================================-->
    <!-- END BASIC FORM ELEMENTS -->
</div>
</sf:form>
</body>
</html>
