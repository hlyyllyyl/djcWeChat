<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>${article.column.name}${article.systemDictionaryItem.name==null?"":"-"}
           ${article.systemDictionaryItem.name!=null?article.systemDictionaryItem.name:""}</title>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet">
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet">
    <link href="<%=prefixPath %>/css/article.1.css" rel="stylesheet">
    <script src="<%=prefixPath %>/common/js/common.js"></script>

    <script src="<%=prefixPath %>/js/pinchzoom.js"></script>

    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".a_tu_2").click(function () {
                $(this).toggleClass("a_tu_3");
                $(".jianjie").toggleClass("brief");
            });
        });
    </script>
    <script type="text/javascript">
        $(function () {
            $('.body-txt p img').each(function () {
                new RTP.PinchZoom($(this), {});
            });
        })
    </script>
</head>
<body>
<%--<header class="mui-bar1 mui-bar-nav1">
    <a class="mui-icon1 mui-pull-left1">
        <a class="mui-icon1 mui-pull-left1" href="<%=prefixPath %>/column/main/${columnName}">${columnName}</a>
    </a>
    <a class="mui-icon1 mui-pull-left1"
       href="javascript:;" onClick="javascript:history.back(-1);">>${article.column.name}</a>

    <a class=" mui-icon1 mui-icon-left-nav mui-pull-right1"
       href="javascript:;" onClick="javascript:history.back(-1);">返回</a>
</header>
<div class="a-h"></div>--%>
<div class="content">
    <div class="head">
        <div class="right-txt">
            <div class="jianjie brief left-img">
                <p style="font-size:12px;">
                    <img class="a_tu" src="${contentPath}${article.employee.headImg}" alt="">
                    <img class="a_tu2" src="${contentPath}${article.employee.headImg}" alt="">
                    <span class="tou_gu">投资顾问：${article.employee.realName}</span>

                    <span class="zhi_ye">(执业号：${article.employee.practiceNum})</span>
                    <br> ${article.employee.employeeDetails}
                </p>
            </div>
            <span class="yue">总阅读量：${article.employee.readingQuantity}
                    <span>总点赞量：${article.employee.thumbUpQuantity}</span>
                </span>

        </div>
        <img class="a_tu_2 a_tu_3" src="<%=prefixPath %>/imgs/vwap-triangle@3x.zd9Tmgqu.png" alt="">
    </div>
    <div class="title">
        ${article.title}
            <div class="t_d">
                <div class="t-time">
                    <span class="time"> <fmt:formatDate value="${article.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                    <span class="lai">来源:${article.source}</span>

                </div>
                <div class="fxts">市场有风险 投资需谨慎</div>

            </div>
    </div>


    <div class="body-txt" id="body_txt">
            <div class="zhanwei" style="font-size:17px;">
                    ${article.title}
            </div>
        ${article.articleIntroDetails}
    </div>
    <div class="da_zhan">
        <div class="dianji">
             <span class="liuLan">
                <img src="<%=prefixPath %>/imgs/ios/17@2x.png" alt="" />${article.readingQuantity}
             </span>
            <span class="dianZhan">
                <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />${article.thumbUpQuantity}
            </span>
        </div>
        <a href="javascript:void(0)" onclick='thumbUp(${article.id})'>
            <img  style="width:50px;height:50px;text-align: center;" src="<%=prefixPath %>/imgs/zan.png" alt="">
            <!-- <div style="color:#999;font-size:10px">点赞量： 4</div> -->
        </a>
    </div>
    <footer>
        <p class="p_zy" style="padding:10px;font-size:5px;color:#a9a9a9;line-height: 12px;">
            【重要声明】本信息仅供四川大决策证券投资顾问有限公司（以下简称“本公司”）的客户使用。 本公司不会因为任何机构或个人接收到本信息而视其为本公司的当然客户。 本信息基于已公开的资料或信息撰写，但本公司不保证该等信息及资料的完整性、准确性。 本信息所载的信息、资料、建议及推测仅反映本公司于本信息发布当日的判断，
            本信息中的证券或投资标的价格、价值及投资带来的收入可能会波动。在不同时期， 本公司可能撰写并发布与本信息所载资料、建议及推测不一致的信息。 本公司不保证本信息所含信息及资料保持在最新状态，本公司将随时补充、 更新和修订有关信息及资料，但不保证及时公开发布。同时，
            本公司有权对本信息所含信息在不发出通知的情形下做出修改， 投资者应当自行关注相应的更新或修改。任何有关本信息的摘要或节选都 不代表本信息正式完整的观点，一切须以本公司向客户发布的本信息完整版本为准。 客户不应将本信息为作出其投资决策的惟一参考因素，亦不应认为本信息可以取代客
            户自身的投资判断与决策。在任何情况下，本公司亦不对任何人因使用本信息中的任何 内容所引致的任何损失负任何责任。市场有风险，投资需谨慎。
        </p>

    </footer>
    <%--推荐阅读--%>
    <c:if test="${article.url!=''}">
        <div>
            推荐阅读：<a href="${article.url}">${article.urlTitle} </a>
        </div>
    </c:if>
    <%--音频--%>
    <c:if test="${article.voicePath!=''}">
        <audio controls="controls" style="width:100%">
            <source src="${contentPath}${article.voicePath}" type="audio/ogg">
            <source src="${contentPath}${article.voicePath}" type="audio/mpeg">
        </audio>
    </c:if>
    <c:if test="${upArticle.title!=null}">
        <div class="one">
            <c:if test="${q!=null}">
                <a class="top-one"  href="<%=prefixPath%>/article/queryArticle?id=${upArticle.id}&q=${q}">上一篇:${upArticle.title}</a>
            </c:if>
            <c:if test="${q==null}">
                <a class="top-one"  href="<%=prefixPath%>/article/article?id=${upArticle.id}">上一篇:${upArticle.title}</a>
            </c:if>
        </div>
    </c:if>
    <c:if test="${nextArticle.title!=null}">
        <div class="one">
            <c:if test="${q!=null}">
                <a class="bottom-one" href="<%=prefixPath%>/article/queryArticle?id=${nextArticle.id}&q=${q}">下一篇:${nextArticle.title}</a>
            </c:if>

            <c:if test="${q==null}">
                <a class="bottom-one" href="<%=prefixPath%>/article/article?id=${nextArticle.id}">下一篇:${nextArticle.title}</a>
            </c:if>
        </div>
    </c:if>

    <c:if test="${advertising!=null}">
        <div class="img-lan">
            <c:if test="${advertising.articleIntroDetails!=null}">
            <c:if test="${advertising.adPath!=null && advertising.adPath!=''}">
            <a href="${advertising.adPath}">
                </c:if>

                <c:if test="${advertising.adPath==null || advertising.adPath==''}">
                <a href="<%=prefixPath%>/advertising/article${advertising.id}">
                    </c:if>
                    <img src="${contentPath}${advertising.imgPath}" style="width:100%" alt="">
                </a>
                </c:if>
                <c:if test="${advertising.articleIntroDetails==null}">
                <a href="javascript:void(0);">
                    <img src="${contentPath}${advertising.imgPath}" style="width:100%" alt="">
                </a>
                </c:if>
        </div>
    </c:if>
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

