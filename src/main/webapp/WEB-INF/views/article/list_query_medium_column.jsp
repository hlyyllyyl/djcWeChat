<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>四川大决策投顾服务平台</title>
    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=prefixPath %>/common/js/common.js"></script>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <link href="<%=prefixPath %>/css/index.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/pullDown.css" rel="stylesheet" />
</head>
<body>    

     <!-- 搜索框 -->
     <div class="inpt">
         <h2 style="text-align:center; margin-top:20px;border-radius:50%;"></h2>
         <div class="style_1">
             <form method="get" id="searchform" action="<%=prefixPath %>/article/query">
                 <fieldset>
                     <input  type="submit" value />
                     <input id="s" name="q" type="text" value="股票、标题、作者" class="text_input" onblur="if(this.value==''){this.value='股票、标题、作者';}"
                            onfocus="if(this.value =='股票、标题、作者'){this.value='';}" />
                 </fieldset>
             </form>
         </div>
     </div>

        <div class="list-top"></div>
        <%--上拉下拉--%>
        <div id="wrapper" style="top: 30px">
            <div id="scroller">

                <div id="pullDown">
                    <span class="pullDownIcon"></span><span class="pullDownLabel">下拉刷新...</span>
                </div>

                <ul id="thelist">
                </ul>

                <div id="pullUp">
                    <span class="pullUpIcon"></span><span class="pullUpLabel">上拉加载更多...</span>
                </div>
		
		<div class="spinner" id="spinner">
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
        <div style="height:80px;"></div>

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
                         <img src="${contentPath}${item.imgPath}" alt="">
                         <c:if test="${item.name!=''||item.name!=null}">
                             <p class="zt">${item.name}</p>
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
            if($("#bottom").length<=0){
                $.ajax({
                    url:'<%=prefixPath %>/article/v/query?q=${q}',
                    type:'get',
                    data: {"page":pageNum,"pageSize":pageSize},
                    dataType: "json",
                    async: false,
                    success:function(result){
                        /*console.log(result.data)*/
                        for (i=0; i<result.data.articleList.length; i++) {
                            li = document.createElement('li');
                            li.innerHTML =
                                '                            <div class="list-left">\n' +
                                '                            <a href="<%=prefixPath %>/article/queryArticle?id='+(result.data.articleList[i].id)+'&q=${q}"><img src="${contentPath}'+(result.data.articleList[i].titleImg)+'" alt=""></a>\n' +
                                '                            </div>\n' +
                                '                            <div class="list-right">\n' +
                                '                            <p class="right-title">\n' +
                                '                            <a class="zt-a" href="<%=prefixPath %>/article/queryArticle?id='+(result.data.articleList[i].id)+'&q=${q}'+'">'+(result.data.articleList[i].title)+'</a>\n' +
                                '                            </p>\n' +
                                '                            <p class="right-txt co_txt" >'+(result.data.articleList[i].articleIntro)+'</p>\n' +
                                '                            <div class="right-3 co_3">\n' +
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
                                '                            </div>\n'
                            ;
                            el.insertBefore(li, el.childNodes[0]);
                        }
                    }
                });
            }
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
                    url:'<%=prefixPath %>/article/v/query?q=${q}',
                    type:'get',
                    data: {"page":pageNum,"pageSize":pageSize},
                    dataType: "json",
                    async: false,
                    success:function(result){
                        /*console.log(result.data)*/
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
                            li.innerHTML =
                                '                            <div class="list-left">\n' +
                                '                            <a href="<%=prefixPath %>/article/queryArticle?id='+(result.data.articleList[i].id)+'&q=${q}"><img src="${contentPath}'+(result.data.articleList[i].titleImg)+'" alt=""></a>\n' +
                                '                            </div>\n' +
                                '                            <div class="list-right">\n' +
                                '                            <p class="right-title">\n' +
                                '                            <a class="zt-a" href="<%=prefixPath %>/article/queryArticle?id='+(result.data.articleList[i].id)+'&q=${q}">'+(result.data.articleList[i].title)+'</a>\n' +
                                '                            </p>\n' +
                                '                            <p class="right-txt" >'+(result.data.articleList[i].articleIntro)+'</p>\n' +
                                '                            <div class="right-3">\n' +
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
                                '                            </div>\n'
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
                $("#spinner").remove();
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