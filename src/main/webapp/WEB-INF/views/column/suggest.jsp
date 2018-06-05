<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String prefixPath ="/djc"; %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>我的建议</title>
    <script src="<%=prefixPath %>/js/jquery-1.8.3.min.js"></script>
    <link href="<%=prefixPath %>/css/footer.css" rel="stylesheet" />
    <link href="<%=prefixPath %>/css/ask.css" rel="stylesheet" />
</head>
<body>
<%--<header class="mui-bar1 mui-bar-nav1">
    <a class="mui-icon1 mui-pull-right1">
        <a class="mui-icon1 mui-pull-right1" href="<%=prefixPath %>/column/main/我的">返回</a>
    </a>
    <h1 class="mui-title1">我的建议</h1>
    <a class="mui-btn1 mui-btn-link1 mui-pull-right1 mui-btn-blue1 mui-disabled1">...</a>
</header>

<div class="list-top"></div>--%>
<div class="body">
    <a href="#DD" ><button id="btn" type="button" style="display: none"></button></a><%--跳到id为DD的锚点--%>
    <ul id="save" class="content_1">
        <li class="left">
            <img class="name name_left" src="<%=prefixPath %>/imgs/ios/tycb2@2x.png" alt="photo">
            <div class="mainInfo_left">
                <div class="userId_left">
                    <a href="#">
                        大决策客服
                    </a>
                </div>
                <div class="conInfo">
                    <p>
                        四川大决策帮助用户提供正规的股票选择的平台, 有什么问题,随时为你解答给你提供贴心的一 对一服务,也可以留下你的手机号或者微信号码 我将安排人员给你回电详细为你解答。
                    </p>
                </div>
                <div class="time_left">
                    2018-04-23 17:46
                </div>
            </div>
        </li>
        <li class="left">
            <img class="name name_left" src="<%=prefixPath %>/imgs/ios/tycb2@2x.png" alt="photo">
            <div class="mainInfo_left">
                <div class="userId_left">
                    <a href="#">
                        大决策客服
                    </a>
                </div>
                <div class="conInfo">
                    <p>
                        请问您有什么要咨询的吗？？
                    </p>
                </div>
                <div class="time_left">
                    2018-04-23 18:00
                </div>
            </div>
        </li>
        <c:forEach items="${leaveWordsList}" var="item">
    <c:if test="${item.teacherId!=0 && item.customerId==customerId}">
        <li class="left">
            <img class="name name_left" src="<%=prefixPath %>/imgs/ios/tycb2@2x.png" alt="photo">
            <div class="mainInfo_left">
                <div class="userId_left">
                    <a href="#">
                        大决策客服
                    </a>
                </div>
                <div class="conInfo">
                    <p>${item.leaveText}</p>
                </div>
                <div class="time_left">
                    <fmt:formatDate value="${item.leaveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </div>
            </div>
        </li>
    </c:if>

    <c:if test="${item.teacherId==0 && item.customerId==customerId}">
    <div class="mainframe">
        <div class="msgFrame">
            <ul class="content_1">
                        <li class="right">
                            <img class="name" src="${item.customer.wxHeadImg}" alt="photo">
                            <div class="mainInfo">
                                <div class="userId">
                                    <a href="#"></a>
                                </div>
                                <div class="conInfo">
                                    <p>${item.leaveText}</p>
                                </div>
                                <div class="time">
                                    <fmt:formatDate value="${item.leaveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </div>
                            </div>
                        </li>
            </ul>
        </div>
    </div>
    </c:if>

</c:forEach>
    </ul>
</div>
<a id='DD' >&nbsp;</a>
<div class="shuRu">
    <input name="textfield" type="text" value="请输入您想咨询的内容" class="input_1" id="leaveText"
           onfocus="if (value =='请输入您想咨询的内容'){value =''}"onblur="if (value ==''){value='请输入您想咨询的内容'}"/>
    <input type="button" name="submit" value="发表" id="add" class="subbtn">
</div>
<div class="hei" style="height:45px;"></div>
</body>
<script type="text/javascript">
    $('#add').click( function () {
        var leaveText = $("#leaveText").val();
        if(leaveText=='请输入您想咨询的内容'){
            alert("请输入咨询内容!")
            return;
        }
        $.ajax({
            cache: false,
            type: "get",
            url:"<%=prefixPath %>/leave_words/save", //把表单数据发送到ajax.jsp
            data: {"leaveText":leaveText},
            async: false,
            success: function(result) {
                    location.reload();
            }
        });
    });
    $(function () {
        $('#btn').trigger("click");
    })
</script>