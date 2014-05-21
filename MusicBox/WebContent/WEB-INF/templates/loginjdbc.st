loginjdbc(contextPath, errorMessage)::="	
	<div class='jumbotron slogan'>
		<div class='text'>
			<h2> Log In </h2>
		</div>
		$if(errorMessage)$
			<div class='alert alert-danger'>$errorMessage$</div>
		$endif$
		
		<form method='post' action='j_security_check' role='form' class='form-horizontal'>
        	<div class='form-group'>
        		<label for='username' class='col-sm-2 control-label'>Username</label>
        		<div class='col-sm-10'>
        			<input type='text' class='form-control' id='username' name='j_username' placeholder='Username'>
        		</div>
        	</div>
        	
        	<div class='form-group'>
        		<label for='email' class='col-sm-2 control-label'>Password</label>
        		<div class='col-sm-10'>
        			<input type='text' class='form-control' id='email' name='j_password' placeholder='Password'>
        		</div>
        	</div>
        	
			<div class='form-group'>
		    	<div class='col-sm-offset-2 col-sm-10'>
		      		<button type='submit' class='btn btn-default'>Login</button>
		      		<button type='reset' class='btn btn-default'>Reset</button>
		    	</div>
		  	</div>
		</form>
	</div>
";