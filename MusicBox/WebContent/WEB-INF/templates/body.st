body(object) ::= "
<div class='container'>
	<div class='col-sm-4'>
		<ul class='list-group'>
			$object:{n| 
				<li class='list-group-item'>$n.id$ $n.title$</li>
			}$
		</ul>
	</div>
</div>	
";