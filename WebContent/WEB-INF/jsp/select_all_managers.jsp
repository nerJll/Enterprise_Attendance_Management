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

<title>My JSP 'select_all_managers.jsp' starting page</title>

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
	width:300px;
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
		<table style="width: 300th;">
			<caption>
				<b>所有管理员</b>
			</caption>
			<tr bgcolor="#D1EEEE">
				<th>序号</th>
				<th>账号</th>
				<th>密码</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${managers }" var="manager" varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><c:out value="${manager.managerName }" /></td>
					<td><c:out value="${manager.managerPassword }" /></td>
					<td><a
						href="manager/toDeleteManager.do?managerName=${manager.managerName }"
						target="menuFrame">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> &nbsp;&nbsp;&nbsp;<a href="manager/toAddManager.do"
			target="menuFrame">添加管理员&raquo;</a>
	</form>
</body>
</html>
