<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'search_employee_success.jsp' starting page</title>

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
	width:800px;
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
			<tr bgcolor="#E0EEEE">
				<th>工号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>入职日期</th>
				<th>部门</th>
				<th>班级号</th>
				<th>职称</th>
				<th>账号</th>
				<th>密码</th>
				<th>操作</th>
				<th>操作</th>
			</tr>
			<tr>
				<td><c:out value="${select_employee.em_id }" /></td>
				<td><c:out value="${select_employee.em_name }" /></td>
				<td><c:out value="${select_employee.em_sex }" /></td>
				<td><fmt:formatDate value="${select_employee.em_birthday}"
						pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatDate value="${select_employee.em_entryday}"
						pattern="yyyy-MM-dd" /></td>
				<td><c:out value="${select_employee.em_department }" /></td>
				<td><c:out value="${select_employee.em_classid }" /></td>
				<td><c:out value="${select_employee.em_title }" /></td>
				<td><c:out value="${select_employee.em_account }" /></td>
				<td><c:out value="${select_employee.em_password }" /></td>
				<td><a
					href="manager/toUpdateEmployee.do?em_id=${select_employee.em_id }"
					target="menuFrame">修改</a></td>
				<td><a
					href="manager/toDeleteEmployee.do?em_id=${select_employee.em_id }"
					target="menuFrame">删除</a></td>
			</tr>
		</table>
	</form>
	<br>
	<a href="manager/toSelectEmployee.do"><b>&laquo;返回</b></a>
</body>
</html>
