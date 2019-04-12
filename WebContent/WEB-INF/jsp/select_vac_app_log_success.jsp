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

<title>My JSP 'select_vac_app_success.jsp' starting page</title>

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
			value="${select_vac_app_log_null }"></c:out></span>
	<form action="" method="post">
		<table>
			<caption>
				<b>员工假期申请日志</b>
			</caption>
			<tr bgcolor="#E0EEEE">
				<th>序号</th>
				<th>工号</th>
				<th>姓名</th>
				<th>内容</th>
				<th>申请时间</th>
				<th>状态</th>
			</tr>
			<c:forEach items="${vacAppLogAttens }" var="vacApplogAtten"
				varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><c:out value="${vacApplogAtten.at_emid }" /></td>
					<td><c:out value="${vacApplogAtten.at_emname }" /></td>
					<td><c:out value="${vacApplogAtten.at_content}" /></td>
					<td><fmt:formatDate value="${vacApplogAtten.at_applyday}"
							pattern="yyyy-MM-dd" /></td>
					<td><c:choose>
							<c:when test="${vacApplogAtten.at_state == '不通过'}">
								<font color="#00EE00"><b><c:out
											value="${vacApplogAtten.at_state }"></c:out></b></font>
							</c:when>
							<c:otherwise>
								<b><c:out value="${vacApplogAtten.at_state }"></c:out></b>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<br> &nbsp;&nbsp;&nbsp;<a href="employee/toSelectVacAppLog.do"
			target="menuFrame">&laquo;&laquo;返回继续查询</a>
	</form>
</body>
</html>
