<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

</head>
<body>






	<f:form method="POST" action="addStudent" modelAttribute="student_model" >

		<label>First name</label>	<br>		
		<f:input path="firstName" /><br>
		<label>Last name</label><br>	
		<f:input path="lastName" /><br>
		<label>Last name</label><br>
		<f:input path="lastName" /><br>
		<label>Email</label><br>
		<f:input path="email" /><br>
		<label>Birth date (dd/mm/yyyy)</label><br>
	    <f:input  path="birthDate"/><br>
		<label>Contact Number</label><br> 
		<f:input path="contactNumber" /><br>
		<input type="submit" value="Submit" /><br>

	</f:form>




</body>
</html>