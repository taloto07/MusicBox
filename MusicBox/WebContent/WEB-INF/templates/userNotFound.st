userNotFound(username, users, contextPath) ::= "
<div class='simplicity'>
	<div class='container'>
		<div class='col-xs-4'>
			This \"$username$\" username doesn't exist.
			<br/> User not found contextPath: $contextPath$
			<table class='table table-hover table-striped'>
				<tr class='info'>
					<td>Username</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>DOB</td>
					<td>Member since</td>
				</tr>
				$users:{n|
					<tr>
						<td><a href='$contextPath$test/$n.username$'>$n.username$</a></td> 
						<td>$n.firstName$</td> 
						<td>$n.lastName$</td> 
						<td>$n.email$</td> 
						<td>$n.dob$</td> 
						<td>$n.createDate$</td>
					</tr>
				}$
			</table>
		</div>
	</div>	
</div>
";