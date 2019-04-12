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

<title>My JSP 'search_manager_success.jsp' starting page</title>

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
	<h3>查找结果：</h3>
	<form action="" method="post">
		<table>
			<tr>
				<th>账号</th>
				<th>密码</th>
				<th>操作</th>
			</tr>
			<tr>
				<td><c:out value="${select_manager.managerName }" /></td>
				<td><c:out value="${select_manager.managerPassword }" /></td>
				<td><a
					href="manager/toDeleteManager.do?name=${select_manager.managerName }"
					target="menuFrame">删除</a></td>
			</tr>
		</table>
	</form>
	<br>
	<a href="manager/toSelectManager.do"><b>返回</b></a>
</body>
</html>
