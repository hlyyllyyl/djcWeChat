<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=prefixPath %>/common/js/common.js"></script>
    <script src="<%=prefixPath %>/js/mui.min.js"></script>
    <link href="<%=prefixPath %>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/blend.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/pullDown.css" rel="stylesheet" />
    <title>${columnName}>${currentName}</title>
</head>
<body>
<!-- 头部 -->
<%--<header class="mui-bar1 mui-bar-nav1">
    <a class="mui-icon1 mui-pull-left1"
       href="javascript:;" onClick="javascript:history.back(-1);">${columnName}>${currentName}</a>
    <a class=" mui-icon1 mui-icon-left-nav mui-pull-right1"
       href="javascript:;" onClick="javascript:history.back(-1);"></a>
</header>--%>
<%--<div class="list-top"></div>--%>

<%--上拉下拉--%>
<div id="wrapper" style="top: 0px;" >
    <div id="scroller">

        <div id="pullDown">
            <span class="pullDownIcon"></span><span class="pullDownLabel">下拉刷新...</span>
        </div>
        <div class="mui-content">
                <ul class="blend_u" id="thelist">
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
                            if(result.data.articleList[i].top==1){
                                li.innerHTML ='  <div class="mui-card">\n' +
                                    '                            <div class="mui-card-header mui-card-media">\n' +
                                    '                                <a  href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                    '                                    <div class="title_t">\n' +
                                    '                                            '+(result.data.articleList[i].title)+'\n' +
                                    '                                    </div>\n' +
                                    '                                </a>\n' +
                                    '                            </div>\n' +
                                    '                            <div class="mui-card-content">\n' +
                                    '                                <a  href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                    '                                    <img src="${contentPath}'+(result.data.articleList[i].titleImg)+'" alt="" width="100%">\n' +
                                    '                                </a>\n' +
                                    '                            </div>\n' +
                                    '                            <div class="mui-card-footer2">\n' +
                                    '                                <a  href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                    '                                    <p class="p_width2"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>'+(result.data.articleList[i].articleIntro)+'</p>\n' +
                                    '                                </a>\n' +
                                    '                                <div class="right-3">\n' +
                                    '                    <span class="time">\n' +
                                    '                      '+(result.data.articleList[i].createTimeStr)+'\n' +
                                    '                    </span>\n' +
                                    '\n' +
                                    '                                    <span class="liulan">\n' +
                                    '                        <img src="<%=prefixPath %>/imgs/ios/17@2x.png">\n' +
                                    '                        <span class="mun">'+(result.data.articleList[i].readingQuantity)+'</span>\n' +
                                    '                    </span>\n' +
                                    '                                    <span class="dianZhan">\n' +
                                    '                        <a href="javascript:void(0)"  onclick=\'thumbUp('+(result.data.articleList[i].id)+')\'>\n' +
                                    '                              <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />'+(result.data.articleList[i].thumbUpQuantity)+'\n' +
                                    '                        </a>\n' +
                                    '                    </span>\n' +
                                    '                                <p>\n' +
                                    '                            </div>\n' +
                                    '                        </div>';
                            }else {
                                li.innerHTML ='  <a  href="<%=prefixPath %>/article/article?id='+(result.data.articleList[i].id)+'">\n' +
                                    '                                    <img class=" mui-media-object mui-pull-left xmb_img" src="${contentPath}'+(result.data.articleList[i].titleImg)+'">\n' +
                                    '                                    <div class="mui-media-body chaochu">\n' +
                                    '                                        <div style="color: black;font-weight: bold;">\n' +
                                    '                                            '+(result.data.articleList[i].title)+'\n' +
                                    '                                        </div>\n' +
                                    '                                        <p class="zt_2">'+(result.data.articleList[i].articleIntro)+'</p>\n' +
                                    '                                    </div>\n' +
                                    '                                </a>\n' +
                                    '                                <div class="right-3 xiaomb">\n' +
                                    '                        <span class="time">\n' +
                                    '                           '+(result.data.articleList[i].createTimeStr)+'\n' +
                                    '                        </span>\n' +
                                    '\n' +
                                    '                                    <span class="liuLan">\n' +
                                    '                                      <img src="<%=prefixPath %>/imgs/ios/17@2x.png" alt="" />'+(result.data.articleList[i].readingQuantity)+'\n' +
                                    '                                    </span>\n' +
                                    '                                    <span class="dianZhan">\n' +
                                    '                                        <a href="javascript:void(0)"  onclick=\'thumbUp('+(result.data.articleList[i].id)+')\'>\n' +
                                    '                                              <img src="<%=prefixPath %>/imgs/ios/d@2x.png" alt="" />'+(result.data.articleList[i].thumbUpQuantity)+'\n' +
                                    '                                        </a>\n' +
                                    '                                    </span>\n' +
                                    '                                </div>';
                            }
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
            var el, li, i,cl,ci;
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
                                    if(result.data.articleList[i].children[j].id!=null){
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
