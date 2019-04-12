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

<title>My JSP 'add_employee.jsp' starting page</title>

<link rel="stylesheet" href="css/style1.css">

</head>

<body>
	<br>
	<div class="form-div">
		<form target="menuFrame" action="manager/addEmployee.do" method="post">
			<table style="border-collapse: separate; border-spacing: 5px;">
				<caption>
					<b>添加员工</b>
				</caption>
				<tr>
					<td colspan=2><span style="color: red; float: left;"> <c:out
								value="${add_employee_error }"></c:out>
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
					<td>姓名：</td>
					<td><input name="name" type="text" required
						oninvalid="setCustomValidity('请填写姓名')"
						oninput="setCustomValidity('')" /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><span style="float: left; width: 110px; height: 28px"><label><input
								name="sex" type="radio" value="男" checked="checked" />男 </label>&nbsp&nbsp
							<label><input name="sex" type="radio" value="女" />女 </label></span></td>
				</tr>
				<tr>
					<td>生日：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 130px; height: 28px; border-radius: 5px;"
							type="date" name="birthday" value="1995-06-02" /></span></td>
				</tr>
				<tr>
					<td>入职日期：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<input
							style="width: 130px; height: 28px; border-radius: 5px;"
							type="date" name="entryday" value="2017-04-21" /></span></td>
				</tr>
				<tr>
					<td>部门：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<select
							style="width: 70px; height: 28px; border-radius: 3px;"
							name="department">
								<option value="市场部">市场部</option>
								<option value="制造部">制造部</option>
								<option value="财政部">财政部</option>
								<option value="人力部">人力部</option>
								<option value="生产部">生产部</option>
								<option value="信息部">信息部</option>
								<option value="研发部">研发部</option>
								<option value="客服部">客服部</option>
						</select></span></td>
				</tr>
				<tr>
					<td>班级号：</td>
					<td><input name="classid" type="text" required
						oninvalid="setCustomValidity('请填写班级号')"
						oninput="setCustomValidity('')" /></td>
				</tr>
				<tr>
					<td>职称：</td>
					<td><span style="float: left;">&nbsp;&nbsp;&nbsp;<select
							style="width: 60px; height: 28px; border-radius: 3px;"
							name="title">
								<option value="员工">员工</option>
								<option value="班长">班长</option>
								<option value="领导">领导</option>
						</select></span></td>
				</tr>
				<tr>
					<td>账号：</td>
					<td><input name="account" type="text" required
						oninvalid="setCustomValidity('请填写账号')"
						oninput="setCustomValidity('')" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input name="password" type="text" required
						oninvalid="setCustomValidity('请填写密码')"
						oninput="setCustomValidity('')" /></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="添 加"
					style="width: 120px; margin-right: 20px; margin-top: 20px;">
				<input type="reset" value="清 空"
					style="width: 60px; margin-right: 20px; margin-top: 20px;">
			</div>
			<br class="clear">
		</form>
	</div>
</body>
</html>
