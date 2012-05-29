<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Page</title>
</head>
<body>

<h1>Please Enter The Details Asked Below To Proceed With Checkout</h1>

	
	<table border=1 >
	<tr>
 	<td align = "center" width = "100px"><b>Product ID</b></td>
 	<td align = "center" width = "100px"><b>Product Name</b></td>
 	<td align = "center" width = "300px"><b>Description</b></td>
 	<td align = "center" width = "100px"><b>Price</b></td>
 	<td align = "center" width = "50px"><b>Quantity</b></td>
 	</tr>
 	</table>
 
 	<br></br>
 	
 	<form:form method="post" action="checkout.html" commandName="checkout">
 	<table>
	<tr>
	<td> Card Holder Name  </td>
	<td> <input type="text" path="nameOnCard" ></td>	
	</tr>
	

	<tr>
	<td> Credit Card Number  </td>
	<td> <input type="text" path="creditcard_number" ></td>
	</tr>


	<tr>
	<td> Expiration Date (MM/YYYY) </td>
	<td> <input type="text" path=expmonth size=2>
	<select path=expyear>
	<%  int startYear = 2012;
		int endYear = 2020;
		for(int y=startYear; y<endYear; y++) {    %>
		<option><%=y%></option>
	 <%  }   %>
	</select></td>
	</tr>

	<tr><td> CVV Number
	<td> <input type="text" path="cvv_number" ></td>
	</tr>

	</table>
	<input type="submit" value="Checkout">
	</form:form>
	</body>
	</html>