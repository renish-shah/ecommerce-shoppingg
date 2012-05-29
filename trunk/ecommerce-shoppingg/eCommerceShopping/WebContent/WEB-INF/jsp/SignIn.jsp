<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring 3 MVC Series</title>
</head>
<body>
	<h2>SignIn</h2>
	<form:form method="post" action="signIn.html" commandName="SignIn">

		<table>
			<tr>
				<td><form:label path="email">Email (Username)</form:label></td>
				<td><form:input path="email" />
				<form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" />
				<form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Sign In"  /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>