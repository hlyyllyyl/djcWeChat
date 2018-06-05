<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>四川大决策投顾服务平台</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <link href="css/footer.css" rel="stylesheet" />
    <link href="css/land.css" rel="stylesheet" />
    <link href="css/mui.min.css" rel="stylesheet" />
    <script>
        $(function() {
            $("#login").click(function() {

// 处理表单验证和交给后台处理的逻辑
                var oError = document.getElementById("error_box");
                var userName = $("#username").val();
                var password = $("#password").val();
                var isNotError = true;
                if(userName==""){
                    oError.innerHTML = "用户名为空 ";
                    isNotError = false;
                    $("#username").focus();
                    return;
                }
                if(password==""){
                    oError.innerHTML = "密码为空 ";
                    isNotError = false;
                    $("#password").focus();
                    return;
                }
                $.ajax({
                    type: "POST",
                    url: "/djc/login",
                    dataType: "json",
                    data: {"username":userName,"password":password},
                    //data:dataString,
                    success: function(data){
                        if (data.success) {
                            location.href = "/djc/column/main/"+data.message;
                        }else{
                            $(".textP2").fadeIn(800).html('<p style="color: red">'+data.message+'</p>');
                        }
                    }
                });
            });
        });
        //判断是否敲击了Enter键
        $(document).keyup(function(event){
            if(event.keyCode ==13){
                $("#login").trigger("click");
            }
        });

    </script>
</head>
<body>
<%--<header class="mui-bar1 mui-bar-nav1">--%>
<%--</header>--%>
<div class="list-top"></div>
<div class="conter">
    <div class="logo">
        <img src="imgs/dl_03.png" alt="">
    </div>

    <form class="form1" method="post" id="form1" name="form1" target="_self">
      <%--<div class="land-txt">登陆</div>--%>

        <div class="inpts">
                <span class="min-img">
                    <img src="imgs/ios/sj@2x.png" alt="">
                </span>
            <span class="in">
                    <input  style="border: 0px;margin:0;padding:0;"  type="text" class="inpt" id="username" name="username" maxlength="15" value="" />
                </span>

        </div>
        <div class="txt-p"><p style="text-align:left;font-size: 12px;">请输入登录账号</p></div>
        <div class="inpts">
                <span class="min-img">
                    <img src="imgs/ios/mm@2x.png" alt="">
                </span>
            <span class="in">
                 <input style="border: 0px;margin:0;padding:0;" type="password" class="inpt" name="password" id="password" maxlength="15" value="" />
                </span>

        </div>
        <div class="txt-p"><p class="textP2" style="text-align:left;font-size: 12px;">请输入密码</p></div>

        <button id="login" class="btnn" type="button">
            登录
        </button>
     <%--   <button class="btnn" style="background:#EFEFF4;">
            <a class="zhuCe " href="/informality"  style="color:#000">
                注册
            </a>
        </button>--%>
    </form>
</div>
    <!-- 注册 -->
    <div class="zhucz_dl">
        <div class="land-txt zt_dl">获取账号方式</div>
        <div class="zy_dl">
            <div class="img_dl">
                <img src="imgs/tglg88.jpg" alt="">
            </div>
            <div class="lx_dl">
                联系电话：
                <div class="zt_2">028-87732670 &nbsp028－87732075</div>
                工作时间：
                <div class="zt_2 p_top">上午9:30-11:30 下午12:30-18:00</div>
            </div>
        </div>
    </div>
<!-- 尾部导航 -->
<div class="kk" style="height:80px;"></div>
<div class="footer"></div>

</body>
