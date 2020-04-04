<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LIST OF CUSTOMERS</title>

<!-- reference our style sheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<%! int totalCustomer; %>
	<div  id="wrapper">
		<div id="header"  >
		<h2 >CRM - Customer Relationship Manager</h2>
		</div>
		</div>
	
	
	
		<!-- add button for adding new customer in database -->
		
		
	<br>
	<div >
	<input type="button" value="Home"
onclick="window.location.href='list';
return false; "
class="add-button" />
	<input type="button" value="Refresh"
onclick="window.location.href='list';
return false; "
class="add-button" />
<input type="button" value="Add Customer"
onclick="window.location.href='showFormForAddNewCustomer';
return false; "
class="add-button" />

<label id="text" style="display:none"  for="submit-form" tabindex="0" class="add-label" >DeleteSelected</label>
</div>
<br>

<div style="background: yellow;height:40px ;color: red">

<form:form action="search" method="GET" style="float:left;margin-right:30px">
	<p style="font-size: 20px; font-weight: bold;display: inline;">Search Customer:</p><input type="text" placeholder="By Customer First Name" name="searchByName"
	 style="height:32px;width:300px ;font-size: 20px; font-weight: bold; " required="required" />
		<input type="submit" value="Search" class="add-button">
</form:form>	
<form:form action="searchByEmail" method="GET">
	<p style="font-size: 20px; font-weight: bold;display: inline;">Search Customer:</p><input type="text" placeholder="By Customer Email Address" name="searchByEmail" style="height:32px;width:300px ;font-size: 20px
		; font-weight: bold; " required="required" />
		<input type="submit" value="Search" class="add-button">
</form:form>
</div>	
	
<form:form action="deleteSelected" method="POST">
		<input type="submit" id="submit-form"  class="hidden" style="height:40px"  />
	<!-- table code from below -->
		<div id="container">
		<div id="content">
		<table  >
			
			 	<tr >
			 		<th style="width:8%">Select</th>
			 	   <th style="width:23%">First Name</th>
			 	   <th style="width:23%">Last Name</th>
			 	   <th style="width:23%">Email</th>
			 	   <th style="width:23%">Phone Number</th>
			 	   <th style="width:23%">Gender</th>
			 	   <th style="width:23%">Action</th>
			 	</tr>
			 	</table>
			<!-- ADD html table here -->
		<div style="height:500px;  overflow-y: auto;background:white"> 
			<table >
			
			 	<!-- <tr >
			 		<th >Select</th>
			 	   <th >First Name</th>
			 	   <th >Last Name</th>
			 	   <th >Email</th>
			 	   <th >Action</th>
			 	</tr> -->
			 	
			 	
			 	<!-- add loop to iterate database data and disply here
			 	using data store in  model attribute data  -->
			
				<c:forEach var="tempCustomer" items="${customers}">
					<!-- construct an update link with customer id -->
					<% totalCustomer++; %>
					<c:url var="updateLink" value="/customer/showFormForUpdate" >
					 <c:param name="customerId" value="${tempCustomer.id }" />
					</c:url>
					<c:url var="deleteLink" value="/customer/delete" >
					 <c:param name="customerId" value="${tempCustomer.id }" />
					</c:url>
					 
					<tr>
						<td style="width:8%">
						<label class="container">
						
  						<input type="checkbox" name="checkid" value="${tempCustomer.id}" 
  						id="${tempCustomer.id}"  onclick="myFunction(this.id, '')">
  						
  						<span class="checkmark"></span>
						</label>
						</td>
						
						<td style="width:23%"> ${tempCustomer.firstName}</td>
						<td style="width:23%"> ${tempCustomer.lastName}</td>
						<td style="width:23%"> ${tempCustomer.email}</td>
						<td style="width:23%"> ${tempCustomer.phoneNumber}</td>
						<td style="width:23%"> ${tempCustomer.gender}</td>
						<td style="width:23%">
						<!-- display u[date link -->
						<a href="${updateLink}" >Update</a>
						-------
						<a href="${deleteLink}" 
						onclick="if(!(confirm('Are you sure to delete ?'))) return false " >Delete</a>
						
						</td>
					</tr>
				</c:forEach>
				<tr>
						<td style="background:red;color: black;text-align: center;">The  End</td>
						<td style="background:red;color: black;text-align: center;">Of page</td>
						<td style="background:red;color: black;text-align: center;">No  more  data</td>
						<td style="background:red;color: black;text-align: center;">to  display</td>
						<td style="background:red;color: black;text-align: center;"> about  Customers.</td>
						
						<td style="background:red;color: black;text-align: center;">
						<% out.println("Total Customers are : " +totalCustomer); %>
								<%  totalCustomer=0; %>
							
						</td>
						
						</tr>
			</table>
			</div>
	</div>
		</div>
	</form:form>


<script>
var z=0;
function myFunction(id) {
    var checkBox = document.getElementById(id);
    var text = document.getElementById("text");
    if (checkBox.checked == true){
    	z++;
        text.style.display = "inline-block";
    } 
    else {
    	z--;
    	if(z==0)
        text.style.display = "none";
     }
}
</script>



</body>
</html>