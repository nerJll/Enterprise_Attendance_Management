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

<title>My JSP 'update_attendance.jsp' starting page</title>

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
		<form action="employee/updateAttendance.do" target="menuFrame"
			method="post">
			<a href="employee/toSelectMyApplyLog.do"> <font size=3
				style="font-weight: bold;">&laquo;返回</font></a>
			<table style="border-collapse: separate; border-spacing: 5px;">
				<caption>
					<b>修改考勤申请信息</b>
				</caption>
				<tr>
					<td colspan=2><span style="color: red; float: left;"> <c:out
								value="${update_attendance_error }"></c:out>
					</span></td>
				</tr>
				<tr>
					<td>工号：</td>
					<td><input name="id" type="text" class="inputinput"
						style="color: blue; font-weight: bolder;" readonly size="40"
						value="${before_update_attendance.at_emid }"></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input name="name" type="text" class="inputinput"
						style="color: blue; font-weight: bolder;" readonly size="40"
						value="${before_update_attendance.at_emname }"></td>
				</tr>
				<tr>
					<td>内容：</td>
					<td><input name="content" type="text" class="inputinput"
						style="color: blue; font-weight: bolder;" readonly size="40"
						value="${before_update_attendance.at_content }"></td>
				</tr>
				<tr>
					<td>原因：</td>
					<td><span style="float: left;">&nbsp;&nbsp;<textarea
								required oninvalid="setCustomValidity('请填写原因')"
								oninput="setCustomValidity('')" name="reason"
								style="border-radius: 5px;" rows="5" cols="36">${before_update_attendance.at_reason }</textarea></span></td>
				</tr>
				<tr>
					<td>开始日期：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 130px; height: 28px; border-radius: 5px;"
							type="date" name="beginday" value="2017-05-16" /></span></td>
				</tr>
				<tr>
					<td>结束日期：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 130px; height: 28px; border-radius: 5px;"
							type="date" name="endday" value="2017-05-20" /></span></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="修 改"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
				<input type="reset" value="清 空"
					style="width: 60px; margin-right: 20px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
