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
<c:set var="projectPath" value="${pageContext.request.contextPath}" />
<title>My JSP 'select_my_class_log.jsp' starting page</title>

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
	<span style="color: red; float: left;"> <c:out
			value="${select_my_class_log_error }"></c:out></span>
	<form action="" method="post">
		<br>
		<table>
			<caption>
				<b>班组人员考勤申请记录</b>
			</caption>
			<tr bgcolor="#D1EEEE">
				<th>序号</th>
				<th>工号</th>
				<th>姓名</th>
				<th>内容</th>
				<th>原因</th>
				<th>开始日期</th>
				<th>结束日期</th>
				<th>状态</th>
				<th>申请日期</th>
			</tr>
			<c:forEach items="${sessionScope.pagemsg.lists }" var="attendance"
				varStatus="status">
				<tr>
					<td><c:out value="${status.count }" /></td>
					<td><c:out value="${attendance.at_emid }" /></td>
					<td><c:out value="${attendance.at_emname }" /></td>
					<td><c:out value="${attendance.at_content }" /></td>
					<td><c:out value="${attendance.at_reason }" /></td>
					<td><fmt:formatDate value="${attendance.at_beginday}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${attendance.at_endday}"
							pattern="yyyy-MM-dd" /></td>
					<td><c:choose>
							<c:when test="${attendance.at_state == '不通过'}">
								<font color="#00EE00"><b><c:out
											value="${attendance.at_state }"></c:out></b></font>
							</c:when>
							<c:otherwise>
								<b><c:out value="${attendance.at_state }"></c:out></b>
							</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate value="${attendance.at_applyday}"
							pattern="yyyy-MM-dd" /></td>
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
								href="${projectPath }/employee/toSelectMyClassLog.do?currentPage=1">[首页]</a>&nbsp;&nbsp;
           		<a
								href="${projectPath }/employee/toSelectMyClassLog.do?currentPage=${sessionScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if> <c:if
							test="${sessionScope.pagemsg.currPage != sessionScope.pagemsg.totalPage}">
							<a
								href="${projectPath }/employee/toSelectMyClassLog.do?currentPage=${sessionScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a
								href="${projectPath }/employee/toSelectMyClassLog.do?currentPage=${sessionScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
				</span></td>
			</tr>
		</table>
	</form>
</body>
</html>
