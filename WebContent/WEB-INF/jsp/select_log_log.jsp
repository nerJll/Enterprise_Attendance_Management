<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'select_log_log.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/style1.css">

</head>

<body>
	<div class="form-div">
		<form action="employee/selectLogLog.do" target="menuFrame"
			method="post">
			<table>
				<caption>
					<b> 员工登陆日志查询</b>
				</caption>
				<tr>
					<td colspan=2><span style="color: red; float: left;"> <c:out
								value="${select_log_log_error }"></c:out>
					</span></td>
				</tr>
				<tr>
					<td>工号：</td>
					<td><input name="id" type="text" required
						oninvalid="setCustomValidity('请填写工号')"
						oninput="setCustomValidity('')"
						onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"
						onblur="this.v();"></td>
				</tr>
				<tr>
					<td>起始时间：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 195px; height: 30px; border-radius: 5px;"
							type="datetime-local" name="begindate"
							value="2017-04-24T13:59:59" /></span></td>
				</tr>
				<tr>
					<td>结束时间：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 195px; height: 30px; border-radius: 5px;"
							type="datetime-local" name="enddate" value="2017-05-20T09:59:59" /></span></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="查 找"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
				<input type="reset" value="重 置"
					style="width: 60px; margin-right: 20px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
