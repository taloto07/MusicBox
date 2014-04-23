temp(contextPath, body, title)::="
<!DOCTYPE html>
<html>
<head>
	<meta charset='UTF-8'>
	<title>$title$</title>
	<link href='$contextPath$css/bootstrap.min.css' rel='stylesheet' />
	<link rel='stylesheet' href='$contextPath$css/login.css' />
</head>
<body>
	<div class='navbar navbar-default navbar-static-top' role='navigation'>
		<div class='container'>
	    	<div class='navbar-header col-xs-12'>
     			<a class='navbar-brand' href='$contextPath$'>
     				<span class='glyphicon glyphicon-headphones'></span> MusicBox
     			</a>
     			<a class='navbar-brand' href='#'>
     				<span class='glyphicon glyphicon glyphicon-th-list'></span>
     			</a>
     			<form class='navbar-form navbar-left' role='search'>
			          <input type='text' class='form-control' id='search' placeholder='Search'>
	        	</form>
		        <a class='navbar-brand navbar-right' href='$contextPath$login.html' id='login'>
		        	<span class='glyphicon glyphicon glyphicon-user'></span> Log In
		        </a>
			</div>
   		</div><!--- /.container -->
  	</div> <!-- /.navbar -->
  	
  	$body$
  	
  	<div class='footer'>
		<div class='container'>
				Design with <span class='glyphicon glyphicon-heart'></span> in Seattle.
		</div>
	</div>
</body>
</html>
";