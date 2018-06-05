<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>修改密码</title>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/index.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/update-password.css" rel="stylesheet" />
</head>
<body>
<!-- 头部 -->
<%--<header class="mui-bar1 mui-bar-nav1">
    <a class=" mui-icon1 mui-icon-left-nav mui-pull-left1"       href="javascript:;" onClick="javascript:history.back(-1);">返回</a>
    <h1 class="mui-title1" style="color:#fff;">四川大决策投顾服务平台</h1>
    <a class="mui-btn1 mui-btn-link1 mui-pull-right1 mui-btn-blue1 mui-disabled1">...</a>
</header>
<div class="list-top"></div>--%>
<div class="content">
    <ul>
        <li class="yuan m-txt">请输入您的原始密码:</li>
        <li class="int">
            <input class="input1" style="width:100%;" type="password" id="password" name="password" maxlength="15">
        </li>
        <li class="xinmi m-txt">请输入您的新密码:</li>
        <li class="int">
            <input class="input2" style="width:100%;" type="password" id="newPassword" name="newPassword" maxlength="15">
        </li>
        <li class="xinmi3 m-txt">请再次确认您的新密码:</li>
        <li class="int">
            <input class="input3" style="width:100%;" type="password" name="newPassword" maxlength="15">
        </li>
        <li class="error m-txt"></li>
    </ul>
    <button class="but" type="button">确 定</button>
</div>
<div style="height:80px;"></div>

<%--主栏目--%>
<footer class="bottomNav" id="#bottomNav">
    <ul class="">
        <c:forEach items="${columnList}" var="item">
            <li class="btn-bom">
                <c:if test="${item.url==''}">
                <a href="javascript:void(0);">
                    </c:if>
                    <c:if test="${item.url!=''}">
                    <a href="<%=prefixPath %>${item.url}/${item.name}" class="bom-a">
                        </c:if>
                        <c:if test="${item.name==columnName}">
                            <img src="${contentPath}${item.checkImgPath}" alt="">
                            <p class="zt-h">${item.name}</p>
                        </c:if>
                        <c:if test="${item.name!=columnName}">
                            <img src="${contentPath}${item.imgPath}" alt="">

                            <c:if test="${item.name!=''||item.name!=null}">
                                <p class="zt">${item.name}</p>
                            </c:if>

                        </c:if>

                    </a>
            </li>
        </c:forEach>
    </ul>
</footer>
</body>
<script>
    $(function () {
        //点击登陆按钮时进行的判断
        $(".but").on("click", function () {
            if ($(".input1").val() == "" || $(".input2").val() == ""||$(".input3").val() == "") {
                $(".error").fadeIn(800).html("<p style='color:red'>密码不能为空!<p>");
                return false;
            }else if ($(".input2").val() != $(".input3").val()){
                $(".error").fadeIn(800).html("<p style='color:red'>两次密码输入不一致!<p>");
                return false;
            }else {
                /*$(".xinmi3").fadeOut(400);*/
                var password = $("#password").val();
                var newPassword = $("#newPassword").val();
                //前端初步判断数据类型成功以后像后台发出请求来判断登陆是否成功
                $.ajax({
                    type: "post",
                    url: "<%=prefixPath %>/customer/savePassword",//这里的data.json 是我模拟的一个json文件名。url放的是当前页面请求的后台地址。
                    dataType: "json",
                    data: {"newPassword":newPassword,"password":password},
                    success: function (result) {
                        if(result.message=="修改成功"){
                            alert("修改成功");
                            window.location.href ='<%=prefixPath %>/logout';
                        }else{
                            $(".error").fadeIn(800).html("<p style='color:red'>"+result.message+"<p>");
                            return;
                        }
                }
                });
        };
    })
    });
</script>
