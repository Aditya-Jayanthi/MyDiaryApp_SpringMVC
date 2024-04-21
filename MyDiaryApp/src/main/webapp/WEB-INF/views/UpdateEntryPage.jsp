<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateEntry</title>
<style>
.titleText {
	text-align: center;
	color: green;
}

.updateForm {
	display: flex;
	justify-content: center;
	color: blue;
}

#updateButton {
	color: green;
	background-color: white;
}
</style>
</head>
<body>

	<div class="titleText">
		<h2>Update Diary</h2>
	</div>
	<div class="updateForm">
		<form method="POST" action="./updateDiaryEntry">
			<label>Date</label> <input type="text" name="entryDate" value="<fmt:formatDate value="${userEntryById.entryDate}"
						pattern="yyyy-MM-dd" />"
				readonly="readonly"> <br /> <br /> <label>Description</label>
			<textarea name="entryText" rows="10" cols="30">${userEntryById.entryText}</textarea>
			<br /> <input type="hidden" name="userName"
				value="${userDetails.userName}"> <br /> <br /> <input
				type="hidden" name="entryId" value="${userEntryById.entryId}">
			<br /> <br />
			<button id="updateButton" type="submit">UpdateDiary</button>
		</form>
	</div>
	<br /> <br />
		<a href="./userHomePage"><button
							type="button">BackToHome</button></a>
</body>
</html>