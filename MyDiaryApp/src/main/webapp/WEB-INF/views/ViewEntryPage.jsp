<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewEntry</title>
<style>
.viewEntry {
	display: flex;
	justify-content: center;
	color: blue;
}

.titleText {
	color: orange;
	text-align: center;
}

</style>
</head>
<body>
	<div class="titleText">
		<h3>View Diary Entry</h3>
	</div>
	<div class="viewEntry">
		<table>
			<tr>
				<td><label>Date:</label></td>
				<td><fmt:formatDate value="${userEntryById.entryDate}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
			<tr>
				<td><label>Description:</label></td>
				<td><textarea rows="10" cols="30" readonly="readonly">${userEntryById.entryText}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><a href="./userHomePage"><button
							type="button">BackToHome</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>