<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'select_pre_atten.jsp' starting page</title>

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
	<form action="" method="post">
		<table>
			<caption>
				<b>修改前信息</b>
			</caption>
			<tr bgcolor="#D1EEEE">
				<th>序号</th>
				<th>*原因</th>
				<th>*开始日期</th>
				<th>*结束日期</th>
				<th>修改日期</th>
			</tr>
			<c:forEach items="${preAttendances }" var="attendance"
				varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><c:out value="${attendance.att_berea }" /></td>
					<td><fmt:formatDate value="${attendance.att_bebeday}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${attendance.att_beenday}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${attendance.att_modday}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
		<br> &nbsp;&nbsp;&nbsp;<a href="employee/toSelectVacModLog.do"
			target="menuFrame">&laquo;&laquo;返回继续查询</a>
	</form>
</body>
</html>
