<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
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
            <th><b>Items in Cart</b></th>
            
        </thead>
       </table>
				<br>
		
				
				 <c:forEach var="rest" items="${requestScope.r}">
                
                    
              <input type ="checkbox" name="rb" value="${rest}" required="required"/>${rest}<p>
				

            </c:forEach>
				<form:form method="POST" action="${pageContext.request.contextPath}/order/OrderRemove">
				
            <input type ="submit" name="Submit" value="Delete" /><br><p>
            </form:form>
            
            <form:form method="POST" action="${pageContext.request.contextPath}/order/OrderConfirmation">
				
            <input type ="submit" name="Submit" value="Confirm Order" />
            </form:form>
				
				
	<div id="viewCart">
        <label>[<a href="NavServlet?option=cart">View Cart</a>]</label>
    </div>
            
    


</body>
</html>