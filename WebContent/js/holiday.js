 			var holidyWebSocket;
            var holidayMessages;
           
            function openHolidaySocket(){
                if(holidyWebSocket !== undefined && holidyWebSocket.readyState !== WebSocket.CLOSED){
                    return;
                }
                holidyWebSocket = new WebSocket("ws://localhost:8080/ProjectWebapplicatie/holiday");
                holidayMessages = document.getElementById("holidayMessage");
                 
//                webSocket.onopen = function(event){
//                    writeResponse("Connection opened")
//                };
 
                holidyWebSocket.onmessage = function(event){
                	writeHolidayResponse(event.data);
                };
 
//                webSocket.onclose = function(event){
//                    writeResponse("Connection closed");
//                };
            }
           
            function sendHolidayMessage(){
                var name = document.getElementById("namePersonForHoliday").value;
                var message = document.getElementById("messagePersonForHoliday").value;
                var text= name + ": "+ message;
                holidyWebSocket.send(text);
            }
           
            function closeSocket(){
            	holidyWebSocket.close();
            }
 
            function writeHolidayResponse(text){
            	holidayMessages.innerHTML += "<p>"+text+"</p>";
            }