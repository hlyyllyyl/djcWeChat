<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="/common/css/operating_record_edit.css" rel="stylesheet">
        <sf:form id="form" name="form" action="/operating_record/save" method="post"
                 modelAttribute="operatingRecord" enctype="multipart/form-data">
        <div class="panel">
            <div class="panel-heading">
                <a type="button" class="close ion-close-circled" data-dismiss="modal" aria-hidden="true"/>
                <h3 class="panel-title">
                    <c:choose>
                        <c:when test="${isNew}">
                            操作记录添加
                        </c:when>
                        <c:otherwise>
                            操作记录修改
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
                                    <label class="control-label" style="margin-left:  13px;">推荐时间</label>
                                    <fmt:formatDate value='${operatingRecord.recommendDate}' var='recommendDatetime' pattern='yyyy-MM-dd'/>
                                    <sf:input  id="recommendDate"  value="${recommendDatetime}"
                                               class="form_datetime required"  path="recommendDateStr"/>
                        </div>
                        <div class="inline">
                                    <label for="stockCode" style="margin-left:  80px;">股票代码</label>
                                    <sf:input type="text" id="stockCode" placeholder="" class="required" path="stockCode"/>
                        </div>
                    </div>
                    <div class="ro">
                            <div class="inline">
                                <label for="recommendBidPrice" style="margin-left:  -9px;">推荐买价(元)</label>
                                <sf:input type="text" id="recommendBidPrice" placeholder="" class="required" path="recommendBidPrice"/>
                            </div>
                            <div class="inline">
                                <label for="stockName" class="row4" style="margin-left:  80px;">股票名称</label>
                                <sf:input type="text" id="stockName" placeholder="" class="required" path="stockName"/>
                            </div>
                    </div>
                    <div class="ro">
                         <div class="inline">
                            <label for="recommendPosition"  style="margin-left:  -8px;">推荐仓位(%)</label>
                            <sf:input type="text" id="recommendPosition" placeholder="" class="required"  path="recommendPosition"/>
                        </div>
                        <div class="inline">
                            <label for="latestClosingPrice"  style="margin-left:  47px;">最新收盘价(元)</label>
                            <sf:input type="text" id="latestClosingPrice" placeholder="" class="required"  path="latestClosingPrice"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                                <label for="recommendStopProfit" style="margin-left:  -8px;">推荐止盈(元)</label>
                                <sf:input type="text" id="recommendStopProfit" placeholder="" class="required"  path="recommendStopProfit"/>
                         </div>
                        <div class="inline">
                            <label for="demo-cs-serviceManList" style="margin-left:  109px;" >客户</label>
                            <sf:select class="selectpicker show-tick " data-live-search="true"
                                       items="${customerList}" itemLabel="realName" multiple="true"
                                       id="demo-cs-customerList" name="serviceMan"  itemValue="id" path="customerStrs">
                            </sf:select>
                        </div>
                    </div>

                    <div class="ro">
                        <div class="inline">
                                <label for="adviser" style="margin-left:  42px;">投顾</label>
                                <sf:select class="selectpicker show-tick selectRow " items="${adviserList}"
                                           id="adviser" style=" height: 15px;width: 150px;"
                                           itemLabel="realName" itemValue="id" path="adviserStr">
                                </sf:select>
                        </div>
                        <div class="inline">
                                <label for="demo-cs-serviceManList" style="margin-left:  45px;" >客服</label>
                                <sf:select class="selectpicker show-tick " data-live-search="true"
                                           items="${serviceManList}" itemLabel="realName" multiple="true"
                                           id="demo-cs-serviceManList" name="serviceMan"  itemValue="id" path="serviceManStrs">
                                </sf:select>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                                <label for="recommendStopLoss" style="margin-left:  -10px;">推荐止损(元)</label>
                                <sf:input type="text" id="recommendStopLoss" multiple="true" class="required"  placeholder="" path="recommendStopLoss"/>
                            </div>
                        <div class="inline">
                                <label for="actualBidPrice" style="margin-left:  59px;">实际买价(元)</label>
                                <sf:input type="text" id="actualBidPrice" placeholder="" class="required"  path="actualBidPrice"/>
                            </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                                <label class="control-label" style="margin-left:  -15px;">实际买入时间</label>
                                <fmt:formatDate value='${operatingRecord.actualBuyingTime}' var='actualBuyingtime' pattern='yyyy-MM-dd'/>
                                <sf:input  id="actualBuyingTime"  value="${actualBuyingtime}"
                                           class="form_datetime required "  path="actualBuyingTimeStr"/>
                            </div>
                        <div class="inline">
                                <label class="control-label" style="margin-left:  54px;">实际卖出时间</label>
                                <fmt:formatDate value='${operatingRecord.actualSellingTime}' var='actualSellingtime' pattern='yyyy-MM-dd'/>
                                <sf:input  id="actualSellingTime"  value="${actualSellingtime}"
                                           class="form_datetime  required"  path="actualSellingTimeStr"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                                <label for="actualSellingPrice" style="margin-left:  -10px;">实际卖价(元)</label>
                                <sf:input type="text" id="actualSellingPrice" placeholder="" class="required" path="actualSellingPrice"/>
                        </div>
                        <div class="inline">
                                <label for="actualPosition" style="margin-left:  62px;">实际仓位(%)</label>
                                <sf:input type="text" id="actualPosition" placeholder="" class="required" path="actualPosition"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                            <label for="recommendStopProfit" style="margin-left:  12px;">风险提示</label>
                            <sf:select path="riskWarning" class="selectQuery" id="riskWarning">
                                <sf:option value="-1">-请选择-</sf:option>
                                <sf:option value="1">1</sf:option>
                                <sf:option value="2">2</sf:option>
                                <sf:option value="3">3</sf:option>
                                <sf:option value="4">4</sf:option>
                                <sf:option value="5">5</sf:option>
                                <sf:option value="0">0</sf:option>
                            </sf:select>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                                <label for="outOfPosition" style="margin-left:  -1px;">客户出仓实际盈亏比例(%)</label>
                                <sf:input type="text" id="outOfPosition" placeholder="" class="required" path="outOfPosition"/>
                        </div>
                    </div>
                    <div class="ro">
                        <div class="inline">
                                <label for="notOutOfPosition" style="margin-left:  -14px;">客户未出仓账面盈亏比例(%)</label>
                                <sf:input type="text" id="notOutOfPosition" placeholder="" class="required" path="notOutOfPosition"/>
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
        //序列化表单对象
        $.fn.serializeObject = function(){
            var o = {};
            var a = this.serializeArray();
            $.each(a, function() {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };

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
                url:"/operating_record/save", //把表单数据发送到ajax.jsp
                data:$('#form').serialize(), //要发送的是ajaxFrm表单中的数据
                async: false,
                success: function(result) {
                    if(result.success){
                        alert("操作成功");
                        $('#modelInfo').modal('hide');
                        goUrl("/operating_record/list");
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

        $("#recommendDate").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var startTimeString = e.date;
            $("#actualBuyingTime").datetimepicker("setStartDate", startTimeString)
        });
        $("#actualBuyingTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var startTimeString = e.date;
            $("#actualSellingTime").datetimepicker("setStartDate", startTimeString)
        });
        $("#actualSellingTime").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: 'month',
            language: 'zh-CN',
            autoclose: true,
            endDate: new Date()
        }).on("changeDate", function (e) {
            var endTimeString = e.date;
            $("#recommendDate").datetimepicker("setEndDate", endTimeString)
            $("#actualBuyingTime").datetimepicker("setEndDate", endTimeString)
        });
    })
</script>