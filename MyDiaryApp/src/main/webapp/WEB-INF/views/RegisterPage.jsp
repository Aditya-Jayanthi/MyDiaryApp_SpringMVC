<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<title>Register Page</title>

<style>
.titleText {
	text-align: center;
	color: green;
}

.registerForm {
	display: grid;
	place-items: center;
}

#submitButton {
	text-align: center;
}

.loginLink {
	text-align: center;
}
</style>

</head>

<body>

	<div class="titleText">
		<h2>Register Here!!</h2>
	</div>

	<div class="registerForm">
		<form method="POST" action="./registerUser">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userPassword"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><select name="userGender">
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="None">None</option>
					</select></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" name="userAge"></td>
				</tr>
				<tr>
					<td id="submitButton" colspan="2"><input type="submit"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="loginLink">
		<h4>
			Already a User?? <a href="/MyDiaryApp/loginPage">Click here to
				login!!</a>
		</h4>
	</div>
</body>

</html>