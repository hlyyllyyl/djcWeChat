<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    //获取项目名
    String path = request.getContextPath();
    //http://localhost:8080/项目名/
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String prefixPath ="/djc";
%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>四川大决策投顾服务平台</title>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/index.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/shouqian.css" rel="stylesheet" />
</head>
<body>
<!-- 头部 -->
<%--<header class="mui-bar1 mui-bar-nav1">
    <a class=" mui-icon1 mui-icon-left-nav mui-pull-left1"       href="javascript:;" onClick="javascript:history.back(-1);">返回</a>
    <h1 class="mui-title1" style="color:#fff;">四川大决策投顾服务平台</h1>
    <a class="mui-btn1 mui-btn-link1 mui-pull-right1 mui-btn-blue1 mui-disabled1">...</a>
</header>
<div style="height:45px;"></div>--%>

<!-- neirong -->
<div class="con">
    <div class="logo">
        <img src="<%=prefixPath %>/imgs/logo_1.png" alt="">
    </div>
    <div class="title_1">四川大决策证劵投资顾问有限公司</div>
    <div class="body_1">
        <div class="zt_1">售前咨询</div>
        <div class="zt_2">联系电话：028-87732670</div>
        <div class="zt_3">028-87732075</div>
        <div class="zt_2 p_top">工作时间：上午9:30-11:30</div>
        <div class="zt_3 p_top">下午12:30-18:00</div>
        <div class="weim2">
            <img src="<%=prefixPath %>/imgs/liuqiao3.png" alt="">
            <div class="zt_2 right_1">工作时间：<p>上午9:30-11:30 </p><p>下午12:30-18:00</p></div>
        </div>

    </div>
</div>
<!-- 尾部导航 -->
<div class="f-div"></div>
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
<script type="text/javascript" charset="utf-8">

</script>
