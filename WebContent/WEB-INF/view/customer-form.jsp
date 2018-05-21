<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html >
<html>
<head>
<title>Save Customer</title>

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

	
		<h3 class="text-center">Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST" class="form-horizontal">

			<form:hidden path="id" />

			<div class="form-group">

				<label class="control-label col-sm-2" for="firstName">First Name:</label>
				<div class="col-sm-10">
				<form:input type="text" class="form-control" id="firstname"
					path="firstName" placeholder="FirtsName" />
					</div>

			</div>
			<div class="form-group">

				<label class="control-label col-sm-2" for="lastName">Last Name:</label>
				<div class="col-sm-10">
				<form:input type="text" class="form-control" id="lastname"
					path="lastName" placeholder="LastName"/>
					</div>

			</div>



			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email Address:</label>
				<div class="col-sm-10">
				<form:input type="text" class="form-control" id="lastname"
					path="email" placeholder="Email Address"/>
					</div>
			</div>

<div class="form-group">
 <div class="col-sm-offset-2 col-sm-10">
			<input type="submit" value="Save" class="btn btn-success" />

</div>
</div>

		</form:form>

		

		<p>
			<a href="${pageContext.request.contextPath}/customer/boot">Back
				to List</a>
		</p>
	</div>

</body>
</html>