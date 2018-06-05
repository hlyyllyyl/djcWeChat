<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<link href="/common/css/edit_user.css" rel="stylesheet">
<div class="boxed">

    <!--CONTENT CONTAINER-->
    <!--===================================================-->
    <div id="content-container">

        <!--Page content-->
        <!--===================================================-->
    <sf:form id="form" name="form" action="/text/upload" method="get"
         modelAttribute="text" enctype="multipart/form-data" >
        <div id="page-content" style="width: 1200px">
           <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title">文章发布</h3>
                </div>
                <div class="panel-body">
                    <table id="baseInfo" width="100%" align="center" class="list" border="0"
                           cellpadding="0" cellspacing="0">
                        <!--Text Input-->
                        <tr>
                            <label class="col-md-3 control-label" for="demo-text-input">文章标题</label>
                                <sf:input type="text" id="demo-text-input"  class="form-control" placeholder="" path="title"/>
                        </tr>
                        <tr>
                            <label class="col-md-3 control-label" for="demo-text-input">文章类型</label>
                                <sf:select class="form-control" items="${textType}" itemLabel="textType" id="selectType"
                                          itemValue="id" path="textType">
                                </sf:select>
                        </tr>
                        <tr>
                            <div class="form-group" id="originalDiv" style="display:none;">
                                <label class="col-md-3 control-label" for="demo-text-input">是否原创</label>
                                <div>
                                    <sf:select path="original" class="form-control" id="team">
                                        <sf:option value="1">原创</sf:option>
                                        <sf:option value="0">非原创</sf:option>
                                    </sf:select>
                                </div>
                            </div>
                        </tr>
                        <tr>
                            <label class="col-md-3 control-label" for="demo-text-input">标题图片</label>
                            <sf:input type="file" id="demo-text-input"  multiple="multiple"
                                      class="form-control" placeholder="" path="titleImg"/>
                        </tr>
                        <tr>
                            <input id='temp' type='hidden'  value='${text.editorValue}' />
                        </tr>
                    <!--Summernote-->
                    <!--===================================================-->
                    <div>
                        <script id="editor" type="text/plain"></script>
                    </div>
                    <!--===================================================-->
                    <!-- End Summernote -->
                    </table>
                    <div class="panel-footer text-center">
                        <sf:input type="hidden" id="demo-text-input"
                                  class="form-control" placeholder="" path="id"/>
                        <button class="btn btn-pink btn-rounded" id="put" type="button">确定发布</button>
                    </div>
                </div>
            </div>
        </div>
    </sf:form>
        <!--===================================================-->
        <!--End page content-->

    </div>
</div>
<script type="text/javascript">
    $(function () {

         UE.delEditor('editor');
        //实例化编辑器
        var ue = UE.getEditor( 'editor', {

            autoHeightEnabled: true,

            autoFloatEnabled: true,

            initialFrameWidth: 1130,

            initialFrameHeight:483
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

        $("#put").click(function () {
            $.ajax({
                cache: false,
                type: "GET",
                url:"/text/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                contentType:"application/x-www-form-urlencoded",
                success: function(result) {
                    if(result.status==0){
                        alert("发布成功");
                        if(result.message=2){
                            turnpage("/researchResult/list");
                        }else if (result.message=3){
                            turnpage("/intelligenceAgencies/list");
                        }
                    }else{
                        alert(result.message);
                    }
                }
            })
        })
    })
</script>
