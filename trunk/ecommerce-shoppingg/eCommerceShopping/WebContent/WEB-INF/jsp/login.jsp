<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>e-Commerce Shopping Sign Up</title>
</head>
<body>
	<h2>SignUp</h2>
	<form:form method="post" action="signUp.html" commandName="login">

		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password<form:password path="password"></form:password></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SignUp" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>