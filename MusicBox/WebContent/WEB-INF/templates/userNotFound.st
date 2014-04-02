userNotFound(username, users, contextPath) ::= "
<div class='container'>
	<div class='col-sm-4'>
		This \"$username$\" username doesn't exist.
		<br/> contextPath: $contextPath$
		<ul class='list-group'>
			$users:{n|
				<li class='list-group-item'>
					<a href='$contextPath$test/$n.username$'>
						$n.username$
					</a>
				</li>
			}$
		</ul>
	</div>
</div>	
";