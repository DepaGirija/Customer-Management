<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css">
</head>
<body bgcolor="pink">

	<div align="center">
		<br>
		<h1 style="color:red">*********************CRM********************</h1>
		<br>

		<div style="margin: 30px">
			<h2 style="color:blue;background-color:orange;width:100%"> User Registration Form </h2>
			<br>
			<form:form action="saveUser" modelAttribute="user" method="POST">
				<table>
					<tr>
						<td>User name:</td>
					</tr>
					<tr>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Password:</td>
					</tr>
					<tr>
						<td><form:input path="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Email:</td>
					</tr>
					<tr>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>
					<tr>
						<td colspan="1"><input type="submit" value="Register"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>