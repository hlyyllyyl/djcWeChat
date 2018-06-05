<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="/common/css/operating_record_edit.css" rel="stylesheet">
        <sf:form id="form" name="form" action="/operating_record/save" method="post"
                 modelAttribute="permission" enctype="multipart/form-data">
        <div class="panel">
            <div class="panel-heading">
                <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
                <h3 class="panel-title">
                    <c:choose>
                        <c:when test="${isNew}">
                            权限添加
                        </c:when>
                        <c:otherwise>
                            权限修改
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
                            <label for="name" style="margin-left:  29px;">权限名称</label>
                            <sf:input type="text" id="name" placeholder="" class="required" path="name"/>
                        </div>
                        <div class="inline">
                            <label for="descs" style="margin-left:  29px;">权限描述</label>
                            <sf:input type="text" id="descs" placeholder="" class="required" path="descs"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                            <label for="resource" style="margin-left:  29px;">权限地址</label>
                            <sf:input type="text" id="resource" placeholder="" class="required" path="resource"/>
                        </div>
                        <div class="inline">
                            <label for="sn" style="margin-left:  55px;">权限</label>
                            <sf:input type="text" id="sn" placeholder="" class="required" path="sn"/>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="panel-footer text-center">
                    <sf:input type="hidden" id="demo-text-input"
                              class="form-control" placeholder="" path="id"/>
                    <sf:input type="hidden" id="demo-text-input"
                              class="form-control" placeholder="" path="menu_id"/>
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

        $("form :input").blur(function(){
            //失去焦点处理函数
            var $parent = $(this).parent();
            $parent.find(".msg").remove(); //删除以前的提醒元素（find()：查找匹配元素集中元素的所有匹配元素）

            //验证卖出数量
            if($(this).is("#stockCode")){
                $.ajax({
                    cache: false,
                    type: "GET",
                    url:"/operating_record/refreshStockPrice", //把表单数据发送到ajax.jsp
                    data:{
                        stockCode :$("#stockCode").val()
                    }, //要发送的是ajaxFrm表单中的数据
                    async: false,
                    dataType: "json",
                    success: function(result) {
                            $("#stockName").val(result.data.stockName);
                            $("#latestClosingPrice").val(result.data.newPrice);
                    }
                });

            }
        }).keyup(function(){
            //triggerHandler 防止事件执行完后，浏览器自动为标签获得焦点
            $(this).triggerHandler("blur");
        }).focus(function(){
            $(this).triggerHandler("blur");
        });


        $('#add').click( function () {
            $.ajax({
                cache: false,
                type: "POST",
                url:"/permission/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        turnpage("/permission/list");
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