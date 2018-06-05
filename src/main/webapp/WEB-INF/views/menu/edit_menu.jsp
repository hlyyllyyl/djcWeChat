<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="/common/css/operating_record_edit.css" rel="stylesheet">
        <sf:form id="form" name="form" action="/menu/save" method="post"
                 modelAttribute="systemMenu" enctype="multipart/form-data">
        <div class="panel">
            <div class="panel-heading">
                <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
                <h3 class="panel-title">
                    <c:choose>
                        <c:when test="${isNew}">
                            系统菜单添加
                        </c:when>
                        <c:otherwise>
                            系统菜单修改
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
                            <label for="sn" style="margin-left:  29px;">菜单编号</label>
                            <sf:input type="text" id="sn" placeholder="" class="required" path="sn"/>
                        </div>
                        <div class="inline">
                            <label for="name" style="margin-left:  29px;">菜单名称</label>
                            <sf:input type="text" id="name" placeholder="" class="required" path="name"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                            <label for="icon" style="margin-left:  29px;">菜单图标</label>
                            <sf:input type="text" id="icon" placeholder="" class="required" path="icon"/>
                        </div>
                        <div class="inline">
                            <label for="url" style="margin-left:  30px;">菜单地址</label>
                            <sf:input type="text" id="url" placeholder="" class="required" path="url"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                            <label for="intro" style="margin-left:  29px;">菜单简介</label>
                            <sf:input type="text" id="intro" placeholder="" class="required" path="intro"/>
                        </div>
                        <div class="inline">
                            <label for="parent" style="margin-left:  30px;">父级菜单</label>
                            <sf:select class="selectpicker show-tick selectRow " items="${parentList}"
                                       id="parent" style=" height: 15px;width: 150px;"
                                       itemLabel="name" itemValue="id" path="parentStr">
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

        $('#parent').selectpicker({
            selectedText: 'cat',
            noneSelectedText : '请选择'//默认显示内容
        });

        $('#parent').selectpicker('val', '${parentId}');


        $('#add').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/menu/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/menu/list");
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