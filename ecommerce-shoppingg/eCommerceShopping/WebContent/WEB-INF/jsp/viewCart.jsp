<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pragiti.domain.ProductItem,java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Shopping Cart Application - View Cart</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
</head>
<body>

	<c:set var="items" value="${items}" />
	
	<%
		Object obj = request.getAttribute("items");
		List<ProductItem> items = (List<ProductItem>) obj;
	%>
<center>
<div class="mainShell">
<div class="pageIdentifier">View Cart Page</div>
<div class="content">
<form action="Checkout.jsp" method="POST" >
<div class="dialog">
<table border="1">
		<tr>
			<td>ItemId</td>
			<td>Name</td>
			<td>Description</td>
			<td>Price</td>
			<td>Quantity</td>
		</tr>
		<%
			for (ProductItem item : items) {
		%>
		<tr>
			<td><%=item.getId()%></td>
			<td><%=item.getName()%></td>
			<td><%=item.getDesc()%></td>
			<td><%=item.getPrice()%></td>
		  	<td align="center"><%=item.getQuantity()%></td>
		  				<td><a href="removeCart.html?itemId=<%=item.getId()%>">Remove From Cart</a></td>
		  	
				</tr>
		<%
			}
		%>
	</table>
<br></br>
<input type="submit" value="Checkout">
<br>
<br>
</div>
</form>
</div> <!-- End content div -->
</div> <!-- End mainShell div -->
</center>
</body>
</html>

