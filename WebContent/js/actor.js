var webActorSocket;
var actorMessages;

function openActorSocket() {
	if (webActorSocket !== undefined && webActorSocket.readyState !== WebSocket.CLOSED) {
		return;
	}
	webActorSocket = new WebSocket("ws://localhost:8080/ProjectWebapplicatie/actor");
	actorMessages = document.getElementById("actorMessage");

	// webSocket.onopen = function(event){
	// writeResponse("Connection opened")
	// };

	webActorSocket.onmessage = function(event) { // messageEvent object
		writeActorResponse(event.data); // dit is de text
	};

	// webSocket.onclose = function(event){
	// writeResponse("Connection closed");
	// };
}

function sendActorMessage() {
	var name = document.getElementById("namePersonForActor").value;
	var message = document.getElementById("messagePersonForActor").value;
	var text = name + ": " + message;
	webActorSocket.send(text);
}

function closeSocket() {
	webActorSocket.close();
}

function writeActorResponse(text) {
	actorMessages.innerHTML += "<p>"+text+"</p>";
}