<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddEntry</title>
<style>
.titleText {
	text-align: center;
	color: green;
}

.entryForm {
	display: flex;
	justify-content: center;
	color: blue;
}

#saveButton {
	color: green;
	background-color: white;
}
</style>
</head>
<body>

	<div class="titleText">
		<h2>Add Diary</h2>
	</div>
	<div class="entryForm">
		<form method="POST" action="./saveDiaryEntry">
			<label>Select a Date</label> <input type="date" name="entryDate">
			<br /> <br /> <label>Description</label>
			<textarea name="entryText" rows="10" cols="30"></textarea>
			<br /> <input type="hidden" name="userName"
				value="${userDetails.userName}"> <br /> <br />
			<button id="saveButton" type="submit">SaveDiary</button>
		</form>
	</div>
	<br />
	<br />
	<a href="./userHomePage"><button type="button">BackToHome</button></a>
</body>
</html>