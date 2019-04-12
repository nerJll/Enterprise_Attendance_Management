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
<title>企业考勤管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>

</head>

<body>
	<div class="top"></div>
	<div id="header">
		<div class="logo">企业考勤管理系统</div>
		<div class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li><span style="color: #EEB422; font-weight: bold;"><c:out
							value="${employee.em_name }" /></span></li>
				<li><a href="employee/toUpdatePassword.do" target="menuFrame">修改密码</a></li>
				<li><a href="log/logout.do">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="left_menu">
			<ul id="nav_dot">
				<li>
					<h4 class="M7">
						<span></span>考勤查看
					</h4>
					<div class="list-item none">
						<a href='employee/toSelectMyDepLog.do' target="menuFrame">部门考勤记录</a>
						<a href='employee/toSelectAllDepLog.do' target="menuFrame">所有考勤记录</a>
					</div>
				</li>
				<li>
					<h4 class="M6">
						<span></span>考勤审核
					</h4>
					<div class="list-item none">
						<a href='employee/toRevieAllAtten.do' target="menuFrame">员工考勤审核</a>
					</div>
				</li>
				<li>
					<h4 class="M2">
						<span></span>日志查询
					</h4>
					<div class="list-item none">
						<a href='employee/toSelectLogLog.do' target="menuFrame">员工登陆日志查询</a>
						<a href='employee/toSelectVacAppLog.do' target="menuFrame">假期申请日志查询</a>
						<a href='employee/toSelectVacModLog.do' target="menuFrame">假期修改日志查询</a>
						<a href='employee/toSelectVacCanLog.do' target="menuFrame">假期删除日志查询</a>
					</div>
				</li>

			</ul>
		</div>
		<div class="m-right">
			<div class="main">
				<iframe id="menuFrame" name="menuFrame" style="overflow: visible;"
					scrolling="yes" frameborder=0 width="100%" height="100%">
				</iframe>
			</div>
		</div>
	</div>
	<div class="bottom"></div>
	<div id="footer">
		<p>Copyright©NER·2017.4</p>
	</div>
	<script>
		navList(12);
	</script>
</body>
</html>
