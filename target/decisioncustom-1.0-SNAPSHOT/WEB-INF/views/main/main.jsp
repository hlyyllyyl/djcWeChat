<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>Dashboard | Nifty - Admin Template</title>
    <%--引入 css和js --%>
    <%@ include file="/WEB-INF/views/common/common.jsp"%>
    <%--引入 设置栏 --%>
    <%@ include file="/WEB-INF/views/common/set.jsp"%>
</head>
<body>
<div id="container" class="effect aside-float aside-bright mainnav-lg">
    <%--引入头部，侧边菜单栏，脚部--%>
    <%@ include file="/WEB-INF/views/common/public.jsp"%>

        <%--右侧页面数据--%>
        <div class="col-sm-12" id="right-content">
            <div class="mainbox">
                <p><video class="edui-upload-video  vjs-default-skin video-js" controls="" preload="none" width="420" height="280" src="/upload/video/20180403/1522734544382050797.mp4" data-setup="{}"></video><video class="edui-upload-video  vjs-default-skin video-js" controls="" preload="none" width="420" height="280" src="/upload/video/20180403/1522734559431096841.mp3" data-setup="{}"></video></p><p><img src="http://127.0.0.1:8080//upload/image/20180403/1522734590643084982.jpg" title="1522734590643084982.jpg"/></p><p><img src="http://127.0.0.1:8080//upload/image/20180403/1522734590656057284.jpg" title="1522734590656057284.jpg"/></p><p><br/></p>
            </div>
        </div>
</div>
</body>
</html>

