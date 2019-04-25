<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<h1>You are Awesome, Your Order has been placed with us!!!</h1>
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






		<form:form method="POST" action="${pageContext.request.contextPath}/order/exportData">
			<input type ="text" name ="orderid"/><br>	
				
            <input type ="submit" name="Submit" value="Confirm" /><br><p>
            </form:form>
            <table border="1px" cellpadding="8px">
			<tr>
			<td>OrderId</td><td>Orderdetails</td><td>Restaurant_id</td><td>User_Id</td>
			</tr>

			<c:forEach items="${orderList}" var="current">
			<tr>
  			<td><c:out value="${current.orderid}" /></td>
   			 <td><c:out value="${current.orderdetails}" /></td>
   			 <td><c:out value="${current.user.userid}" /></td>
   			 <td><c:out value="${current.restaurant.restaurantid}" /></td>
			</tr>
			</c:forEach>
			</table>
            
           

</body>
</html>