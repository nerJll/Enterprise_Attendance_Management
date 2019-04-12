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

<title>My JSP 'select_log_log_success.jsp' starting page</title>

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
	width:600px;
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
			value="${select_log_log_null }"></c:out></span>
	<form action="" method="post">
		<table>
			<caption>
				<b>员工登陆日志</b>
			</caption>
			<tr bgcolor="#E0EEEE">
				<th>序号</th>
				<th>工号</th>
				<th>姓名</th>
				<th>登陆时间</th>
				<th>登出时间</th>
				<th>部门</th>
				<th>班级号</th>
			</tr>
			<c:forEach items="${loginLogoutLogs }" var="loginlogoutlog"
				varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><c:out value="${loginlogoutlog.lo_emid }" /></td>
					<td><c:out value="${loginlogoutlog.lo_emname }" /></td>
					<td><fmt:formatDate value="${loginlogoutlog.lo_logintime}"
							type="both" /></td>
					<td><fmt:formatDate value="${loginlogoutlog.lo_logouttime}"
							type="both" /></td>
					<td><c:out value="${loginlogoutlog.lo_emdep }" /></td>
					<td><c:out value="${loginlogoutlog.le_emclassid }" /></td>
				</tr>
			</c:forEach>
		</table>
		<br> &nbsp;&nbsp;&nbsp;<a href="employee/toSelectLogLog.do"
			target="menuFrame">&laquo;&laquo;返回继续查询</a>
	</form>
</body>
</html>
