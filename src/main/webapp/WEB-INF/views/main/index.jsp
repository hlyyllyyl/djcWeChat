<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>四川大决策投顾服务平台</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function setHeight()
        {
            var max_height = document.documentElement.clientHeight;
            var primary = document.getElementById('mainBox');
            primary.style.minHeight = max_height+"px";
            primary.style.maxHeight = max_height+"px";
        }
    </script>
</head>
<style>
    body{
        margin: 0px;
        padding: 0px;
    }
    .mainBox{
        width: 100%;
        background: url("${advertising.imgPath}") no-repeat;
        background-size: 100% 100%;
        overflow: hidden;
    }
    .mainBox:after{
        content: "";
        display: block;
        padding-top: 160%;
    }
.cell{
    float: right;
    margin-right: 15px;
    margin-top: 20px;

}

</style>
<body onload="setHeight();" onresize=" setHeight()">
    <a href="/advertising/article${advertising.id}">
        <div class="mainBox" id="mainBox">
            <div class="cell">
                <a href="/djc/weChat/login" style="color:#fff;text-decoration:none;">跳过&nbsp;</a><h7 style=color:red><span id=jump>4</span></h7>
            </div>
        </div>
    </a>
</body>
<script type="text/javascript" charset="utf-8">
    setTimeout(function(){window.location="/djc/weChat/login";},4000);
    function countDown(secs){
        jump.innerText=secs;
        if(--secs>-1)
            setTimeout("countDown("+secs+" )",1000);
    }
    countDown(3);
</script>