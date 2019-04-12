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

<title>My JSP 'update_password.jsp' starting page</title>

<link rel="stylesheet" href="css/style1.css">

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function checkpasswd() {
		var passwd = document.getElementById("password1").value;
		var repasswd = document.getElementById("password2").value;
		if (passwd == repasswd) {
			return true;
		} else {
			window.alert("两次输入密码不一致");
			return false;
		}
	}
</script>
</head>

<body>
	<br>
	<div class="form-div">
		<form target="menuFrame" action="employee/updatePassword.do"
			name="update_password_form" method="post"
			onsubmit="return check(this);">

			<table>
				<caption>
					<b>密码修改</b>
				</caption>
				<tr>
					<td colspan=2><span style="color: red; float: left;"><c:out
								value="${update_password_error }" /></span></td>
				</tr>
				<tr>
					<td>账号：</td>
					<td><input name="account" type="text" class="inputinput"
						style="color: blue; font-weight: bolder;" readonly size="40"
						value="${employee.em_account }"></td>
				</tr>
				<tr>
					<td>原密码：</td>
					<td><input name="password0" type="password" required
						oninvalid="setCustomValidity('请填写原密码')"
						oninput="setCustomValidity('')" /></td>
				</tr>
				<tr>
					<td>新密码：</td>
					<td><input name="password1" type="password" required
						oninvalid="setCustomValidity('请填写新密码')"
						oninput="setCustomValidity('')" id="password1" /></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input name="password2" type="password" required
						oninvalid="setCustomValidity('请确认新密码')"
						oninput="setCustomValidity('')" id="password2" /></td>
				</tr>
			</table>

			<div class="buttons">
				<input value="修 改" type="submit" onclick="return checkpasswd()"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
