template(contextPath, title, body) ::= "
<!DOCTYPE html>
<html>
	<head>
		<meta charset='utf-8'>
		<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	    <meta name='viewport' content='width=device-width, initial-scale=1'>
	    
	    <title>$title$</title>
	    
	    <!-- CSS Bootstrap -->
	    <link href='$contextPath$css/bootstrap.css' rel='stylesheet'>
	</head>
<body>
	<div class='navbar navbar-inverse navbar-static-top' role='navigation'>
		<div class='container'>
	    	<div class='navbar-header'>
 				<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-collapse'>
       				<span class='sr-only'>Toggle navigation</span>
          			<span class='icon-bar'></span>
          			<span class='icon-bar'></span>
           			<span class='icon-bar'></span>
      			</button>
       			<a class='navbar-brand' href='$contextPath$'>Movie Project</a>
			</div>
					
      		<div class='navbar-collapse collapse'>
  				<ul class='nav navbar-nav'>
	   				<li><a href='#'>Khmer</a></li>
	   				<li><a  class='active' href='#'>Thai</a></li>
	   				<li class='dropdown'>
	   					<a href='#' class='dropdown-toggle' data-toggle='dropdown'>China<b class='caret'></b></a>
	   					<ul class='dropdown-menu'>
	   						<li><a href='#'>Drama</a></li>
	   						<li><a href='#'>Comedy</a></li>
	   						<li class='divider'><li>
	   						<li><a href='#'>News</a></li>
	   					</ul>
	   				</li>
       			</ul>
	          			
      			<ul class='nav navbar-nav navbar-right'>
   					<li><a href='#'>Log in</a></li>
       			</ul>
       		</div><!--/.navbar-collapse -->
   		</div><!--- /.container -->
   	</div> <!-- /.navbar -->
	contextPath: $contextPath$
	$body$

	<script src='https://code.jquery.com/jquery-1.10.2.min.js'></script>
    <script src='$contextPath$js/bootstrap.min.js'></script>
</body>
</html>
";