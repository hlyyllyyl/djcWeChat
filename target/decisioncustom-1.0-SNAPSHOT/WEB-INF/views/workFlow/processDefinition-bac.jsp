<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程定义管理</title>
<!-- 
	统一步骤：
	* 引入通用资源"WebContent/WEB-INF/views/common.jsp"
	-------在页面加载完毕后----------
	1、声明页面中，哪些组件需要获取后，使用的
	2、获取需要使用的组件，并缓存
	3、初始化
	4、创建一个命令对象，来管理页面中，需要调用的方法
	5、对页面中所有按钮，统一添加事件（如何区分不同按钮的逻辑？？）
 -->
<%@ include file="/WEB-INF/views/common.jsp" %>
<script type="text/javascript">
    //---页面加载完毕后---
	$(function(){
		// 1. 声明页面中可能会用到组件
		var processDefinitionGrid,processDefinitionDlg,viewProcessDiagramDlg,processDefinitionForm;
		
		// 2. 缓存页面组件
		processDefinitionGrid = $("#processDefinitionGrid");
		processDefinitionDlg = $("#processDefinitionDlg");
		viewProcessDiagramDlg = $("#viewProcessDiagramDlg");
		processDefinitionForm = $("#processDefinitionForm");

		// 3. 定义一个事件处理对象,把事件相关的逻辑都封装到一个对象上(命令对象)
		var cmdObj = {
				create:function(){
					$("#sn").val('');
					$("#name").val('');
					
					processDefinitionDlg.dialog("open");
				},
				edit:function(){
					///workFlow/viewDiagram?deploymentId=1&diagarmResoruceName=test.png
					//打开之前需要动态设置流程图的src地址
					// 获取行选中数据
					var rowData = processDefinitionGrid.datagrid("getSelected");
					// 判断
					if(!rowData){
						$.messager.alert("温馨提示","请选中一行!!","info");
						return;
					}
					var deploymentId = rowData.deploymentId;
					var diagramResourceName = rowData.diagramResourceName;
					var src = "/workFlow/viewDiagram?deploymentId="+deploymentId+"&diagarmResoruceName="+diagramResourceName;
					
					//动态设置src地址
					$("#img").attr("src",src);
					//打开流程图对话框
					viewProcessDiagramDlg.dialog("open");
				},
				del:function(){
						//console.debug('del:function');
					// 获取行选中数据
					var rowData = processDefinitionGrid.datagrid("getSelected");
					// 判断
					if(!rowData){
						$.messager.alert("温馨提示","请选中一行!!","info");
						return;
					}
					$.messager.confirm("温馨提示","是否要删除该流程定义?",function(yes){
						if(yes){
							$.get("/processDefinition_delete",{"id":rowData.id},function(data){
								console.debug(data);
								if(data.success){
									// 关闭对话框
									processDefinitionDlg.dialog("close");
									// 提示,刷新
									$.messager.alert("温馨提示",data.message,"info",function(){
										// 刷新表格数据
										processDefinitionGrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.message,"info",function(){
										// 根据错误码,定位到单元格
									});
								}
							},"json");
						}
					});
				},
				refresh : function(){
					processDefinitionGrid.datagrid("reload");
				},
				save: function(){
					processDefinitionForm.submit();
				},
				cancel : function(){
					processDefinitionDlg.dialog("close");
				}
				
			};
		// 4. 初始化组件
		processDefinitionGrid.datagrid({
				url:"/workFlow/listProcessDefinitions",
				fit:true,
				border:false,
				fitColumns:true	,
				striped:true,
				toolbar:[{
					text:"部署新流程",
					iconCls:"icon-add",
					plain:true,
					handler:cmdObj['create']
				},{
					text:"删除",
					iconCls:"icon-remove",
					plain:true,
					handler:cmdObj['del']
				},{
					text:"查看流程图",
					iconCls:"icon-search",
					plain:true,
					handler:cmdObj['edit']
				},"-",{
					text:"刷新",
					iconCls:"icon-reload",
					plain:true,
					handler:cmdObj['refresh']
				}],//"#processDefinitionTb",
				rownumbers:true,
				singleSelect:true,
				pagination:true,
				columns:[[
			          {field:'id',title:'ID',width:20},    
			          {field:'name',title:'名称',width:20},    
			          {field:'key',title:'Key',width:20},    
			          {field:'version',title:'版本',width:20},    
			          {field:'deploymentId',title:'部署ID',width:20},    
			          {field:'resourceName',title:'bmpn文件资源名',width:20},    
			          {field:'diagramResourceName',title:'流程图资源名',width:20},    
			          {field:'description',title:'描述',width:40}   
     
	          ]]
		});
		
		processDefinitionDlg.dialog({
			width: 450,
			height: 200,
			title:"部署新流程",
			closed:true,
			modal:true,
			buttons:[{
				text:"部署",
				iconCls:"icon-save",
				handler:cmdObj['save']
			},{
				text:"取消",
				iconCls:"icon-cancel",
				handler:cmdObj['cancel']
			}]//"#processDefinitionDlgBtn"
		});
		viewProcessDiagramDlg.dialog({
			width: 800,
			height: 500,
			title:"查看流程图",
			closed:true,
			modal:true,
			buttons:[{
				text:"取消",
				iconCls:"icon-cancel",
				handler:cmdObj['xxxxCancel']
			}]
		});
		
		// 流程定义表单
		processDefinitionForm.form({
			url:"/workFlow/newDeploy",
			success:function(data){
				// 把响应结果转换成JSON对象
				data = $.parseJSON(data);
				if(data.success){
					// 关闭对话框
					processDefinitionDlg.dialog("close");
					// 提示,刷新
					$.messager.alert("温馨提示",data.message,"info",function(){
						// 刷新表格数据
						processDefinitionGrid.datagrid("reload");
					});
				}else{
					$.messager.alert("温馨提示",data.message,"info",function(){
						// 根据错误码,定位到单元格
					});
				}
			}
		});
	});
</script>
</head>
<body>
	<!-- 1. 表格-->
	<table id="processDefinitionGrid">
	</table>
	<!-- 2. 对话框-->
	<div id="processDefinitionDlg" >
	<font style="font-weight: bold;"></font>
		<form id="processDefinitionForm" method="post" enctype="multipart/form-data">
			<input name="id" type="hidden">
			<table align="center" style="margin-top: 10px;">
				<tr>
					<td>部署名称:</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>部署文件:</td>
					<td><input type="file" name="processFile"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 2. 查看流程图对话框-->
	<div id="viewProcessDiagramDlg" >
<!-- 		第一步:写死路径
<img src="/1.png" alt="xxxxx">
 -->
 <!-- 2 通过Controller来响应 -->
	<img id="img" src=""/>
	</div>
	
</body>
</html>