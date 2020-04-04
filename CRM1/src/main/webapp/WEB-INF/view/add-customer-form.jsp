<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new customer</title>

<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" >

<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css" >

<style type="text/css">
.error {color:red}
</style>
</head>
<body>

<div id="wrapper">
	<div  id="header">
			<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>
<div style="clear;both;">
		<p>
		 <a href="${pageContext.request.contextPath}/customer/list" class="add-button" style="background: black; color: white">GoTo HOME</a>
		</p>
	</div>
<div id="container">
	<h3>Save Customer</h3>
	<form:form action="saveCustomer"  modelAttribute="customer" method="GET">
	
	<!-- need to associate this data with customer id -->
	<form:hidden path="id"/>
		 <table>
		 	<tr>
		 		<td> <label>First Name</label> </td>
		 		<td> <form:input path="firstName"   placeholder="REQUIRED" />
		 		<form:errors path="firstName" cssClass="error" />
		 		
		 		 </td>
		 	</tr>
		 	<tr>
		 		<td> <label>Last Name</label> </td>
		 		<td> <form:input  path="lastName"  placeholder="REQUIRED" /> 
		 			<form:errors path="lastName" cssClass="error" />
		 		</td>
		 	</tr>
		 	<tr>
		 		<td> <label>Email</label> </td>
		 		<td><!-- html5 valid email --> <form:input type="email" path="email" placeholder="REQUIRED"  /> 
		 		<form:errors path="email" cssClass="error" />
		 		
		 		</td>
		 	</tr>
		 	<tr>
		 		<td> <label>Phone Number</label> </td>
		 		<td><!-- html5 valid email --> <form:input type="phoneNumber" path="phoneNumber" placeholder="REQUIRED"  /> 
		 		<form:errors path="phoneNumber" cssClass="error" />
		 		
		 		</td>
		 	</tr>
		 	<tr>
		 		<td> <label>Gender</label> </td>
		 		<td><!-- html5 valid email --> <form:input type="gender" path="gender" placeholder="REQUIRED"  /> 
		 		<form:errors path="gender" cssClass="error" />
		 		
		 		</td>
		 	</tr>
		 	<tr>
		 		<td> <label></label> </td>
		 		<td> <input type="submit" value="save" class="save" /> </td>
		 	</tr>
		 </table>
	</form:form>
	
	
	<div style="background: yellow;height:40px ;color: red">
<form:form action="search" method="GET">
	<p style="font-size: 20px; font-weight: bold;display: inline;">Search Customer:</p><input type="text" placeholder="Customer First Name" name="searchByName" style="height:32px;width:300px ;font-size: 20px
		; font-weight: bold; "  />
		<input type="submit" value="Search" class="add-button">
</form:form>	
</div>		
</div>

</body>
</html>