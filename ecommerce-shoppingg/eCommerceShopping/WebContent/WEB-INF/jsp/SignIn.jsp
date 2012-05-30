<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>e-Commerce Shopping Application</title>
</head>
<body>
	<h2>SignIn</h2>
	<form:form method="post" action="signIn.html" commandName="SignIn">

		<table>
			<tr>
				<td><form:label path="email">Email (Username)</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password"></form:password></td>
				<form:errors path="password" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Sign In" /></td>
			</tr>
		</table>

		<td><a href="signUp.html"> New User? Click Here to Sign Up </a></td>
	</form:form>
</body>
</html>