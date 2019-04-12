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

<title>My JSP 'apply_defer.jsp' starting page</title>

<link rel="stylesheet" href="css/style1.css">

</head>

<body>
	<br>
	<div class="form-div">
		<form target="menuFrame" action="employee/applyLeave.do" method="post">
			<table style="border-collapse: separate; border-spacing: 5px;">
				<caption>
					<b>补休申请</b>
				</caption>
				<tr>
					<td colspan=2><span style="color: red; float: left;"> <c:out
								value="${apply_overtime_error }"></c:out>
					</span></td>
				</tr>
				<tr>
					<td>工号：</td>
					<td><input name="id" type="text" class="inputinput"
						style="color: blue; font-weight: bolder;" readonly size="40"
						value="${employee.em_id }"></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input name="name" type="text" class="inputinput"
						style="color: blue; font-weight: bolder;" readonly size="40"
						value="${employee.em_name }"></td>
				</tr>
				<tr>
					<td>内容：</td>
					<td><input name="content" type="text" class="inputinput"
						style="color: blue; font-weight: bolder;" readonly size="40"
						value="补休"></td>
				</tr>
				<tr>
					<td>原因：</td>
					<td><span style="float: left;">&nbsp;&nbsp;<textarea
								required oninvalid="setCustomValidity('请填写原因')"
								oninput="setCustomValidity('')" name="reason"
								style="border-radius: 5px;" rows="5" cols="36"></textarea></span></td>
				</tr>
				<tr>
					<td>开始日期：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 130px; height: 28px; border-radius: 5px;"
							type="date" name="beginday" value="2017-04-21" /></span></td>
				</tr>
				<tr>
					<td>结束日期：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 130px; height: 28px; border-radius: 5px;"
							type="date" name="endday" value="2017-04-25" /></span></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="提 交"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
				<input type="reset" value="清 空"
					style="width: 60px; margin-right: 20px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
