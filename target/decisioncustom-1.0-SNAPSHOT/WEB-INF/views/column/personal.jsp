<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath = "/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>个人中心</title>
    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=prefixPath %>/common/js/common.js"></script>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet"/>
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet"/>
    <link href="<%=prefixPath %>/css/my.css" rel="stylesheet"/>
</head>
<script>
    $(function () {
        var Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;

            // Variables privadas
            var links = this.el.find('.link');
            // Evento
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
        }

        Accordion.prototype.dropdown = function (e) {
            var $el = e.data.el;
            $this = $(this),
                $next = $this.next();

            $next.slideToggle();
            $this.parent().toggleClass('open');

            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            }
            ;
        }

        var accordion = new Accordion($('#accordion'), false);

        $("#logout").click(function () {
            goUrl("<%=prefixPath %>/logout");
        })
    });
    function getResidueTime(startTime,endTime) {
        return parseInt((startTime.getTime() - endTime.getTime()) / parseInt(1000*3600*24));
    }
</script>
<body>
<%--<header class="mui-bar1 mui-bar-nav1">

    <a class=" mui-icon1 mui-icon-left-nav mui-pull-left1"
       href="javascript:;" onClick="javascript:history.back(-1);">返回</a>

    <h1 class="mui-title1" style="color:#fff;">个人中心</h1>
    <a class="mui-btn1 mui-btn-link1 mui-pull-right1 mui-btn-blue1 mui-disabled1">...</a>
</header>
<div style="height:45px;"></div>--%>
<!-- 主要内容 -->
<div class="content">
    <div class="touXiang">
        <div class="touImg">
            <div class="tuk">
                <img src="${customer.wxHeadImg==null?'/djc/imgs/touImg.png':customer.wxHeadImg}" alt="">
            </div>
            <div class="tou-zt">
                <p class="zt_1">${customer.realName}</p>
                <p class="zt_2">${customer.customerName}</p>
            </div>
        </div>
    </div>
    <ul class="bian">
        <ul id="accordion" class="accordion">
            <li>
                <div class="link">
                    <img src="<%=prefixPath %>/imgs/11.png" alt="">
                    <span class="gouMai">我的客服</span>
                    <i class="mui-icon2 mui-icon-forward"></i>
                </div>
                <ul class="submenu">
                    <li class="List canPing">
                        <div class="left-img">
                            <img style="width:60px;height:60px;margin-left: 20px;"
                                 src="${customer.serviceMan.quickMark}" alt="">
                        </div>
                        <div class="right-txt">
                            <p class="title">姓名:${customer.serviceMan.realName}</p>
                            <p class="time">电话:${customer.serviceMan.phoneNum}</p>
                            <p class="time">执业编号:${customer.serviceMan.practiceNum}</p>
                        </div>
                    </li>
                </ul>
            </li>
            <li>
                <div class="link">
                    <img src="<%=prefixPath %>/imgs/fangKuai_06.png" alt="">
                    <span class="gouMai">购买的产品</span>
                    <i class="mui-icon2 mui-icon-forward"></i>
                </div>
                <ul class="submenu">
                    <c:forEach items="${customer.customerColumns}" var="item">
                        <li class="List canPing">
                            <div class="left-img">
                                <img src="${item.column.imgPath}" alt="">
                            </div>
                            <div class="right-txt">
                                <p class="title">${item.column.name}</p>
                                <p class="time">服务时间：
                                    <fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/>
                                    -
                                    <fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd"/>
                                </p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </ul>

        <li class="List myjy" style="margin-top: -33px">
            <a href="<%=prefixPath %>/column/suggest">
                <img src="<%=prefixPath %>/imgs/biX.png" alt="">
                <span class="gouMai">我的建议
                    <c:if test="${num!=0}">
                         <span class="dian" style="display: inline-block;height:7px;width: 7px;
                             background: red;border-radius:50%;">
                         </span>
                    </c:if>
                </span>
                <i class="mui-icon2 mui-icon-forward"></i>
            </a>

        </li>
        <li class="List myjy">
            <a href="<%=prefixPath %>/customer/updatePassword">
                <img src="<%=prefixPath %>/imgs/tu1.png" alt="">
                <span class="gouMai">修改密码</span>
                <i class="mui-icon2 mui-icon-forward"></i>
            </a>
        </li>
        <li class="List myjy">
            <c:if test="${advertising.adPath!=null || advertising.adPath!=''}">
            <a href="${advertising.adPath}">
                </c:if>

                <c:if test="${advertising.adPath==null || advertising.adPath==''}">
                <a href="<%=prefixPath %>/advertising/article37">
                </c:if>
                    <img src="<%=prefixPath %>/imgs/tu2.png" alt="">
                    <span class="gouMai">关于我们</span>
                    <i class="mui-icon2 mui-icon-forward"></i>
                </a>
        </li>
        <li class="List myjy">
            <a href="<%=prefixPath %>/logout">
                <img src="<%=prefixPath %>/imgs/tuichu_03.png" alt="">
                <span class="gouMai">退出当前账号</span>
                <i class="mui-icon2 mui-icon-forward"></i>
            </a>
        </li>
    </ul>
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
