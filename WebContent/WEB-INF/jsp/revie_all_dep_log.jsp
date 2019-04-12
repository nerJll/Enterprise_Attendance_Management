<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'revie_all_dep_log.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
table {
	text-align: center;
	border: 1px solid #525252;
	border-collapse: collapse;
	width:500px;
}

table td, th {
	border: 1px solid #525252;
}

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
	<span style="color: red; float: left;"> <c:out
			value="${revie_all_dep_log_error }"></c:out></span>
	<form action="" method="post">
		<br>
		<table>
			<caption>
				<b>所有员工考勤申请单</b>
			</caption>
			<tr bgcolor="#D1EEEE">
				<th>序号</th>
				<th>工号</th>
				<th>姓名</th>
				<th>部门</th>
				<th>内容</th>
				<th>状态</th>
				<th>申请日期</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${revieAllDepLog }" var="attendance"
				varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><c:out value="${attendance.at_emid }" /></td>
					<td><c:out value="${attendance.at_emname }" /></td>
					<td><c:out value="${attendance.at_emdep }" /></td>
					<td><c:out value="${attendance.at_content }" /></td>
					<td><b><c:out value="${attendance.at_state }"></c:out></b></td>
					<td><fmt:formatDate value="${attendance.at_applyday}"
							pattern="yyyy-MM-dd" /></td>
					<td><a
						href="employee/toCheckAllDepAtten.do?at_id=${attendance.at_id }">查看</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
