<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link href="/common/css/edit_teacher.css" rel="stylesheet">

<sf:form id="form" name="form" action="/employee/save" method="post"
         modelAttribute="teacher" enctype="multipart/form-data">
    <div class="panel">
        <div class="panel-heading">
            <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
            <h3 class="panel-title">
                <c:choose>
                    <c:when test="${isNew}">
                        添加老师信息
                    </c:when>
                    <c:otherwise>
                        修改老师信息
                    </c:otherwise>
                </c:choose>

            </h3>
        </div>
        <!-- BASIC FORM ELEMENTS -->
        <!--===================================================-->
        <div class="panel-body">
            <div class="row">
                <div class="ro">
                    <div class="inline">
                        <label for="realName" style="margin-left:  14px;">登录名</label>
                        <sf:input type="text" id="userName" placeholder="" class="required" path="userName"/>
                    </div>
                </div>
                <div class="ro">
                    <div class="inline">
                        <label for="realName" style="margin-left:  0px;">真实姓名</label>
                        <sf:input type="text" id="realName" placeholder="" class="required" path="realName"/>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${isNew}">
                        <div class="ro">
                            <div class="inline">
                                <label for="realName" style="margin-left:  31px;">密码</label>
                                <sf:input type="text" id="passWord" placeholder="" class="required" path="passWord"/>
                            </div>
                        </div>
                    </c:when>
                </c:choose>

                <div class="ro">
                    <div class="inline">
                        <label class="control-label" style="margin-left:  0px;">老师头像</label>
                         <sf:input type="text" id="headImg"  placeholder="" path="headImg"/>
                    </div>
                </div>
                <div class="ro">
                    <div class="inline">
                        <div align="right">
                            <span class="btn btn-primary btn-rounded btn btn-primary btn-file"> 上传...
                                  <input type="file" name="headImg" id="file" required="required">
				             </span>
                        </div>
                    </div>
                </div>
                <div class="ro">
                    <div class="inline">
                        <label class="control-label" for="employeeDetails">老师简介</label>
                        <sf:textarea path="employeeDetails" id="employeeDetails" rows="8" class="form-control"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel-footer text-center">
            <sf:input type="hidden" id="demo-text-input"
                      class="form-control" placeholder="" path="id"/>
            <button class="btn  btn-xs btn-pink btn-rounded" id="put" type="button">确定发布</button>
        </div>
    </div>
    </div>

    <!--===================================================-->
    <!-- END BASIC FORM ELEMENTS -->
    </div>
</sf:form>
<script type="text/javascript">
    $(function () {
        $('#put').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/employee/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/employee/list");
                    }else{
                        alert(result.message);
                    }
                }
            });
        })
        $('#file').on('change', function () {
            var $this = $(this);
            var formData = new FormData();
            formData.append('file', $('#file')[0].files[0]);
            var fileName = $('#file')[0].files[0].name;
            var fileType = fileName.substring(fileName.lastIndexOf('.') + 1);
            var fileSize = $('#file')[0].files[0].size;
            if (fileType != 'jpg' && fileType != 'png' && fileType != 'gif') {
                alert("请上传.jpg、.png、.gif格式的图片！");
                return;
            }
            if (fileSize > 300 * 1024) {
                alert("请上传大小小于300KB的图片！");
                return;
            }
            $.ajax({
                url: '/text/img/upload',
                type: 'POST',
                data: formData,
                cache: false,
                processData: false,
                contentType: false
            }).done(function (result) {
                if (result != '') {
                    $("#headImg").val(result);
                    /*  $this.closest('div').append('<div class="img-preview"  style="display:none;"><img src="' + result + '"/>' +
                          '           <button type="button" id="clearImg">\n' +
                          '            <img src="/common/img/clear.png" class="delete" width="100" height="100" />\n' +
                          '        </button></div>');
                      $(".img-preview").show();*/
                } else {
                    alert("请上传.jpg、.png、.gif格式的图片！");
                }
            }).fail(function () {
                alert("图片上传失败！");
            });
        })
    })
</script>