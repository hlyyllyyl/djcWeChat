<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
    <link href="/common/css/text_edit.css" rel="stylesheet">
</head>
<body>
<div id="container" class="effect aside-float aside-bright mainnav-lg">
    <%--引入头部，侧边菜单栏，脚部--%>
    <%@ include file="/WEB-INF/views/common/public.jsp"%>

    <%--右侧页面数据--%>
    <div class="col-sm-12" id="right-content">
        <div class="mainbox">
            <div class="boxed">

                <!--CONTENT CONTAINER-->
                <!--===================================================-->
                <div id="content-container">

                    <!--Page content-->
                    <!--===================================================-->
                    <sf:form id="form" name="form" action="/text/save" method="post"
                             modelAttribute="video" enctype="multipart/form-data" >
                        <div id="page-content">
                            <div class="panel">
                                <div class="panel-heading">
                                    <h3 class="panel-title">视频发布</h3>
                                </div>
                                <div class="panel-body">

                                        <%--<table id="baseInfo" width="100%" align="center" class="list" border="0"
                                               cellpadding="0" cellspacing="0">--%>
                                    <!--Text Input-->
                                    <div>
                                        <label class="col-md-3 control-label" for="demo-text-input">视频标题</label>
                                        <sf:input type="text" id="demo-text-input"  class="form-control" placeholder="" path="title"/>
                                    </div>

                                    <div>
                                        <label class="control-label" for="file">视频</label>
                                    </div>
                                    <div>
                                        <sf:input type="text" id="video" class="form-control"
                                                  placeholder="" path="videoPath"/>
                                        <div align="right">
                                <span class="btn btn-success fileinput-button">
                                        <span>上传</span>
                                    　　<input class="" type="file" name="video" id="file" required="required">
                                </span>
                                        </div>
                                    </div>
                                        <%-- <div id="demo" class="demo"></div>--%>
                                    <div>
                                        <label class="col-md-6 control-label" for="demo-text-input">视频类型</label>
                                        <sf:select class="form-control" items="${columnList}" itemLabel="name" id="selectType"
                                                   itemValue="id" path="columnId">
                                        </sf:select>
                                    </div>

                                    <div>
                                        <label class="col-md-3 control-label" for="demo-text-input">视频介绍</label>
                                        <sf:textarea path="videoIntroDetails" id="videoIntroDetails" rows="8" class="form-control"/>
                                    </div>

                                    <div>
                                    </div>

                                    <div class="panel-footer text-center">
                                        <sf:input type="hidden" id="demo-text-input"
                                                  class="form-control" placeholder="" path="id"/>
                                        <button class="btn  btn-xs btn-pink btn-rounded" id="put" type="button">确定发布</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </sf:form>
                    <!--===================================================-->
                    <!--End page content-->

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/common/js/jquery.form.js"></script>
<script type="text/javascript">
    $(function () {
         UE.delEditor('editor');
        //实例化编辑器
        var ue = UE.getEditor( 'editor', {

            autoHeightEnabled: true,

            autoFloatEnabled: true,

            initialFrameHeight:483,

            /*设置自动高度*/
            scaleEnabled:false
        });
        ue.ready(function()
        {
            ue.setContent($("#temp").val());
        });
        /*回显判断*/
        var checkValue=$("#selectType").val();
            if(checkValue==2){
                $("#originalDiv").show();
            }

            $("#selectType").change(function () {
            var checkValue=$("#selectType").val();
                if(checkValue==2){
                    $("#originalDiv").show();
                }
                if(checkValue!=2){
                    $("#originalDiv").hide();
                }
        })
        $('#file').on('change', function () {
            var $this = $(this);
            var formData = new FormData();
            formData.append('file', $('#file')[0].files[0]);
            var fileName = $('#file')[0].files[0].name;
            var fileType = fileName.substring(fileName.lastIndexOf('.') + 1);
            var fileSize = $('#file')[0].files[0].size;
            if (fileType != 'fav' && fileType != 'wmv' && fileType != 'mp4') {
                alert("请上传.fav、.wmv、.mp4格式的视频！");
                return;
            }
            /*if (fileSize > 300 * 1024) {
                alert("请上传大小小于300KB的图片！");
                return;
            }*/
            $.ajax({
                url: '/text/video/upload',
                type: 'POST',
                data: formData,
                cache: false,
                processData: false,
                contentType: false
            }).done(function (result) {
                if (result != '') {
                    $("#video").val(result);
                  /*  $this.closest('div').append('<div class="img-preview"  style="display:none;"><img src="' + result + '"/>' +
                        '           <button type="button" id="clearImg">\n' +
                        '            <img src="/common/img/clear.png" class="delete" width="100" height="100" />\n' +
                        '        </button></div>');
                    $(".img-preview").show();*/
                } else {
                    alert("请上传.fav、.wmv、.mp4格式的视频！");
                }
            }).fail(function () {
                alert("视频上传失败！");
            });
               })

        $("#put").click(function () {
            $.ajax({
                cache: false,
                type: "POST",
                url: "/video/save", //把表单数据发送到ajax.jsp
                data: $('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function (result) {
                    if (result.status == 0) {
                        alert("发布成功");
                        if (result.message == 2) {
                            goUrl("/researchResult/list");
                        } else if (result.message == 3) {
                            goUrl("/intelligenceAgencies/list");
                        }
                    } else {
                        alert(result.message);
                    }
                }
            })
        })
    })
</script>
</html>
