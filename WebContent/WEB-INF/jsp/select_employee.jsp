<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'select_employee.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/style1.css">

</head>

<body>
	<div class="form-div">
		<form action="manager/selectEmployee.do" target="menuFrame" method="post">
			<table>
				<caption>
					<b> 查找员工</b>
				</caption>
				<tr>
					<td colspan=2><span style="color: red; float: left;"> <c:out
								value="${select_employee_error }"></c:out>
					</span></td>
				</tr>
				<tr>
					<td>工号：</td>
					<td><input name="id" type="text" required
						oninvalid="setCustomValidity('请填写工号')"
						oninput="setCustomValidity('')"
						onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"
						onblur="this.v();"></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="查 找"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
				<input type="reset" value="清 空"
					style="width: 60px; margin-right: 20px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
