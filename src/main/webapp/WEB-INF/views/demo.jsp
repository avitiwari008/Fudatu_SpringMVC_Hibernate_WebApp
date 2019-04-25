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
<br>
<table border ="1" cellspacing="5" cellpadding="5">
            <thead>
            <th><b>Items</b></th>
            
        </thead>
       </table>
				<br>
				
				<form:form method="POST" action="${pageContext.request.contextPath}/order/OrderConfirm">
				<c:forEach var="rest" items="${requestScope.rest}">
                <input type ="radio" name="rb" value="${rest.restaurantMenu}"required="required" />${rest.restaurantMenu}<p>
                    
              
				

            </c:forEach>
            <input type ="submit" name="Submit" value="Add me to finish Hunger" />
            </form:form>
					
	<div id="viewCart">
        <label>[<a href="NavServlet?option=cart">View Cart</a>]</label>
    </div>
            
    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/order/OrderConfirm">Home</a></li>


</body>
</html>