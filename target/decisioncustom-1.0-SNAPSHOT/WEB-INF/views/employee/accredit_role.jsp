<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="/common/css/edit_role.css" rel="stylesheet">
        <sf:form id="form" name="form" action="/operating_record/save" method="post"
                 modelAttribute="teacher" enctype="multipart/form-data">
        <div class="panel">
            <div class="panel-heading">
                <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
                <h3 class="panel-title">角色授权</h3>
            </div>
            <!-- BASIC FORM ELEMENTS -->
            <!--===================================================-->
            <div class="panel-body">
                <div class="row">
                    <div class="ro">
                        <div class="inline">
                            <label for="role" style="margin-left:  59px;" >赋予角色</label>
                            <sf:select class="selectpicker show-tick " data-live-search="true"
                                       items="${roleList}" itemLabel="name" multiple="true"
                                       id="role" name="role"  itemValue="id" path="roleStrs">
                            </sf:select>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="panel-footer text-center">
                    <sf:input type="hidden" id="demo-text-input"
                              class="form-control" placeholder="" path="id"/>
                    <button class="btn btn-pink btn-rounded" type="button"  id="accreditSave">保存</button>
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
        $('#role').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });
        /*回显下拉框数据*/
        var ids = '${roleIds}';
        var arr = ids.split(',');
        $('#role').selectpicker('val', arr);

        $('#accreditSave').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/employee/accredit_save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
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