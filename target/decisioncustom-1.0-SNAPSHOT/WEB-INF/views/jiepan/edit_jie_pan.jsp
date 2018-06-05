<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="/common/css/operating_log_edit.css" rel="stylesheet">
<body>
<sf:form id="form" name="form" action="/user/edit" method="post"
         modelAttribute="jiePan" enctype="multipart/form-data">
<div class="panel">
    <div class="panel-heading">
        <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
        <h3 class="panel-title">
            <c:choose>
                <c:when test="${isNew}">
                    添加名师解盘
                </c:when>
                <c:otherwise>
                    修改名师解盘
                </c:otherwise>
            </c:choose>

        </h3>
    </div>
    <!-- BASIC FORM ELEMENTS -->
    <!--===================================================-->
    <div class="panel-body">
            <div class="row">
               <%-- <div class="inline">
                    <label class="" for="top">是否置顶</label>
                    <sf:select path="top" id="top">
                        <sf:option value="-1">请选择</sf:option>
                        <sf:option value="1">是</sf:option>
                        <sf:option value="0">否</sf:option>
                    </sf:select>
                </div>--%>
                <div>
                    <label class="control-label" for="text">解盘内容</label>
                    <sf:textarea path="text" id="text" class="form-control" rows="8"/>
                </div>
            </div>
        <div class="panel-footer text-center">
            <sf:input type="hidden" id="demo-text-input"
                      class="form-control" placeholder="" path="id"/>
            <button class="btn btn-pink btn-rounded" type="button"  id="add">
                <c:choose>
                    <c:when test="${isNew}">
                        保存
                    </c:when>
                    <c:otherwise>
                        修改
                    </c:otherwise>
                </c:choose>
            </button>
            <button class="btn btn-info btn-rounded" type="button" id="cancel" >取消</button>
        </div>
    <!--===================================================-->
    <!-- END BASIC FORM ELEMENTS -->
</div>
</sf:form>
</body>
<script type="text/javascript">
    $(function () {
        $('#add').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/jie_pan/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/jie_pan/list");
                    }else{
                        alert(result.message);
                    }
                }
            });
        })
        /*取消跳回原页面*/
        $('#cancel').click( function () {
            $('#modelInfo').modal('hide');
        })
    })
</script>
</html>
