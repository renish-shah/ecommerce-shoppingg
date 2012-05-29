<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pragiti.domain.ProductItem,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="items" value="${items}" />

	<%
		Object obj = request.getAttribute("items");
		List<ProductItem> items = (List<ProductItem>) obj;
	%>

	<table>
		<tr>
			<td>ItemId</td>
			<td>Name</td>
			<td>Description</td>
			<td>Price</td>
			<td>Available Quantity</td>
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
			<td><a href="addToCart.html?itemId=<%=item.getId()%>">Add to
					Cart</a></td>
		</tr>
		<%
			}
		%>
	</table>






</body>
</html>