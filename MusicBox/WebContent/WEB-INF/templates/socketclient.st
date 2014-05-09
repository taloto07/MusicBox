socketclient(contextPath)::="
	<div class='simplicity'>
		<div class='container'>
			<div class='col-xs-4'>
				<form role='form'>
					<div class='form-group'>
						<input type='text' class='form-control' id='textMessage' />
						<input class='btn btn-default' onclick='sendMessage();' type='button' value='Send' />
					</div>
				</form>
				<textarea class='form-control' rows='10' id='messageTextarea'></textarea>
			</div>
		</div>
	</div>
	<script type='text/javascript'>
		var webSocket = new WebSocket('ws://localhost:8080/MusicBox/serverendpointdemo/britney');
		var messageTextarea = document.getElementById('messageTextarea'); 
		
		webSocket.onopen = function(message){processOpen(message)};
		webSocket.onclose = function(message){processClose(message)};
		webSocket.onerror = function(message){processError(message)};
		webSocket.onmessage = function(message){processMessage(message)};
		
		
		function processMessage(message){
			messageTextarea.value += message.data + '\n';
		}
		
		function processOpen(message){
			messageTextarea.value += 'Server Connect...' + '\n';
		}
		
		function sendMessage(){
			var textMessage = document.getElementById('textMessage');
			if (textMessage.value != 'close'){
				webSocket.send(textMessage.value);
				textMessage.value = '';
			}else webSocket.close();
		}
		
		function processClose(message){
			webSocket.send('client disconnected...');
			messageTextarea.value += 'Server Disconnect...' + '\n';
		}
		
		function processError(message){
			messageTextarea.value += 'Error...' + '\n';
		}
	</script>
";