login(contextPath)::="
<!DOCTYPE html>
<html>
<head>
	<meta charset='US-ASCII'>
	<title>Log In</title>
	<link href='$contextPath$css/bootstrap.min.css' rel='stylesheet' />
	<link rel='stylesheet' href='$contextPath$css/login.css' />
</head>
<body>

	<div class='navbar navbar-default navbar-static-top' role='navigation'>
		<div class='container'>
	    	<div class='navbar-header col-xs-12'>
     			<a class='navbar-brand' href='#'>
     				<span class='glyphicon glyphicon-headphones'></span> MusicBox
     			</a>
     			<a class='navbar-brand' href='#'>
     				<span class='glyphicon glyphicon glyphicon-th-list'></span>
     			</a>
     			<form class='navbar-form navbar-left' role='search'>
			          <input type='text' class='form-control' id='search' placeholder='Search'>
	        	</form>
		        <a class='navbar-brand navbar-right' href='#' id='login'>
		        	<span class='glyphicon glyphicon glyphicon-user'></span> Log In
		        </a>
			</div>
   		</div><!--- /.container -->
  	</div> <!-- /.navbar -->

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
				<img src='files/devices.png' width='300px'>
			</div>
		</div>
	</div>
	
	<div class='connection'>
		<div class='container'>
			<div class='col-sm-4'>
				<img src='files/facebook.png'>
				<img src='files/github.png'>
				<img src='files/twitter.png'>
				<img src='files/linkedin.png'>
				<img src='files/twitter.png'>
				<img src='files/facebook.png'>
				<img src='files/github.png'>
				<img src='files/facebook.png'>
				<img src='files/mail.png'>
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

	<div class='footer'>
		<div class='container'>
				Design with <span class='glyphicon glyphicon-heart'></span> in Seattle.
		</div>
	</div>

</body>
</html>
";