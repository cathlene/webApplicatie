var getObject = new XMLHttpRequest();
var postObject = new XMLHttpRequest();
var OK = 200;
var COMPLETE = 4;

function addNewFriend(){
	var nickName = document.getElementById("nickName").value;
	var status = document.getElementById("status").value;
	postObject.open("POST", "Controller?action=addNewFriend", true);
	postObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	postObject.send("nickName="+nickName+"&status="+status);
	document.getElementById("friendForm").style.display="none";

}

function begin(){
	
	loadFriends();
	openActorSocket();
	openHolidaySocket();
}
function changeStatus(){
	var status= document.getElementById("status").value;
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
			var toReturn = "<tr><th>nickname</th><th>status</th></tr>";
			for(var i in friends){
				toReturn += "<tr><td id=nickname>" + // dus wat is het probleem weer? :p XD haha oke hier
				friends[i].nickName +
				"</td><td>" +
				friends[i].status +
				"</td><td>"+
				"<button onclick=showMessage();>Stuur bericht</button>" +
				"</td><td></tr>"; 

			}
			document.getElementById("tableFriends").innerHTML = toReturn;
			setTimeout("loadFriends()", 1000);
		}}


}

function showMessage(){

	document.getElementById("wrapper").style.display="inline-block";
}

function showHideForm(){

	document.getElementById("friendForm").style.display="block";
}


