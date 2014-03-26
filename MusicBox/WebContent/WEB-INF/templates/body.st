body(object, contextPath, url) ::= "
<div class='container'>
	<div class='col-sm-4'>
		url: $url$
		<ul class='list-group'>
			$object:{n| 
				<li class='list-group-item'>$n.id$ $n.title$ <a href='$contextPath$test/$n.id$'>Delete</a></li>
			}$
		</ul>
	</div>
</div>	
";