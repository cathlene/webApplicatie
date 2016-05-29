
var getObject = new XMLHttpRequest();
var postObject = new XMLHttpRequest();
var OK = 200;
var COMPLETE = 4;

function addNewFriend(){
	var nickName = document.getElementById("nickName").value;
	var status=document.getElementById("status").value;
	if(0===status.length){
		status=document.getElementById("statusSelect").value
	}
	postObject.open("POST", "Controller?action=addNewFriend", true);
	postObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	postObject.send("nickName="+nickName+"&status="+status);
	document.getElementById("friendForm").style.display="none";

}

function changeStatus(){
	var status= document.getElementById("status").value;
	postObject.open("POST", "Controller?action=changeStatus", true);
	postObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	postObject.send("status="+status);

}
function changeStatusSelect(){
	var status= document.getElementById("statusSelect").value;
	postObject.open("POST", "Controller?action=changeStatus", true);
	postObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	postObject.send("status="+status);

}
function loadFriends(){
	getObject.open("GET","Controller?action=overviewFriends",true);
	getObject.onreadystatechange=createFriendTable;
	getObject.send();
}

function createFriendTable(){
		if (getObject.status == OK) {
		if (getObject.readyState == COMPLETE) {
			var serverResponse = JSON.parse(getObject.responseText);
			var friends= serverResponse.friends;
			var tableFriends = document.getElementById("tableFriends");
			var toReturn = tableFriends.innerHTML || "<tr><th>nickname</th><th>status</th></tr>";
			for(var i in friends){
				if (document.getElementById(friends[i].nickName))
					continue; // Friend bestaat al, hoeft niet opnieuw aangemaakt te worden
				//toReturn += "<tr><td id="+friends[i].nickName+">"+ 
				toReturn += "<tr><td>"+ 
				friends[i].nickName +
				"</td><td>" +
				friends[i].status +
				"</td><td>"+
				"<button class=messageButton id="+friends[i].nickName+" onclick=showMessage(event)>messages</button>" +
				"</td><td></tr>"; 

			}
			if (tableFriends)
				tableFriends.innerHTML = toReturn;
			setTimeout("loadFriends()", 1000);
		}}


}

function showMessage(event){ // wanneer er op de knop messages wordt gedrukt, krijg je de id vd knop mee via event. Dit heb je nodig voor het message verkeer te regelen, je wil weten wie de target is
	var idhouder=event.target.id;
	document.getElementById("wrapper").style.display="inline-block";
	window.idhouder= idhouder; // maak de locale variablen globaal zoda ik er in mijn chat.js ook aankan
	start();
}

function showHideForm(){

	document.getElementById("friendForm").style.display="block";
}


