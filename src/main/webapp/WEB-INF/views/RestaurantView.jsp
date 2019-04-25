<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Restaurant</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-white bg-white">

		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Fudatu-Where Hunger Ends!</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			</ul>
	
		</div>
		
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">

			<button class="btn btn-danger" type="submit">Logout</button>

		</form:form>
		</div>
	</nav>





 <form:form action="${pageContext.request.contextPath}/rm/processManagerRegistrationForm"
              modelAttribute="restaurant">
            <input type="text" name="restaurantName"required="required" >Name<br><br>
            <input type="text" name="Zipcode"required="required">Zipcode<br><br>
            <input type="text" name="restaurantMenu"required="required">restaurantMenu<br><br>
            <input type="text" name="Costfor2"required="required">Costfor2<br><br>
            <input type="submit" name="submit" value="Add">
        </form:form>








</body>
</html>