<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/sample.css">

<script type="text/javascript" src="js/addFriend.js"></script>
<script type="text/javascript" src="js/actor.js"></script>
<script type="text/javascript" src="js/holiday.js"></script>

<title>Insert title here</title>
</head>
<body onload="loadFriends();openActorSocket();openHolidaySocket(); ">
<div id="container">
	<header role="banner"> <img width=100% height=200px
		alt="Toscane" src="images/right.jpg"> </header>
	<main> <article>
	<h1>Welcome</h1>

	<c:choose>
		<c:when test="${name==null }">
			<form method="post" action=Controller?action=logIn>
				<p>
					nickName: <input type="text" id="nickName" name="nickName"
						value="${nickName}">
				</p>
				<p>
					Password: <input type="password" id="password" name="password"
						value="${password}">
				</p>
				<p>
					<input type="submit" id="submit" value="logIn">
				</p>
			</form>
		</c:when>
		<c:otherwise>
			<p>dag ${name.nickName}</p>

			<form>
				<p>
					status: <input type="text" id="status" name="status">
				</p>
				<p>
					<input class="button" type="button" id="statusbutton"
						value="change status" onclick="changeStatus();">
				</p>

			</form>
			<form method="post" action=Controller?action=logOut>
				<input type="submit" value="logout">
			</form>
		</c:otherwise>
	</c:choose>

	<table id="tableFriends">

	</table>
	<button class="button1" id="friendbutton" onclick="showHideForm()">add
		a new friend</button>

	<form id="friendForm" style="display: none">
		<p>
			NickName: <input type="text" id="nickName" name="nickName">
		</p>
		<p>
			<input class="button" type="button" id="friendbutton"
				value="add friend" onclick="addNewFriend();">
		</p>

	</form>

	</article>
	<div id="divs">
	<div id="actorDiv">
		<h3>ActorBlog</h3>
		<p>Who is your favorite actor?</p>
		<div id="actorMessage"></div>
		<p>
			Name: <input type="text" id="namePersonForActor"
				name="namePersonForActor" required>
		</p>
		<p>
			Message: <input type="text" id="messagePersonForActor"
				name="messagePersonForActor" required>
		</p>
		<input class="button" type="button" id="actorButton"
			value="send message" onclick="sendActorMessage()">
	</div>
	
	<div id="holidayDiv">
		<h3>holidaysBlog</h3>
		<p>What is your favorite holiday destination?</p>
		<div id="holidayMessage"></div>
		<p>
			Name: <input type="text" id="namePersonForHoliday"
				name="namePersonForHoliday" required>
		</p>
		<p>
			Message: <input type="text" id="messagePersonForHoliday"
				name="messagePersonForHoliday" required>
		</p>
		<input class="button" type="button" id="holidayButton"
			value="send message" onclick="sendHolidayMessage()">
	</div>
	</div>
	</main>
</div>
</body>
</html>