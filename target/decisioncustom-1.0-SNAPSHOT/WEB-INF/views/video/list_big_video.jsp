<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <title>${columnName}>${currentName}</title>
    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=prefixPath %>/common/js/common.js"></script>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/index.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/video-list-big.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/pullDown.css" rel="stylesheet" />
</head>
<body>
     <!-- 头部 -->
   <%--  <header class="mui-bar1 mui-bar-nav1">
         <a class="mui-icon1 mui-pull-left1"
            href="javascript:;" onClick="javascript:history.back(-1);">${columnName}>${currentName}</a>
            <a class=" mui-icon1 mui-icon-left-nav mui-pull-right1"
               href="javascript:;" onClick="javascript:history.back(-1);">返回</a>

        </header>
        <div class="list-top"></div>

    <div class="list-top"></div>--%>

    <%--上拉下拉--%>
    <div id="wrapper" style="top: 0px">
        <div id="scroller">

            <div id="pullDown">
                <span class="pullDownIcon"></span><span class="pullDownLabel">下拉刷新...</span>
            </div>

            <ul id="thelist">
            </ul>

            <div id="pullUp">
                <span class="pullUpIcon"></span><span class="pullUpLabel">上拉加载更多...</span>
            </div>

        </div>
    </div>

    <div style="height:160px;"></div>

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
    $(document).ready(function () {
        $(".jianjie").click(function () {
            $(this).toggleClass("brief");
        });
        $(".jj_v").click(function () {
            // $(".none_v").toggle();
            var a=false;
            if(a=true){
                $(".none_v").show(1000);
                console.log(a);
                a=false;
                console.log(a);
            }else if(a=false){
                $(".none_v").hide(1000);
                a=true;
                console.log(a);
            }
        });

    });
</script>
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
                    url:'<%=prefixPath %>/column/v/video/${columnId}',
                    type:'get',
                    data: {"page":downNum,"pageSize":pageSize},
                    dataType: "json",
                    async: true,
                    success:function(result){
                        console.log(result.data)
                            for (i=result.data.videoList.length-1; i>0; i--) {

                                li = document.createElement('li');
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
                                el.insertBefore(li, el.childNodes[0]);
                            }
                        if(result.data.videoList.length!=0){
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
                    url:'<%=prefixPath %>/column/v/video/${columnId}',
                    type:'get',
                    data: {"page":pageNum,"pageSize":pageSize},
                    dataType: "json",
                    async: true,
                    cache : false,
                    success:function(result){
                        console.log(result.data)
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
                        for (i=0; i<result.data.videoList.length; i++) {
                            li = document.createElement('li');
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
                            el.appendChild(li, el.childNodes[0]);
                        }
                        if(result.data.videoList.length!=0){
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

</html>