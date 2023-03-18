<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC - Flash Attributes</title>
</head>
<body>
	<h2>Add Person</h2>
	<form:form method="post" action="addPerson" modelAttribute="person">

		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"/></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"/></td>
			</tr>
			
			<tr>
				<td>Department Name</td>
				<td><input type="text" name="department"/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>