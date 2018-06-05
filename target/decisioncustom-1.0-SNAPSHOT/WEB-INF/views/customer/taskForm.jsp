<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
</head>
<body>
   <form id="taskForm1">
   	  <table align="center">
   	  	<tr>
   	  		<td>名称:</td>
   	  		<td><input type="text" name="name" readonly="readonly"/></td>
   	  	</tr>
   	  	<tr>
   	  		<td>性别:</td>
   	  		<td><input type="text" name="gender" readonly="readonly"/></td>
   	  	</tr>
   	  	<tr>
   	  		<td>职业:</td>
   	  		<td><input type="text" name="job" readonly="readonly"/></td>
   	  	</tr>
   	  	<tr>
   	  		<td>营销人员:</td>
   	  		<td><input type="text" id="seller" name="seller" readonly="readonly"/></td>
   	  	</tr>
   	  	<tr>
   	  		<td>状态:</td>
   	  		<td><input type="text" name="status" readonly="readonly"/></td>
   	  	</tr>
   	  </table>
   </form>
<div id="taskForm"></div>
</body>
</html>