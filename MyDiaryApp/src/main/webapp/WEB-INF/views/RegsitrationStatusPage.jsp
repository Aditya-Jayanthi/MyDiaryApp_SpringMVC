<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
#regSuccess {
	text-align: center;
	color: green;
}

#userExists {
	text-align: center;
	color: red;
}

.loginLink {
	text-align: center;
}
</style>
</head>
<body>
	<div class="regStatus">
		<%
		String strRegistration = (String) request.getAttribute("Regsitration");
		if (("UserExists").equals(strRegistration)) {
			out.println("<h2 id=\"userExists\">Username already exists!!</h2>");
		} else {
			out.println("<h2 id=\"regSuccess\">Registration Successful </h2>");
		}
		%>
	</div>
	<h3 class="loginLink">
		<a href="./loginPage">Click here to Login</a>
	</h3>
</body>
</html>