<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>HomePage</title>
<style>
.header {
	width: 100%;
	height: 40px;
}

.firstHeader {
	width: 6%;
	float: left;
	padding-left: 15px;
}

.secondHeader {
	width: 88%;
	float: left;
	font-weight: bold;
	text-align: center;
	padding-top: 15px;
	font-size: 25px;
}

#welcomeText {
	color: blue;
	float: left;
	padding: 5px 10px 10px 10px;
	font-size: 20px;
	font-weight: bold;
}

#signOut {
	color: red;
	float: right;
	padding: 5px 15px 10px 10px;
	font-size: 18px;
}

#entryText {
	color: orange;
	float: left;
	font-size: 20px;
	font-weight: bold;
	padding-left: 10px;
}

#addEntryButton {
	color: white;
	background-color: steelblue;
	float: right;
	padding: 5px 15px 10px 10px;
	text-align: center;
	size: 15px
}

.middleSection {
	padding-top: 50px;
}

.entriesTable {
	width: 100%;
}

td {
	padding: 10px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="firstHeader">
			<img src="<c:url value="/resources/images/Diary.jpg"/>" width="75"
				height="75">
		</div>
		<div class="secondHeader">MyDiary App</div>
	</div>
	<br>
	<br />
	<hr />
	<div class="homeHeader">
		<div id="welcomeText">
			Welcome <span style="color: steelblue;">${userDetails.userName}</span>
		</div>
		<div>
			<a id="signOut" href="./useSignOut">SignOut</a>
		</div>
	</div>
	<br />
	<br />
	<div class="middleSection">
		<div id="entryText">List of Past Entries</div>
		<div>
			<a href="./addEntryToDiary"><button id="addEntryButton"
					type="button">Add Entry</button></a>
		</div>
	</div>
	<br />
	<br />
	<table border="1" class="entriesTable">
		<tr>
			<th>Date</th>
			<th colspan="3">Actions</th>
		</tr>

		<c:if test="${listUserEntries.size() == 0}">
			<tr>
				<td colspan="4" style="text-align: center; color: purple">No
					entries to display!!</td>
			</tr>
		</c:if>
		<c:forEach items="${listUserEntries}" var="eachEntry">
			<tr>
				<td><fmt:formatDate value="${eachEntry.entryDate}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="./viewEntryPage?entryId=${eachEntry.entryId}">View</a></td>
				<td><a href="./updateEntryPage?entryId=${eachEntry.entryId}">Update</a></td>
				<td><a href="./deleteEntryPage?entryId=${eachEntry.entryId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>