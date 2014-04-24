sse(contextPath)::="
<div class='simplicity'>
 	<div class='container'>
    	<h1>Current Server Time  : </h1>
        <div id='ServerTime'></div>
    </div>
</div>
<script>
        if (typeof (EventSource) !== 'undefined') {
                var source = new EventSource('http://localhost:8080/MusicBox/sse');
                source.onmessage = function(event) {
                document.getElementById('ServerTime').innerHTML += event.data + '<br><br>';
                };
        } else {
                document.getElementById('ServerTime').innerHTML = 'Sorry, your browser does not support server-sent events...';
        }
 </script>
 ";