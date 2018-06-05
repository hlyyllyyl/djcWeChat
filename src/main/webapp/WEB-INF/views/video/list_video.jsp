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

    <title>四川大决策投顾服务平台</title>
    <script src="<%=prefixPath %>/js/jquery-3.3.1.js"></script>
    <script src="<%=prefixPath %>/common/js/common.js"></script>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/index.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/video-list.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/pullDown.css" rel="stylesheet" />
</head>
<body>
     <!-- 头部 -->
     <header class="mui-bar1 mui-bar-nav1">
         <a class="mui-icon1 mui-pull-left1"
            href="javascript:;" onClick="javascript:history.back(-1);">${columnName}>${currentName}</a>
            <a class=" mui-icon1 mui-icon-left-nav mui-pull-right1"
               href="javascript:;" onClick="javascript:history.back(-1);">返回</a>

        </header>
        <div class="list-top"></div>

    <div class="list-top"></div>

    <%--上拉下拉--%>
    <div id="wrapper" style="top: 28px">
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
                            for (i=result.data.length-1; i>0; i--) {

                                li = document.createElement('li');
                                li.innerHTML ='<input type="hidden" id="column" name="1">\n' +
                                    '                    <div class="list-left_v">\n' +
                                    '                            <a href="<%=prefixPath %>/video/video?id='+(result.data[i].id)+'">' +
                                    '                               <img src="${contentPath}'+(result.data[i].thumbnailPath)+'" alt="">' +
                                    '                            </a>\n' +
                                    '                        <p class="v_time">'+(result.data[i].videoDuration)+'</p>\n' +
                                    '                    </div>\n' +
                                    '                    <div class="list-right_v">\n' +
                                    '                        <p class="right-title_v">\n' +
                                    '                            <a class="zt-a_v" href="<%=prefixPath %>/video/video?id='+(result.data[i].id)+'">'+(result.data[i].title)+'</a>\n' +
                                    '                        </p>\n' +
                                    '                        <p class="right-txt_v zmb_txt_v">\n' +
                                    '                            <a class="zt-a2_v" href="<%=prefixPath %>/video/video?id='+(result.data[i].id)+'">播放次数：'+(result.data[i].playQuantity)+'</a>\n' +
                                    '                        </p>\n' +
                                    '                        <div class="zmb_3_v">\n' +
                                    '                            <span class="time_v">\n' +
                                    '                                '+(result.data[i].createTimeStr)+'\n' +
                                    '                            </span>\n' +
                                    '                            <span class="dianZhan_v">\n' +
                                    '                                <a href="javascript:void(0)" onclick="thumbUp('+(result.data[i].id)+')">\n' +
                                    '                                    <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="">'+(result.data[i].thumbUpQuantity)+'\n' +
                                    '                                </a>\n' +
                                    '                            </span>\n' +
                                    '                        </div>\n' +
                                    '                    </div>'
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
            var el, li, i;
            el = document.getElementById('thelist');
            $.ajax({
                url:'<%=prefixPath %>/column/v/video/${columnId}',
                type:'get',
                data: {"page":pageNum,"pageSize":pageSize},
                dataType: "json",
                async: true,
                cache : false,
                success:function(result){
                    console.log(result.data)
                        for (i=0; i<result.data.length; i++) {
                            li = document.createElement('li');
                            li.innerHTML =
                                '<input type="hidden" id="column" name="1">\n' +
                                '                    <div class="list-left_v">\n' +
                                '                            <a href="<%=prefixPath %>/video/video?id='+(result.data[i].id)+'">' +
                                '                               <img src="${contentPath}'+(result.data[i].thumbnailPath)+'" alt="">' +
                                '                            </a>\n' +
                                '                        <p class="v_time">'+(result.data[i].videoDuration)+'</p>\n' +
                                '                    </div>\n' +
                                '                    <div class="list-right_v">\n' +
                                '                        <p class="right-title_v">\n' +
                                '                            <a class="zt-a_v" href="<%=prefixPath %>/video/video?id='+(result.data[i].id)+'">'+(result.data[i].title)+'</a>\n' +
                                '                        </p>\n' +
                                '                        <p class="right-txt_v zmb_txt_v">\n' +
                                '                            <a class="zt-a2_v" href="<%=prefixPath %>/video/video?id='+(result.data[i].id)+'">播放次数：'+(result.data[i].playQuantity)+'</a>\n' +
                                '                        </p>\n' +
                                '                        <div class="zmb_3_v">\n' +
                                '                            <span class="time_v">\n' +
                                '                                '+(result.data[i].createTimeStr)+'\n' +
                                '                            </span>\n' +
                                '                            <span class="dianZhan_v">\n' +
                                '                                <a href="javascript:void(0)" onclick="thumbUp('+(result.data[i].id)+')">\n' +
                                '                                    <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="">'+(result.data[i].thumbUpQuantity)+'\n' +
                                '                                </a>\n' +
                                '                            </span>\n' +
                                '                        </div>\n' +
                                '                    </div>'
                            ;
                            el.appendChild(li, el.childNodes[0]);
                        }
                    if(result.data.length!=0){
                        pageNum++;
                    }
                }
            });

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