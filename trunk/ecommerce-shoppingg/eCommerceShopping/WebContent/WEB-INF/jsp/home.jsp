<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="com.pragiti.domain.ProductItem,java.util.List,java.util.Map,java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<c:set var="allItems" value="${allItems}" />


	<table border="1" align="center">
		<tr>
			<td colspan=3>
				<%
					HashMap map = (HashMap) request.getAttribute("allItems");
					if (map.containsKey("addToCart")) {

						String status = "" + map.get("addToCart");
						out.print("Item Added to your Cart Successfully...!!!");
					}

					List<ProductItem> items = (List<ProductItem>) map.get("items");
				%>
			</td>
			<td><a href="">Home</a></td>
			<td><a href="viewCart.html">View Cart</a></td>

			<td><a href="">SignOut</a></td>

		</tr>
		<tr></tr>

		<tr>
			<td>ItemId</td>
			<td>Name</td>
			<td>Description</td>
			<td>Price</td>
<!-- 			<td>Available Quantity</td> -->
		</tr>
		<%
			for (ProductItem item : items) {
		%>
		<tr>
			<td><%=item.getId()%></td>
			<td><%=item.getName()%></td>
			<td><%=item.getDesc()%></td>
			<td><%=item.getPrice()%></td>
<%-- 			<td align="center"><%=item.getQuantity()%></td> --%>
			<td><a href="addToCart.html?itemId=<%=item.getId()%>">Add to
					Cart</a></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>