<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Fudatu</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Fudatu- Where Hunger Ends!</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<security:authorize access="hasRole('CUSTOMER')">
				
				</security:authorize>
			</ul>
			




			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">

				<button class="btn btn-danger" type="submit">Logout</button>

			</form:form>
		</div>
	</nav>
<br>

	<div class="container">

	<h2>Hi ${user.firstName}</h2>
	

	<!-- display user name and role -->

	<p>
		
	</p>

	<security:authorize access="hasRole('CUSTOMER')">
		<p>
			<a href="${pageContext.request.contextPath}/customer">Start Ordering</a>

		</p>

	</security:authorize>

	<security:authorize access="hasRole('RestaurantManager')">

		<!-- Add a link to point to /leaders ... this is for the managers -->

		<p>
			<a href="${pageContext.request.contextPath}/manager">Manager Work Area</a>
			<a href="${pageContext.request.contextPath}/rm/restorder">Check Orders</a>

		</p>

	</security:authorize>


	<security:authorize access="hasRole('Admin')">

		

		<p>
			<a href="${pageContext.request.contextPath}/admin">Admin WorkArea</a>

		</p>

	</security:authorize>

	<hr>


</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>

</body>

</html>









