<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />

<style>
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

<title>check_my_unrie_reason</title>
</head>
<body>
	<div class="form-div">
		<form>
			<table>
				<tr>
					<td>不通过原因：</td>
					<td><span style="float: left;"> <textarea
								readonly="readonly"
								style="border-radius: 5px; font-weight: bold;" rows="5"
								cols="30">${myUnrieReason.at_unrevreason }</textarea></span></td>
				</tr>
			</table>
			<br class="clear">
		</form>
		<a href="employee/toSelectMyApplyLog.do"> &laquo返回</a>
	</div>
</body>
</html>