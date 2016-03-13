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
				toReturn += "<tr><td>" +
				friends[i].nickName +
				"</td><td>" +
				friends[i].status +
				"</td><td></tr>"; 

//				var nickNameText = friends[i].nickName;
//				var nickName = document.createTextNode(nickNameText);
//				var statusText = friends[i].status;
//				var status = document.createTextNode(statusText);

//				var nickNameId = document.createElement('td');
//				nickNameId.appendChild(nickName);
//				var statusId = document.createElement('td');
//				statusId.appendChild(status);

//				var friendsTr = document.createElement('tr');
//				friendsTr.appendChild(nickNameId);
//				friendsTr.appendChild(statusId);


			}
			document.getElementById("tableFriends").innerHTML = toReturn;
			setTimeout("loadFriends()", 1000);
		}}


}

function showHideForm(){

	document.getElementById("friendForm").style.display="block";
}

function hideForm(){
}

