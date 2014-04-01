body(user, followers, following, contextPath, url) ::= "
<div class='container'>
	<div class='col-sm-4'>
		url: $url$
		
		
		
		<ul class='list-group'>
			<li class='list-group-item'>$user$</li>
			<li class='list-group-item'>followers</li>
			$followers:{n| 
				<li class='list-group-item' style='padding-left:30px'>
					<a href='$contextPath$$n.user1.username$'>
						$n.user1.username$
					</a>
				</li>
			}$
			
			<li class='list-group-item'>following</li>
			$following:{n|
				<li class='list-group-item' style='padding-left:30px'>
					<a href='$contextPath$$n.user2.username$'>
						$n.user2.username$
					</a>
				</li>
			}$
		</ul>
	</div>
</div>	
";