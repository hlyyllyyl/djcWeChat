<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="/common/css/edit_role.css" rel="stylesheet">
        <sf:form id="form" name="form" action="/operating_record/save" method="post"
                 modelAttribute="role" enctype="multipart/form-data">
        <div class="panel">
            <div class="panel-heading">
                <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
                <h3 class="panel-title">
                    <c:choose>
                        <c:when test="${isNew}">
                            角色添加
                        </c:when>
                        <c:otherwise>
                            角色修改
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
                            <label for="name" style="margin-left:  29px;">角色名称</label>
                            <sf:input type="text" id="name" placeholder="" class="required" path="name"/>
                        </div>
                        <div class="inline">
                            <label for="sn" style="margin-left:  29px;">角色标识</label>
                            <sf:input type="text" id="sn" placeholder="" class="required" path="sn"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                            <label for="permission" style="margin-left:  59px;" >权限</label>
                            <sf:select class="selectpicker show-tick " data-live-search="true"
                                       items="${permissionList}" itemLabel="name" multiple="true"
                                       id="permission" name="permission"  itemValue="id" path="permissionStrs">
                            </sf:select>
                        </div>
                    </div>
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
            </div>
        </div>

        <!--===================================================-->
        <!-- END BASIC FORM ELEMENTS -->
    </div>
    </sf:form>
<script type="text/javascript">
    $(function () {

        /*select 下拉多选*/
        $('#permission').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        /*回显下拉框数据*/
        var ids = '${permissionIds}';
        var arr = ids.split(',');
        $('#permission').selectpicker('val', arr);

        $('#add').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/role/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/role/list");
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