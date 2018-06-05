<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="/common/css/operating_record_edit.css" rel="stylesheet">
        <sf:form id="form" name="form" action="/workFlow/newDeploy" method="post"
                 modelAttribute="activitiPojo" enctype="multipart/form-data">
        <div class="panel">
            <div class="panel-heading">
                <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
                <h3 class="panel-title">
                            权限添加
                </h3>
            </div>
            <!-- BASIC FORM ELEMENTS -->
            <!--===================================================-->
            <div class="panel-body">
                <div class="row">
                    <div class="ro">
                        <div class="inline">
                            <label for="name" style="margin-left:  29px;">部署名称</label>
                            <sf:input type="text" id="name" placeholder="" class="required" path="name"/>
                        </div>
                        <div class="inline">
                            <label for="processFile" style="margin-left:  29px;">部署文件</label>
                            <sf:input type="file" id="processFile" placeholder="" class="required" path="processFile"/>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="panel-footer text-center">
                    <button class="btn btn-pink btn-rounded" type="submit"  id="add">
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
            </div>
        </div>

        <!--===================================================-->
        <!-- END BASIC FORM ELEMENTS -->
    </div>
    </sf:form>
<script type="text/javascript">
    $(function () {

        /*select 下拉多选*/
        $('#demo-cs-serviceManList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        /*select 下拉多选*/
        $('#demo-cs-customerList').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        $('#adviser').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        /*回显下拉框数据*/
        var ids = '${ids}';
        var arr = ids.split(',');
        $('#demo-cs-serviceManList').selectpicker('val', arr);

        var customerIds = '${customerIds}';
        var arrs = customerIds.split(',');
        $('#demo-cs-customerList').selectpicker('val', arrs);

        $('#adviser').selectpicker('val', '${adviserId}');



        $('#add').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/workFlow/newDeploy", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("部署成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/workFlow/personalTask/index");
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