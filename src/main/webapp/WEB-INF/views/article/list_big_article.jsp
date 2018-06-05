<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <title>${columnName}>${currentName}</title>
    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=prefixPath %>/common/js/common.js"></script>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <!--标准mui.css-->
    <link href="<%=prefixPath %>/css/big_list.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/pullDown.css" rel="stylesheet" />
</head>
<body>
<%--<header class="mui-bar1 mui-bar-nav1">
    <a class="mui-icon1 mui-pull-left1"
       href="javascript:;" onClick="javascript:history.back(-1);">${columnName}>${currentName}</a>
    <a class=" mui-icon1 mui-icon-left-nav mui-pull-right1"
       href="javascript:;" onClick="javascript:history.back(-1);">返回</a>

</header>
<div class="hei" style="height:45px;"></div>--%>

<%--上拉下拉--%>
<div id="wrapper" style="top: 0px;">
    <div id="scroller">

        <div id="pullDown">
            <span class="pullDownIcon"></span>
            <span class="pullDownLabel">下拉刷新...</span>
        </div>
        <div class="mui-content">
            <ul id="thelist" class="big_list">

            </ul>
        </div>
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
<div class="f-div" style="height:48px;"></div>

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
<script type="application/javascript" src="<%=prefixPath %>/js/iscroll.js"></script>
<script type="text/javascript">
    $(function(){
        pullUpAction();
    });
    var myScroll,
        pullDownEl, pullDownOffset,
        pullUpEl, pullUpOffset,
        generatedCount = 0;

    var pageNum = 1;
    var downNum =0;
    var pageSize = 6;
    /**
     * 下拉刷新 （自定义实现此方法）
     * myScroll.refresh();  // 数据加载完成后，调用界面更新方法
     */
    function pullDownAction () {
        setTimeout(function () { // <-- Simulate network congestion, remove setTimeout from production!
            var el, li, i;
            el = document.getElementById('thelist');
                $.ajax({
                    url:'<%=prefixPath %>/column/v/article/${columnId}',
                    type:'get',
                    data: {"page":downNum,"pageSize":pageSize},
                    dataType: "json",
                    async: false,
                    success:function(result){
                        /*console.log(result.data)*/
                        for (i=result.data.articleList.length-1; i>0; i--) {
                            li = document.createElement('li');
                            li.innerHTML =' <div class="mui-card">\n' +
                                '                        <div class="mui-card-header mui-card-media">\n' +
                                '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                '                                <div class="title-txt">\n' +
                                '                                        '+(result.data.articleList[i].title)+'\n' +
                                '                                </div>\n' +
                                '                                <div class="mui-card-content">\n' +
                                '                                    <img src="${contentPath}'+(result.data.articleList[i].titleImg)+'" alt="" width="100%">\n' +
                                '                                </div>\n' +
                                '                            </a>\n' +
                                '                            <div class="mui-card-footer2">\n' +
                                '                                <p class="p_width2">\n' +
                                '                                    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n' +
                                '                                        '+(result.data.articleList[i].articleIntro)+'\n' +
                                '                                </p>\n' +
                                '                                <div class="big_bottom">\n' +
                                '                                    <span class="time">\n' +
                                '                           '+(result.data.articleList[i].createTimeStr)+'\n' +
                                '                                    </span>\n' +
                                '                                        <span class="liulan_da">\n' +
                                '                                          <img src="<%=prefixPath %>/imgs/ios/17@2x.png">\n' +
                                '                                             <span class="mun">'+(result.data.articleList[i].readingQuantity)+'</span>\n' +
                                '                                       </span>\n' +
                                '    \n' +
                                '                                        <span class="dianZhan_da">\n' +
                                '                                            <a href="javascript:void(0)"  onclick=\'thumbUp('+(result.data.articleList[i].id)+')\'>\n' +
                                '                                                  <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />'+(result.data.articleList[i].thumbUpQuantity)+'\n' +
                                '                                            </a>\n' +
                                '                                        </span>\n' +
                                '                                </div>\n' +
                                '                            </div>\n' +
                                '                        </div>\n' +
                                '                    </div>'
                            ;
                            el.insertBefore(li, el.childNodes[0]);
                        }
                        if(result.data.articleList.length!=0){
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
            var el, li, i;
            el = document.getElementById('thelist');
            if($("#bottom").length<=0){
                $.ajax({
                    url:'<%=prefixPath %>/column/v/article/${columnId}',
                    type:'get',
                    data: {"page":pageNum,"pageSize":pageSize},
                    dataType: "json",
                    async: false,
                    success:function(result){
                       /* console.log(result.data)*/
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
                        for (i=0; i<result.data.articleList.length; i++) {
                            li = document.createElement('li');
                            li.innerHTML =' <div class="mui-card">\n' +
                                '                        <div class="mui-card-header mui-card-media">\n' +
                                '                            <a href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                '                                <div class="title-txt">\n' +
                                '                                        '+(result.data.articleList[i].title)+'\n' +
                                '                                </div>\n' +
                                '                                <div class="mui-card-content">\n' +
                                '                                    <img src="${contentPath}'+(result.data.articleList[i].titleImg)+'" alt="" width="100%">\n' +
                                '                                </div>\n' +
                                '                            </a>\n' +
                                '                            <div class="mui-card-footer2">\n' +
                                '                                <p class="p_width2 big_p">\n' +
                                '                                    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <a style="color:#999" href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                '                                        '+(result.data.articleList[i].articleIntro)+'\n' +
                                '                                </a></p>\n' +
                                '                                <p class="p_width">\n' +
                                '                                    <span class="time">\n' +
                                '                           '+(result.data.articleList[i].createTimeStr)+'\n' +
                                '                                    </span>\n' +
                                '                                        <span class="liulan_da">\n' +
                                '                                          <img src="<%=prefixPath %>/imgs/ios/17@2x.png">\n' +
                                '                                             <span class="mun">'+(result.data.articleList[i].readingQuantity)+'</span>\n' +
                                '                                       </span>\n' +
                                '    \n' +
                                '                                        <span class="dianZhan_da">\n' +
                                '                                            <a href="javascript:void(0)"  onclick=\'thumbUp('+(result.data.articleList[i].id)+')\'>\n' +
                                '                                                  <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />'+(result.data.articleList[i].thumbUpQuantity)+'\n' +
                                '                                            </a>\n' +
                                '                                        </span>\n' +
                                '                                </p>\n' +
                                '                            </div>\n' +
                                '                        </div>\n' +
                                '                    </div>'
                            ;
                            el.appendChild(li, el.childNodes[0]);
                        }
                        if(result.data.articleList.length!=0){
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