/*$(document).ready(function() { //=== execute die function on load van document
 $("#submitmsg").click(function(){
 $clientmessage = $("#usermsg").value;
 $.post("ChatServlet", {clientmessage:$clientmessage},function(data){
 var div = document.getElementById('chatbox');
 div.innerHTML = div.innerHTML + data;


 });
 });
 });*/
 
function changeColor() { //change color button when new message
	 var nickNameElement= idhouder;
	 
		$.ajax({
			type : "GET",
			url : "Controller?action=hasNewMessage&nickname="+nickNameElement,
			dataType : "json",
			success : function(data) {
				// kijk of hasNewMessages true is?
				var newMessage=data.newMessage;
				var user= data.user;
				if(newMessage===true){
					document.getElementById(nickNameElement).classList.add("hasMessages");
				}

				$(".messageButton").click(function(e) {  
					document.getElementById(nickNameElement).classList.remove("hasMessages");
	
				});
				
			}});
		 }



function updateChat() {
	var  nickNameElement=idhouder; // de globale variabele , dit is de id van mijn target
	$.ajax({
		type : "GET",
		url : "Controller?action=getMessages&nickname="+nickNameElement,
		dataType : "json",
		success : function(data) {
				var messages = data.messages; // data kan je terugvinden in de servlet
				if (messages){
					$('#chatbox')[0].innerHTML = ""; // clear text
					for(var i in messages){
						var msg = messages[i].message;
						if (!msg) continue;
						$('#chatbox').append(msg + "<br/>");
						$('#chatbox').css("color", "#66CC00"); //fancy
					}
				}

				//changeColor();
				setTimeout(updateChat, 10000);
		},
		error : function(e) {
			alert("An error occurred while processing json file.");
		}
	});

};

// send the message
function sendChat() {
	var clientbericht = document.getElementById("usermsg").value;// $("#usermsg").value;
	var  ontvanger=idhouder;

	//var ontvanger=document.getElementById("nickname").innerHTML;
	$.ajax({
		type : "POST",
		url : "Controller", // params met url meegeven is get!!! dus geef mee via action bij data
		data : {
			action: "message", message : clientbericht, nickname : ontvanger
		},
		success : function(data) { // zelfde data als bij polling zodat stel
									// wanneer je berichtje stuurt dat je geen 10
									// sec moet wachten vooraleer je dat ziet in
									// de lijst
			updateChat();
		},
		error : function(e) {
			alert("An error occurred wile sending message.");

		}
	});
}
$(document).ready(function(e) {
	$("#submitmsg").click(function(e) { // wanneer je op de knop send duwt 
		sendChat();
		e.preventDefault();
	});
});

$(document).ready(function(){
		$("#submitmsg").click(function(){
		$(".welcome").css("color", "red"); //fancy
		
		setTimeout(function() {
	        $(".welcome").css("color", "black"); // change it back after ...
	    }, 5000); // waiting one second
		});
});

function start(){
	$('.welcome')[0].innerHTML = "";
	$(".welcome").append("chatting with "+idhouder);	
		updateChat();
		//e.preventDefault();
}

