body(user, followers, following, contextPath, url) ::= "
<div class='container'>
	<div class='col-sm-4'>
		url: $url$
		
		
		
		<ul class='list-group'>
			<li class='list-group-item'>$user$</li>
			<li class='list-group-item'>followers</li>
			$followers:{n| 
				<li class='list-group-item'>$n.user1.username$</li>
			}$
			
			<li class='list-group-item'>following</li>
			$following:{n|
				<li class='list-group-item'>$n.user2.username$</li>
			}$
		</ul>
	</div>
</div>	
";