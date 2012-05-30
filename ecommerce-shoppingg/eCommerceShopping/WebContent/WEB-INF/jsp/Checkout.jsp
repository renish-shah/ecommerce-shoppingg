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


	<form:form method="post" action="checkout.html" commandName="checkout">
		<table>
			<tr>
				<td>Card Holder Name</td>
				<td><form:input type="text" path="nameOnCard"></form:input></td>
			</tr>


			<tr>
				<td>Credit Card Number</td>
				<td colspan="3"><form:input type="text"
						path="creditcard_number"></form:input></td>
			</tr>


			<tr>
				<td>Expiration Date (MM/YYYY)</td>
				<td><form:select path="expmonth">
						<%
							for (int y = 1; y <= 12; y++) {
						%>
						<option><%=y%></option>
						<%
							}
						%>
					</form:select> <form:select path="expyear">
						<%
							for (int y = 2012; y <= 2020; y++) {
						%>
						<option><%=y%></option>
						<%
							}
						%>
					</form:select></td>
			</tr>

			<tr>
				<td>CVV Number
				<td><form:input type="text" path="cvv_number"></form:input></td>
			</tr>

		</table>
		<input type="submit" value="Checkout">
	</form:form>
</body>
</html>