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
		
		<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">

				<button class="btn btn-danger" type="submit">Logout</button>

			</form:form>
		</div>

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
	</nav>






<form:form action="${pageContext.request.contextPath}/cust/processManagerRegistrationForm"
		Method="POST" >
            
            <input type="radio" name="Zipcode" required="required">Search by Zip<br>
            <input type="text" name="Zipcodet" required="required">Zipcode<br><br>
            
            
            <input type="submit" name="submit" value="Search">
        </form:form>


</body>
</html>