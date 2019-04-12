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

<title>My JSP 'select_my_dep_log.jsp' starting page</title>

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
			value="${select_my_dep_log_error }"></c:out></span>
	<form action="" method="post">
	<br>
		<table>
			<caption>
				<b>部门考勤申请人员记录（今明两天）</b>
			</caption>
			<tr bgcolor="#E0EEEE">
				<th>序号</th>
				<th>工号</th>
				<th>姓名</th>
				<th>内容</th>
				<th>开始日期</th>
				<th>结束日期</th>
			</tr>
			<c:forEach items="${myDepLog }" var="attendance" varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><c:out value="${attendance.at_emid }" /></td>
					<td><c:out value="${attendance.at_emname }" /></td>
					<td><c:out value="${attendance.at_content }" /></td>
					<td><fmt:formatDate value="${attendance.at_beginday}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${attendance.at_endday}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
