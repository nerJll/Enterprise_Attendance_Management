<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'check_my_class_log.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/style1.css">
<style type="text/css">
a {
	text-decoration: none;
}

a:link {
	color: blue
}

a:visited {
	color: blue
}

a:hover {
	color: #FF4500
}

a:active {
	color: #0000ff
}
</style>
</head>

<body>
	<div class="form-div">
		<form action="employee/ReviePass.do" target="menuFrame" method="post">
			<a href="employee/toRevieClassAtten.do"> <font size=3
				style="font-weight: bold;">&laquo;返回</font></a>
			<table style="border-collapse: separate; border-spacing: 5px;">
				<caption>
					<b>审核班组考勤申请信息</b>
				</caption>
				<tr>
					<td>工号：</td>
					<td><font style="float: left;">${beforeRevieAttendance.at_emid }</font></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><span style="float: left">${beforeRevieAttendance.at_emname }</span></td>
				</tr>
				<tr>
					<td>内容：</td>
					<td><span style="float: left">${beforeRevieAttendance.at_content }</span></td>
				</tr>
				<tr>
					<td>原因：</td>
					<td><span style="float: left;"><textarea readonly
								style="border-radius: 5px; font-weight: bold;" rows="5"
								cols="30">${beforeRevieAttendance.at_reason }</textarea></span></td>
				</tr>
				<tr>
					<td>开始日期：</td>
					<td><span style="float: left"><fmt:formatDate
								value="${beforeRevieAttendance.at_beginday}"
								pattern="yyyy-MM-dd" /></span></td>
				</tr>
				<tr>
					<td>结束日期：</td>
					<td><span style="float: left"><fmt:formatDate
								value="${beforeRevieAttendance.at_endday}" pattern="yyyy-MM-dd" /></span></td>
				</tr>
				<tr>
					<td>申请日期：</td>
					<td><span style="float: left"><fmt:formatDate
								value="${beforeRevieAttendance.at_applyday}"
								pattern="yyyy-MM-dd" /></span></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="通 过"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
				<input type="button" value="不 通 过"
					style="width: 60px; margin-right: 20px; margin-top: 20px;"
					onclick="document.getElementById('wri_rea_form').style.display='';">
			</div>
			<br class="clear">
		</form>
		<br>
		<form id="wri_rea_form" action="employee/writeUnRevReason.do"
			style="display: none">
			<table>
				<tr>
					<td>不通过原因：</td>
					<td><span style="float: left;"> <textarea
								name="at_unrevreason"
								style="border-radius: 5px; font-weight: bold;" rows="5"
								cols="30"></textarea></span></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="提 交"
					style="width: 50px; margin-right: 18px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
