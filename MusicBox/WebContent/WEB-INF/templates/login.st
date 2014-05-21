login(contextPath)::="
   <div class='jumbotron slogan'>
  		<div class='text'>
			<h2> Log In </h2>
		</div>
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
		      		<button type='submit' class='btn btn-default'>Register</button>
		      		<button type='reset' class='btn btn-default'>Reset</button>
		    	</div>
		  	</div>
		</form>
	</div>
   
   <div class='jumbotron slogan'>
  		<div class='text'>
			<h1> Welcome to MusicBox Mark I</h1>
			<h2> Get your Mix out to the world.</h2>
		</div>
		<div class='btn-group'>
			<a href='#' role='button' class='btn btn-primary btn-lg'>Sign in with Facebook</a>
			<a href='#' role='button' class='btn btn-danger btn-lg'>Sign in with Google</a>
		</div>
		<h3>
			Sign up with email. By clicking 'Sign in', you agree to our Terms of Service.
		</h3>
	</div>

	<div class='simplicity'>
		<div class='container'>
			<div class='col-sm-8'>
				<h1>Discover Music you'll love.</h1>
				<p>
					MusicBox is the best place to discover music. Your Discover page will constantly suggest 
					new music for you, based on what you are listening to. Your next favourite mixes are waiting.
				</p>
			</div>
			<div class='col-sm-4'>
				<img src='$contextPath$files/devices.png' width='300px'>
			</div>
		</div>
	</div>
	
	<div class='connection'>
		<div class='container'>
			<div class='col-sm-4'>
				<img src='$contextPath$files/facebook.png'>
				<img src='$contextPath$files/github.png'>
				<img src='$contextPath$files/twitter.png'>
				<img src='$contextPath$files/linkedin.png'>
				<img src='$contextPath$files/twitter.png'>
				<img src='$contextPath$files/facebook.png'>
				<img src='$contextPath$files/github.png'>
				<img src='$contextPath$files/facebook.png'>
				<img src='$contextPath$files/mail.png'>
			</div>
			<div class='col-sm-8'>
				<h1>Music brings us together.</h1>
				<p>
					 That is why MusicBox is so social. Share music on Facebook, Twitter, your blog, anywhere. You can also get
					 closer to the friends, artists and trendsetters who turn you on to great music. 
					 Find out what they are listening to right now.
				</p>
			</div>
		</div>
	</div>
";