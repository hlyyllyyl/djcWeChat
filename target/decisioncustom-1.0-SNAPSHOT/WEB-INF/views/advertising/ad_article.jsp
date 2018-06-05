<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>四川大决策投顾服务平台</title>
     <script src="/js/jquery-3.3.1.js"></script>
    <link href="/css/index.css" rel="stylesheet" />
    <link href="/css/footer.css" rel="stylesheet" />
    <link href="/css/article.css" rel="stylesheet" />
</head>
<style>
	.body-txt img{
		width:100%;
	}
        body{
	margin:0px;
       }
</style>
<body>
<header class="mui-bar1 mui-bar-nav1">
    
</header>
<div class="a-h"></div>
<div class="content">

    <div class="body-txt" >
        ${article.articleIntroDetails}
    </div>

</div>

<!-- 尾部导航 -->
<div class="f-div"></div>

</body>

</html>