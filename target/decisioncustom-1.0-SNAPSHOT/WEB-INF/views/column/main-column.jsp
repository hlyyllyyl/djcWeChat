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

    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>

    <script src="<%=prefixPath %>/common/js/common.js"></script>

    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <link href="<%=prefixPath %>/css/index.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=prefixPath %>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=prefixPath %>/css/dist/swipeslider.css">
    <link href="<%=prefixPath %>/css/pullDown.css" rel="stylesheet" />


    <link href="<%=prefixPath %>/css/video-list-big.css" rel="stylesheet" />

    <link href="<%=prefixPath %>/css/main/big_list.css" rel="stylesheet" />

    <link href="<%=prefixPath %>/css/main/text.css" rel="stylesheet" />

    <link href="<%=prefixPath %>/css/main/video-list.css" rel="stylesheet"/>

    <link href="<%=prefixPath %>/css/blend.css" rel="stylesheet" />

</head>
<body>
<!-- 头部 -->
<!--<header class="mui-bar1 mui-bar-nav1">
    <h1 class="mui-title1" style="color:#fff;">四川大决策投顾服务平台</h1>
</header>-->
<div class="list-top"></div>
<!-- 搜索框 -->
<div class="inpt">
    <h2 style="text-align:center; margin-top:20px;border-radius:50%;"></h2>
    <div class="style_1">
        <form method="get" id="searchform" action="<%=prefixPath %>/article/query">

            <fieldset>
                <input  type="submit" value />
                <input id="s" name="q" type="text" value="股票、标题、作者" class="text_input" onblur="if(this.value==''){this.value='股票、标题、作者';}"
                       onfocus="if(this.value =='股票、标题、作者') {this.value=''; }" />
            </fieldset>
        </form>
    </div>
</div>


<%--上拉下拉--%>
<div id="wrapper" style="top: 0px;">
    <div id="scroller">

        <div id="pullDown">
            <span class="pullDownIcon" ></span>
            <span class="pullDownLabel">下拉刷新...</span>
        </div>
	
<div class="list-top"></div>

<section>
    <figure id="full_feature" class="swipslider">
        <ul class="sw-slides">
            <c:forEach items="${advertisingList}" var="item">
                  <li class="sw-slide">

                      <c:if test="${item.adPath!=null && item.adPath!=''}">
                         <a href="${item.adPath}">
                      </c:if>

                      <c:if test="${item.adPath==null || item.adPath==''}">
                          <a href="<%=prefixPath%>/advertising/article${item.id}">
                      </c:if>

                        <img src="${contentPath}${item.imgPath}" alt="Summer beach concept">
                    </a>
                </li>
            </c:forEach>
        </ul>
    </figure>
</section>


        <%--子栏目--%>
        <nav class="btnImg">
            <c:forEach items="${columnList}" var="item">
            <c:if test="${item.name==columnName}">
            <c:forEach items="${item.childrenColumn}" var="items">

                <c:if test="${items.checkImgPath!=null}">
                      <a href="${items.url}" class="img-a">
                </c:if>

                <c:if test="${items.checkImgPath==null || items.checkImgPath==''}">
                     <a href="<%=prefixPath %>${items.url}" class="img-a">
                </c:if>
                        <div class="img-con">
                            <img src="${contentPath}${items.imgPath}">
                            <p>${items.name}</p>
                        </div>
                     </a>
                </c:forEach>
                </c:if>
                </c:forEach>
        </nav>

        <div style="height:10px;background: #EFEFF4;"></div>

        <section class="textConter">
                <div class="content">
                    <ul id="thelist">

                    </ul>
                </div>
            </section>
            <div id="pullUp">
                <span class="pullUpIcon"></span><span class="pullUpLabel">上拉加载更多...</span>
            </div>
	    <div class="spinner">
                <div class="spinner-container container1">
                  <div class="circle1"></div>
                  <div class="circle2"></div>
                  <div class="circle3"></div>
                  <div class="circle4"></div>
                </div>
                <div class="spinner-container container2">
                  <div class="circle1"></div>
                  <div class="circle2"></div>
                  <div class="circle3"></div>
                  <div class="circle4"></div>
                </div>
                <div class="spinner-container container3">
                  <div class="circle1"></div>
                  <div class="circle2"></div>
                  <div class="circle3"></div>
                  <div class="circle4"></div>
                </div>
            </div>
    </div>
</div>


<!-- 尾部导航 -->
<div class="f-div" style="height:160px;"></div>

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
<script src="<%=prefixPath %>/js/mui.min.js"></script>
<script>window.jQuery || document.write('<script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"><\/script>')</script>
<script type="text/javascript" src="<%=prefixPath %>/css/dist/swipeslider.min.js"></script>
<script type="application/javascript" src="<%=prefixPath %>/js/iscroll.js"></script>
<script type="text/javascript">
    $(window).load(function () {
        $('#full_feature').swipeslider();
        $('#content_slider').swipeslider({
            transitionDuration: 600,
            autoPlayTimeout: 10000,
            sliderHeight: '300px'
        });
        $("#thelist").on("click", ".mo1_content", function (event) {
            var target = $(event.target);
            target.toggleClass('mo1_brief');
            $index++;
            console.log($index);
        })
        var $index = 0;
        pullUpAction();
    });

    var myScroll,
        pullDownEl, pullDownOffset,
        pullUpEl, pullUpOffset,
        generatedCount = 0;

    var pageNum = 1;
    var downNum =0;
    var pageSize = 6;
    var type ;
    if(${templateName=='smallImg' || templateName=='mediumImg' || templateName=='bigImg' || templateName=='text'}){
        type="article";
    }
    if(${templateName=='smallVideo' || templateName=='bigVideo' }){
        type="video";
    }
    /**
     * 下拉刷新 （自定义实现此方法）
     * myScroll.refresh();  // 数据加载完成后，调用界面更新方法
     */
    function pullDownAction () {
        setTimeout(function () { // <-- Simulate network congestion, remove setTimeout from production!
            var el, li, i;
            el = document.getElementById('thelist');
                $.ajax({
                    url:'<%=prefixPath %>/column/v/'+type+'/${columnId}',
                    type:'get',
                    data: {"page":downNum,"pageSize":pageSize},
                    dataType: "json",
                    async: false,
                    success:function(result){
                        if(result==null){
                            alert("152633")
                        }
                       /* console.log(result.data)*/
                        for (i=0; i<result.data.length; i++) {
                            li = document.createElement('li');
                            li.innerHTML =
                                '                            <div class="list-left">\n' +
                                '                            <a href="<%=prefixPath %>/article/article?id='+(result.data[i].id)+'"><img src="${contentPath}'+(result.data[i].titleImg)+'" alt=""></a>\n' +
                                '                            </div>\n' +
                                '                            <div class="list-right">\n' +
                                '                            <p class="right-title">\n' +
                                '                            <a class="zt-a" href="<%=prefixPath %>/article/article?id='+(result.data[i].id)+'">'+(result.data[i].title)+'</a>\n' +
                                '                            </p>\n' +
                                '                            <p class="right-txt zmb_txt" >'+(result.data[i].articleIntro)+'</p>\n' +
                                '                            <div class="right-3 zmb_3">\n' +
                                '                            <span class="time">\n' +
                                '                           '+(result.data[i].createTimeStr)+'\n' +
                                '                            </span>\n' +
                                '                            <span class="liuLan">\n' +
                                '                            <img src="<%=prefixPath %>/imgs/ios/17@2x.png" alt="" />'+(result.data[i].readingQuantity)+'</span>\n' +
                                '                            <span class="dianZhan">\n' +
                                '                            <a href="javascript:void(0)"  onclick=\'thumbUp('+(result.data[i].id)+')\'>\n' +
                                '                            <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />'+(result.data[i].thumbUpQuantity)+'\n' +
                                '                            </a>\n' +
                                '                            </span>\n' +
                                '                            </div>\n' +
                                '                            </div>\n'
                            ;
                            el.insertBefore(li, el.childNodes[0]);
                        }
                        if(result.data.length!=0){
                            downNum--;
                        }
                    }
                });
            myScroll.refresh();  //数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)
        }, 1000); // <-- Simulate network congestion, remove setTimeout from production!
    }

    /**
     * 滚动翻页 （自定义实现此方法）
     * myScroll.refresh();  // 数据加载完成后，调用界面更新方法
     */
    function pullUpAction () {

        setTimeout(function () { // <-- Simulate network congestion, remove setTimeout from production!
            var el, li, i,cl,ci;
            el = document.getElementById('thelist');
            if($("#bottom").length<=0){
                $.ajax({
                    url:'<%=prefixPath %>/column/v/'+type+'/${columnId}',
                    type:'get',
                    data: {"page":pageNum,"pageSize":pageSize},
                    dataType: "json",
                    async: false,
                    success:function(result){
                        if(result==null){
                            alert("152633")
                        }
                        /* console.log(result.data)*/
                        if(type=="article"){
                            if(result.data.articleList.length==0){
                                li = document.createElement('li');
                                if($("#bottom").length<=0){
                                    li.setAttribute("id","bottom");

                                    li.innerHTML ='<div style="width:100%;text-align: center;">\n' +
                                        '        <span style="height:1px;background: #999;margin:2px;width:30%;text-align: left;display: inline-block;"></span>\n' +
                                        '        <span style="width:30%;color:#999;font-size:12px;text-align: center;display: inline-block;">我也是有底线的</span>\n' +
                                        '        <span style="height:1px;background: #999;;margin:2px;width:30%;text-align: right;display: inline-block;"></span>\n' +
                                        '    </div>';
                                    el.appendChild(li, el.childNodes[0]);
                                    return;
                                }
                            }
                            if(result.data.articleList.length!=0){
                                for (i=0; i<result.data.articleList.length; i++) {
                                    li = document.createElement('li');
                                    if (result.data.templateName=='text') {
                                        li.setAttribute("class","text");
                                        li.innerHTML ='  <div class="mo1_gHIxRM">\n' +
                                            '                                <div id="mo1_tele" class="mo1_brief2">\n' +
                                            '                            <span class="mo1_time2">\n' +
                                            '                           '+(result.data.articleList[i].createTimeStr)+'\n' +
                                            '                            </span>\n' +
                                            '                                    <span class="mo1_content mo1_brief">\n' +
                                            '                                            '+(result.data.articleList[i].articleIntro)+' \n' +
                                            '                                    </span>\n' +
                                            '                                </div>\n' +
                                            '                                <div class="mo1_info">\n' +
                                            '                                <span class="mo1_data">\n' +
                                            '                                    <span class="mo1_read">阅:'+(result.data.articleList[i].readingQuantity)+'</span>\n' +
                                            '                                </span>\n' +
                                            '                                </div>\n' +
                                            '                            </div>';
                                        el.insertBefore(li, el.childNodes[0]);
                                    }

                                    if (result.data.templateName=='mediumImg') {
                                        li.innerHTML =
                                            '                            <div class="list-left">\n' +
                                            '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'"><img src="${contentPath}'+(result.data.articleList[i].titleImg)+'" alt=""></a>\n' +
                                            '                            </div>\n' +
                                            '                            <div class="list-right">\n' +
                                            '                            <p class="right-title">\n' +
                                            '                            <a class="zt-a" href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">'+(result.data.articleList[i].title)+'</a>\n' +
                                            '                            </p>\n' +
                                            '                            <p class="right-txt zmb_txt" ><a class="zt-a" href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">'+(result.data.articleList[i].articleIntro)+'</a></p>\n' +
                                            '                            <div class="right-3 zmb_3">\n' +
                                            '                            <span class="time">\n' +
                                            '                           '+(result.data.articleList[i].createTimeStr)+'\n' +
                                            '                            </span>\n' +
                                            '                            <span class="liuLan">\n' +
                                            '                            <img src="<%=prefixPath %>/imgs/ios/17@2x.png" alt="" />'+(result.data.articleList[i].readingQuantity)+'</span>\n' +
                                            '                            <span class="dianZhan">\n' +
                                            '                            <a href="javascript:void(0)"  onclick=\'thumbUp('+(result.data.articleList[i].id)+')\'>\n' +
                                            '                            <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />'+(result.data.articleList[i].thumbUpQuantity)+'\n' +
                                            '                            </a>\n' +
                                            '                            </span>\n' +
                                            '                            </div>\n' +
                                            '                            </div>\n';
                                    }
                                    if (result.data.templateName=='bigImg') {
                                        li.setAttribute("class","bigImg")
                                        li.innerHTML =
                                            ' <div class="mui-card2">\n' +
                                            '                        <div class="mui-card-header mui-card-media">\n' +
                                            '                            <a href="<%=prefixPath %>/article/article?id=' + (result.data.articleList[i].id) + '">\n' +
                                            '                                <div class="title-txt">\n' +
                                            '                                        ' + (result.data.articleList[i].title) + '\n' +
                                            '                                </div>\n' +
                                            '                                <div class="mui-card-content">\n' +
                                            '                                    <img src="${contentPath}' + (result.data.articleList[i].titleImg) + '" alt="" width="100%">\n' +
                                            '                                </div>\n' +
                                            '                            </a>\n' +
                                            '                            <div class="mui-card-footer2">\n' +
                                            '                                <p class="p_width2 big_p">\n' +
                                            '                                    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <a style="color:#999" href="<%=prefixPath %>/article/article?id=' + (result.data.articleList[i].id) + '">\n' +
                                            '                                        ' + (result.data.articleList[i].articleIntro) + '\n' +
                                            '                                </a></p>\n' +
                                            '                                <p class="p_width">\n' +
                                            '                                    <span class="time">\n' +
                                            '                           ' + (result.data.articleList[i].createTimeStr) + '\n' +
                                            '                                    </span>\n' +
                                            '                                        <span class="liulan_da">\n' +
                                            '                                          <img src="<%=prefixPath %>/imgs/ios/17@2x.png">\n' +
                                            '                                             <span class="mun">' + (result.data.articleList[i].readingQuantity) + '</span>\n' +
                                            '                                       </span>\n' +
                                            '    \n' +
                                            '                                        <span class="dianZhan_da">\n' +
                                            '                                            <a href="javascript:void(0)"  onclick=\'thumbUp(' + (result.data.articleList[i].id) + ')\'>\n' +
                                            '                                                  <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />' + (result.data.articleList[i].thumbUpQuantity) + '\n' +
                                            '                                            </a>\n' +
                                            '                                        </span>\n' +
                                            '                                </p>\n' +
                                            '                            </div>\n' +
                                            '                        </div>\n' +
                                            '                    </div>';
                                    }
                                    el.appendChild(li, el.childNodes[0]);
                                }
                                if (result.data.templateName=='smallImg') {
                                    for (i=0; i<result.data.articleList.length; i++) {
                                        li = document.createElement('li');
                                        li.innerHTML ='<div class="blend_cont">\n' +
                                            '                    <div class="blend_big">\n' +
                                            '                        <div class="blend_big-title">\n' +
                                            '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                            '                                <div class="big_title">\n' +
                                            '                          ' +(result.data.articleList[i].title)+
                                            '                                </div>\n' +
                                            '                            </a>\n' +
                                            '                        </div>\n' +
                                            '                        <div class="big_img">\n' +
                                            '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                            '                                <img src="${contentPath}'+(result.data.articleList[i].titleImg)+'" alt="主题图">\n' +
                                            '                            </a>\n' +
                                            '                        </div>\n' +
                                            '                        <div class="blend_big-txt">\n' +
                                            '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                            '                                <p class="big-txt">\n' +
                                            '                                 '  +(result.data.articleList[i].articleIntro)+
                                            '                                </p>\n' +
                                            '                            </a>\n' +
                                            '                            <div class="blend_big-footer">\n' +
                                            '                                <span class="blend_big-time">\n' +
                                            '                                   '+(result.data.articleList[i].createTimeStr)+'\n' +
                                            '                                </span>\n' +
                                            '\n' +
                                            '                                <span class="blend_big-liulan">\n' +
                                            '                                    <img src="<%=prefixPath %>/imgs/ios/17@2x.png">\n' +
                                            '                                    <span class="mun">'+(result.data.articleList[i].readingQuantity)+'</span>\n' +
                                            '                                </span>\n' +
                                            '                                <span class="blend_big-dianZhan">\n' +
                                            '                                    <a href="javascript:void(0)" onclick="thumbUp(486)">\n' +
                                            '                                        <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="">'+(result.data.articleList[i].thumbUpQuantity)+'\n' +
                                            '                                    </a>\n' +
                                            '                                </span>\n' +
                                            '                                <p>\n' +
                                            '                                </p>\n' +
                                            '                            </div>\n' +
                                            '                        </div>\n' +
                                            '                    </div>\n' +
                                            '                    <ul  id="'+(result.data.articleList[i].id)+'" class="blend_small">\n' +
                                            '                    </ul>\n' +
                                            '                </div>';
                                        el.appendChild(li, el.childNodes[0]);
                                        cl = document.getElementById(result.data.articleList[i].id);
                                        for (j=0; j<result.data.articleList[i].children.length; j++) {
                                            ci = document.createElement('li');
                                            ci.innerHTML=
                                                '                            <div class="blend_small-cont">\n' +
                                                '                                <div class="blend_small_left">\n' +
                                                '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].children[j].id)+'">\n' +
                                                '                                    <img src="${contentPath}'+(result.data.articleList[i].children[j].titleImg)+'" alt="">\n' +
                                                '                            </a>\n' +
                                                '                                </div>\n' +
                                                '                                <div class="blend_small_right">\n' +
                                                '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].children[j].id)+'">\n' +
                                                '                                    <div class="right_title">\n' +
                                                '                                     ' +(result.data.articleList[i].children[j].title)+
                                                '                                    </div>\n' +
                                                '                            </a>\n' +
                                                '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].children[j].id)+'">\n' +
                                                '                                    <div class="right_jj">\n' +
                                                '                                           '  +(result.data.articleList[i].children[j].articleIntro)+
                                                '                                    </div>\n' +
                                                '                            </a>\n' +
                                                '                                    <div class="right_time">\n' +
                                                '                                        <span class="right_t">\n' +
                                                '                                   '+(result.data.articleList[i].children[j].createTimeStr)+'\n' +
                                                '                                        </span>\n' +
                                                '                                        <span class="right_time_liuLan">\n' +
                                                '                                            <img src="<%=prefixPath %>/imgs/ios/17@2x.png" alt="">'+(result.data.articleList[i].children[j].readingQuantity)+'\n' +
                                                '                                        </span>\n' +
                                                '                                        <span class="right_time_dianZhan">\n' +
                                                '                                            <a href="javascript:void(0)" onclick="thumbUp(570)">\n' +
                                                '                                                <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="">'+(result.data.articleList[i].children[j].thumbUpQuantity)+'\n' +
                                                '                                            </a>\n' +
                                                '                                        </span>\n' +
                                                '                                    </div>\n' +
                                                '                                </div>\n' +
                                                '                            </div>\n' +
                                                '';
                                            cl.appendChild(ci, cl.childNodes[0]);
                                        }
                                    }
                                }
                            }
                        }
                        if(type=="video"){
                            if(result.data.videoList.length==0){
                                li = document.createElement('li');
                                if($("#bottom").length<=0){
                                    li.setAttribute("id","bottom");
                                    li.innerHTML ='<div style="width:100%;text-align: center;">\n' +
                                        '        <span style="height:1px;background: #999;margin:2px;width:30%;text-align: left;display: inline-block;"></span>\n' +
                                        '        <span style="width:30%;color:#999;font-size:12px;text-align: center;display: inline-block;">我也是有底线的</span>\n' +
                                        '        <span style="height:1px;background: #999;;margin:2px;width:30%;text-align: right;display: inline-block;"></span>\n' +
                                        '    </div>';
                                    el.appendChild(li, el.childNodes[0]);
                                    return;
                                }
                            }
                            if(result.data.videoList.length!=0){
                                for (i=0; i<result.data.videoList.length; i++) {
                                    li = document.createElement('li');
                                    if (${templateName=='smallVideo'}) {
                                        li.setAttribute("class","smallVideo");
                                        li.innerHTML =
                                            '<input type="hidden" id="column" name="1">\n' +
                                            '                    <div class="list-left_v">\n' +
                                            '                            <a href="<%=prefixPath %>/video/video?id=' + (result.data.videoList[i].id) + '">' +
                                            '                               <img src="${contentPath}' + (result.data.videoList[i].thumbnailPath) + '" alt="">' +
                                            '                            </a>\n' +
                                            '                        <p class="v_time">' + (result.data.videoList[i].videoDuration) + '</p>\n' +
                                            '                    </div>\n' +
                                            '                    <div class="list-right_v">\n' +
                                            '                        <p class="right-title_v">\n' +
                                            '                            <a class="zt-a_v" href="<%=prefixPath %>/video/video?id=' + (result.data.videoList[i].id) + '">' + (result.data.videoList[i].title) + '</a>\n' +
                                            '                        </p>\n' +
                                            '                        <div class="zmb_3_v">\n' +
                                            '                            <span class="time_v">\n' +
                                            '                                ' + (result.data.videoList[i].createTimeStr) + '\n' +
                                            '                            </span>\n' +
                                            '                          <span class="dianZhan_v">\n' +
                                            '                                ' + '播放次数：' + (result.data.videoList[i].playQuantity) + '\n' +
                                            '                          </span>\n' +
                                            '                        </div>\n' +
                                            '                    </div>'
                                        ;
                                    }
                                    if (${templateName=='bigVideo'}) {
                                        li.innerHTML =
                                            ' <div class="yk-big">\n' +
                                            '                   <a href="<%=prefixPath %>/video/video?id='+(result.data.videoList[i].id)+'">' +
                                            '                    <img class="img-big-1" src="${contentPath}'+(result.data.videoList[i].thumbnailPath)+'" alt="">\n' +
                                            '                            </a>\n' +
                                            '                    <div class="v-b-t">\n' +
                                            '                        <span class="b-t">播放次数：'+(result.data.videoList[i].playQuantity)+'</span>\n' +
                                            '                        <img src="<%=prefixPath %>/imgs/TV-Play.png" alt="" class="b-img">\n' +
                                            '                    </div>\n' +
                                            '                </div>\n' +
                                            '                <p class="big-txt">'+(result.data.videoList[i].title)+'</p>'
                                        ;
                                    }
                                    el.appendChild(li, el.childNodes[0]);
                                }
                            }
                        }
                        if(result.data.length!=0){
                            pageNum++;
                        }
                    }
                });
            }else {
                $("#pullUp").remove();
            }
            myScroll.refresh();  // 数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)

        }, 1000); // <-- Simulate network congestion, remove setTimeout from production!
    }

    /**
     * 初始化iScroll控件
     */
    function loaded() {
        pullDownEl = document.getElementById('pullDown');
        pullDownOffset = pullDownEl.offsetHeight;
        pullUpEl = document.getElementById('pullUp');
        pullUpOffset = pullUpEl.offsetHeight;

        myScroll = new iScroll('wrapper', {
            scrollbarClass: 'myScrollbar', /* 重要样式 */
            useTransition: false, /* 此属性不知用意，本人从true改为false */
            topOffset: pullDownOffset,
            onRefresh: function () {
                if (pullDownEl.className.match('loading')) {
                    pullDownEl.className = '';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
                } else if (pullUpEl.className.match('loading')) {
                    pullUpEl.className = '';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                }
            },
            onScrollMove: function () {
                if (this.y > 5 && !pullDownEl.className.match('flip')) {
                    pullDownEl.className = 'flip';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始更新...';
                    this.minScrollY = 0;
                } else if (this.y < 5 && pullDownEl.className.match('flip')) {
                    pullDownEl.className = '';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
                    this.minScrollY = -pullDownOffset;
                } else if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
                    pullUpEl.className = 'flip';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始更新...';
                    this.maxScrollY = this.maxScrollY;
                } else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
                    pullUpEl.className = '';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                    this.maxScrollY = pullUpOffset;
                }
            },
            onScrollEnd: function () {
                if (pullDownEl.className.match('flip')) {
                    pullDownEl.className = 'loading';
                    pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';
                    pullDownAction(); // Execute custom function (ajax call?)
                } else if (pullUpEl.className.match('flip')) {
                    pullUpEl.className = 'loading';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';
                    pullUpAction(); // Execute custom function (ajax call?)
                }
            }
        });

        setTimeout(function () { document.getElementById('wrapper').style.left = '0'; }, 800);
    }

    //初始化绑定iScroll控件
    document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
    document.addEventListener('DOMContentLoaded', loaded, false);

</script>

