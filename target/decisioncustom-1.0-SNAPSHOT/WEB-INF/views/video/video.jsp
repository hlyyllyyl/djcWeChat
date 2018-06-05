<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>${columnName}">${columnName}</title>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet" />
   <%-- <link href="<%=prefixPath %>/css/yueDu -video.css" rel="stylesheet" />--%>
    <link href="<%=prefixPath %>/css/video-list.css" rel="stylesheet" />

</head>
<style>
</style>
<script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=prefixPath %>/js/pinchzoom.js"></script>
<script type="text/javascript">
    $(function () {
        $('.body-txt p img').each(function () {
            new RTP.PinchZoom($(this), {});
        });
    })
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".jianjie").click(function () {
            $(this).toggleClass("brief");
        });
        $(".jj_v").click(function () {
            $(".none_v").toggle();
        });

    });
</script>

<body>
<%--<header class="mui-bar1 mui-bar-nav1">
    <a class="mui-icon1 mui-pull-left1">
        <a class="mui-icon1 mui-pull-left1" href="<%=prefixPath %>/column/main/${columnName}">${columnName}</a>
    </a>
    <a class="mui-icon1 mui-pull-left1"
       href="javascript:;" onClick="javascript:history.back(-1);">>${video.column.name}</a>

    <a class=" mui-icon1 mui-icon-left-nav mui-pull-right1"
       href="javascript:;" onClick="javascript:history.back(-1);">返回</a>
</header>
<div class="a-h"></div>--%>
<div class="sp">
    <video width="100%" height="213" controlslist="nodownload"
           controls="controls" autoplay="autoplay">
        <source src="${video.videoPath}" type="video/ogg" />
        <source src="${video.videoPath}" type="video/mp4" />
        <source src="${video.videoPath}" type="video/webm" />
        <object data="${video.videoPath}" width="100%" height="240">
            <embed width="100%" height="240" src="${video.videoPath}" />
        </object>
    </video>
</div>
<div class="content">
    <div class="title_v">
        <span class="v_t">${video.title}</span>
        <span class="jj_v">简介》</span>
    </div>
    <div class="none_v">
        <a href="">
            <p>
                ${video.videoIntroDetails}
            </p>
        </a>
    </div>
    <div class="bfcs">
        <a href="">
            <span class="cs">播放次数:${video.playQuantity}次</span>
        </a>
    </div>
    <div class="head">
        <div class="left-img">
            <img src="${contentPath}${video.employee.headImg}" alt="" />
        </div>
        <div class="right-txt">
            <div class="tou_gu">投顾:${video.employee.realName}</div>
            <span class="zhi_ye">执业号:${video.employee.practiceNum}</span>
            <div class="jianjie brief">
                ${video.employee.employeeDetails}
            </div>
            <span class="yue">阅:${video.employee.readingQuantity}
                <span>赞:${video.employee.thumbUpQuantity}</span>
            </span>

        </div>
    </div>
    <div class="title">
        <div class="red_d"></div>
        为您推荐
    </div>
    <div class="list_v">
        <ul id="thelist">
        <c:forEach items="${videoList}" var="item">
            <c:if test="${video.id!=item.id}">
                <li class="v_li">
                    <input type="hidden"  name="1">
                    <div class="list-left_v">
                        <a href="<%=prefixPath %>/video/video?id=${item.id}">
                            <img src="${contentPath}${item.thumbnailPath}" alt="">
                        </a>
                        <a href=""><p class="v_time">${item.videoDuration}</p></a>
                    </div>
                    <div class="list-right_v">
                        <p class="right-title_v">
                            <a class="zt-a_v" href="<%=prefixPath %>/video/video?id=${item.id}">${item.title}</a>
                        </p>
                        <p class="right-txt_v zmb_txt_v">
                            <a class="zt-a2_v" href="<%=prefixPath %>/video/video?id=${item.id}"></a>
                        </p>
                        <div class="zmb_3_v">
                            <span class="time_v">
                                <fmt:formatDate value="${item.creationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </span>
                            <span class="dianZhan_v">
                                    播放次数：${item.playQuantity}
                            </span>
                        </div>
                    </div>
                </li>
            </c:if>
        </c:forEach>
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
    <div class="footer"></div>
</div>
</body>
