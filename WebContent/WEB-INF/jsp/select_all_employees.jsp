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
<c:set var="projectPath" value="${pageContext.request.contextPath}" />
<title>My JSP 'select_all_employees.jsp' starting page</title>

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
	width: 1000px;
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
	<span> &nbsp;&nbsp;&nbsp;<a
		href="${projectPath }/manager/toAddEmployee.do" target="menuFrame">添加员工&raquo;</a></span>
	<form action="" method="post">
		<table>
			<caption>
				<b>所 有 员 工</b>
			</caption>
			<tr bgcolor="#D1EEEE">
				<th>序号</th>
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
			<c:forEach items="${sessionScope.pagemsg.lists }" var="employee"
				varStatus="status">
				<tr>
					<td><c:out
							value="${(sessionScope.pagemsg.currPage-1)*5+status.count }" /></td>
					<td><c:out value="${employee.em_id }" /></td>
					<td><c:out value="${employee.em_name }" /></td>
					<td><c:out value="${employee.em_sex }" /></td>
					<td><fmt:formatDate value="${employee.em_birthday}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${employee.em_entryday}"
							pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${employee.em_department }" /></td>
					<td><c:out value="${employee.em_classid }" /></td>
					<td><c:out value="${employee.em_title }" /></td>
					<td><c:out value="${employee.em_account }" /></td>
					<td><c:out value="${employee.em_password }" /></td>
					<td><a
						href="${projectPath }/manager/toUpdateEmployee.do?em_id=${employee.em_id }"
						target="menuFrame">修改</a></td>
					<td><a
						href="${projectPath }/manager/toDeleteEmployee.do?em_id=${employee.em_id }"
						target="menuFrame">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<td><span>第${sessionScope.pagemsg.currPage }/
						${sessionScope.pagemsg.totalPage}页</span>&nbsp;&nbsp; <span>总记录数：${sessionScope.pagemsg.totalCount }&nbsp;&nbsp;
						每页显示:${sessionScope.pagemsg.pageSize}</span>&nbsp;&nbsp; <span> <c:if
							test="${sessionScope.pagemsg.currPage != 1}">
							<a
								href="${projectPath }/manager/toSelectAllEmployees.do?currentPage=1">[首页]</a>&nbsp;&nbsp;
           		<a
								href="${projectPath }/manager/toSelectAllEmployees.do?currentPage=${sessionScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if> <c:if
							test="${sessionScope.pagemsg.currPage != sessionScope.pagemsg.totalPage}">
							<a
								href="${projectPath }/manager/toSelectAllEmployees.do?currentPage=${sessionScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a
								href="${projectPath }/manager/toSelectAllEmployees.do?currentPage=${sessionScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
				</span></td>
			</tr>
		</table>
	</form>
</body>
</html>
