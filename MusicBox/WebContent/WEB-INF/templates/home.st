home(contextPath) ::= "
<div class='simplicity'>
	<div class='container'>
		<div class='row'>
			<div class='col-sm-12'>
				This is home page <br/>
				This is home page <br/>
				Conflicting ahead of us. <br/>
				This is home page <br/>
				cham change this.<br/>
	            <div class='btn-group'>
	                <a href='$contextPath$test/' class='btn btn-danger' role='button'>test</a>
	                <a href='$contextPath$login.html' class='btn btn-success'role='button'>login page</a>
	                <a href='$contextPath$form.html' class='btn btn-info' role='button'>Upload File</a>
	                <a href='$contextPath$socketclient.html' class='btn btn-default' role='button'>Websocket Demo</a>
	                <a href='$contextPath$sse.html' class='btn btn-warning' role='button'>Server Send Events Demo</a>
	                <a href='$contextPath$ajax.html' class='btn btn-info' role='button'>AJAX Demo</a>
	                <a href='$contextPath$registerform' class='btn btn-default' role='button'>Register Demo</a>
	            </div>
            </div>
		</div>
        
        <br />
		
		<div class='row'>
			<div class='col-sm-4'>
            	<img src='$contextPath$image/photo.jpg' class='img-circle' />
            </div>
            
            <div class='col-sm-4'>
            	<img src='$contextPath$image/photo.jpg' class='img-rounded' />
            </div>
            
            <div class='col-sm-4'>
            	<img src='$contextPath$image/photo.jpg' class='img-thumbnail' />
            </div>
            
            <div class='row'>
            	<div class='col-sm-4'>
            		<embed height='50' width='100' src='$contextPath$mp3/ounpig.mp3'>
            	</div>
            </div>
        </div>
    </div>
</div>
";