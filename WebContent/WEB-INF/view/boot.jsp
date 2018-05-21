<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<title>LIST CUSTOMERS</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	
		<div class="bg-success text-white text-center">
			<h2>CRM Customers Relationship Manager</h2>
		</div>


		<div class="text-rigth">
		
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="btn btn-info" />
			</div>
	

	<form:form action="search" method="POST" class="form-group row">
		<div class="col-xs-4">

			<label for="ex1">Search customer:</label> 
			<input type="text" name="theSearchName" class="form-control text-rigth" id="ex1" /> 
			<input type="submit" value="Search" class="btn btn-success text-right" />
		</div>
	</form:form>


	<table class="table table-hover">
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Email address</th>
			<th>Action</th>
		</tr>

		<c:forEach var="tempCustomer" items="${customers}">

			<c:url var="updateLink" value="/customer/showFormUpdate">

				<c:param name="customerId" value="${tempCustomer.id}" />

			</c:url>

			<c:url var="deleteLink" value="/customer/delete">

				<c:param name="customerId" value="${tempCustomer.id}" />

			</c:url>
			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<td><a href="${updateLink}">Update</a> || <a
					href="${deleteLink}"
					onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
				</td>
			</tr>

		</c:forEach>
	</table>




</body>

</html>