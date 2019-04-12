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

<title>My JSP 'add_manager.jsp' starting page</title>

<link rel="stylesheet" href="css/style1.css">

</head>

<body>
	<br>
	<div class="form-div">
		<form target="menuFrame" action="manager/addManager.do" method="post">
			<table style="border-collapse: separate; border-spacing: 5px;">
				<caption>
					<b>添加管理员</b>
				</caption>
				<tr>
					<td colspan=2><span style="color: red; float: left;"> <c:out
								value="${add_manager_error }"></c:out>
					</span></td>
				</tr>
				<tr>
					<td>账号：</td>
					<td><input name="name" type="text" required
						oninvalid="setCustomValidity('请填写账号')"
						oninput="setCustomValidity('')" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input name="password" type="text" required
						oninvalid="setCustomValidity('请填写密码')"
						oninput="setCustomValidity('')" /></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="添 加"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
				<input type="reset" value="清 空"
					style="width: 60px; margin-right: 20px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
