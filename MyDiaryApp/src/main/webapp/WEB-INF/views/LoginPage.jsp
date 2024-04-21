<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
.titleText {
	text-align: center;
	color: green;
}

.loginStatus {
	text-align: center;
	color: red;
}

.loginForm {
	display: flex;
	justify-content: center;
	color: blue;
}

#loginButton {
	color: red;
}

.regLink {
	text-align: center;
}
</style>
</head>

<body>
	<div class="titleText">
		<h2>Login Page</h2>
	</div>

	<div class="loginStatus">
		<%
		String strLoginStatus = (String) request.getAttribute("LoginStatus");
		if ("UserNotExits".equals(strLoginStatus)) {
			out.println("<h2>User doesnot exists. Click on the registration link to SignUp!!</h2>");
		} else if ("WrongPassword".equals(strLoginStatus)) {
			out.println("<h2>Entered password is not matching!!</h2>");
		}else if("UserNotLoggedIn".equals(strLoginStatus)){
			out.println("<h2>Login to access the application!!</h2>");
		}
		%>
	</div>

	<div class="loginForm">
		<form method="POST" action="./authenticateUser">
			<label>Enter User Name</label> <input type="text" name="userName">
			<br /> <br /> <label>Enter Password</label> <input type="password"
				name="userPassword"> <br /> <br />
			<button id="loginButton">Login</button>
		</form>
	</div>

	<div class="regLink">
		<h4>
			Not Registered?? <a href="/MyDiaryApp/registerPage">Click here to
				register!!</a>
		</h4>
	</div>
</body>
</html>