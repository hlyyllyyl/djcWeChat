<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>四川大决策投顾服务平台</title>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/index.css" rel="stylesheet" />
</head>
<body>
<!-- 头部 -->
<header class="mui-bar1 mui-bar-nav1">
    <a class=" mui-icon1 mui-icon-right-nav mui-pull-right1"
       href="javascript:;" onClick="javascript:history.back(-1);">返回</a>
    <h1 class="mui-title1" style="color:#fff;">四川大决策投顾服务平台</h1>
    <a class="mui-btn1 mui-btn-link1 mui-pull-right1 mui-btn-blue1 mui-disabled1">...</a>
</header>
<div class="list-top"></div>
<div class="con">
    <img src="<%=prefixPath %>/imgs/zhaopian2.jpg" style="width:100%;" alt="">
    <p style="padding: 10px;">
    <h4>公司介绍</h4>

    四川大决策证券投资顾问有限公司成立于1998年，注册资本1000万元，是中国证监会首批批准的专业证券投资咨询机构（经营证券期货业务许可证号915101067130530143），中国证券业协会会员单位（会员代码351088），并于2011年、2012年和2013年荣获由中金在线颁发的“最佳投资咨询公司”的荣誉称号和“2017年值得信赖投资咨询公司”的荣誉称号。
    公司业务范围涵盖：证券投资咨询（证券投资咨询凭资格证书经营）；证券信息统计与分析；企业并购；资产重组咨询；电子计算机及配件开发服务及销售。 公司目前下辖市场运营中心、投顾服务中心、行政人事中心、财务管理中心、合规风控中心、分公司（上海、广州）等。
    公司秉承“稳健经营、持续创新、超越进取”的经营理念，经过二十年的积淀与发展，通过实施差异化服务的竞争战略，构建出“以客户需求为导向、以分析研究为驱动、以投顾服务为核心”的三级架构体系，不断提升核心竞争力；通过融入市场，贴近公司，为各类投资者提供资讯、研究、投顾及投资的一站式现代证券金融服务。
    公司现已形成由数十名执业投资顾问（包括教授级专家、硕士研究生、名校高材生等）和上百名具备中证协颁发资质的证券从业人员组成的专业人才梯队，长期致力于中国资本市场的深度研发，开发出一系列深受市场喜爱的投顾服务（如投资策略、前瞻分析、专题研究、证券教学等），并与中金在线、新浪财经、万得资讯等国内大型专业财经媒体和金融数据服务商结成业务上的合作，为公司长期稳健发展奠定出坚实的品牌基础。
    </p>
</div>
<div style="height:60px;"></div>

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
