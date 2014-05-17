register(contextPath, month, day, year)::="
<div class='simplicity'>
 	<div class='container'>
    	<h1>Register</h1>
        <form method='post' action='$contextPath$register' role='form' class='form-horizontal'>
        	<div class='form-group'>
        		<label for='username' class='col-sm-2 control-label'>Username</label>
        		<div class='col-sm-10'>
        			<input type='text' class='form-control' id='username' name='username' placeholder='Username'>
        		</div>
        	</div>
        	
        	<div class='form-group'>
        		<label for='email' class='col-sm-2 control-label'>Email</label>
        		<div class='col-sm-10'>
        			<input type='text' class='form-control' id='email' name='email' placeholder='Email'>
        		</div>
        	</div>
        	
        	<div class='form-group'>
        		<label for='password' class='col-sm-2 control-label'>Password</label>
        		<div class='col-sm-10'>
        			<input type='password' class='form-control' id='password' name='password' placeholder='Password'>
        		</div>
        	</div>
        	
        	<div class='form-group'>
        		<label for='firstName' class='col-sm-2 control-label'>First Name</label>
        		<div class='col-sm-4'>
        			<input type='text' class='form-control' id='firstName' name='firstName' placeholder='First Name'>
        		</div>
        		
        		<label for='lastName' class='col-sm-2 control-label'>Last Name</label>
        		<div class='col-sm-4'>
        			<input type='text' class='form-control' id='lastName' name='lastName' placeholder='Last Name'>
        		</div>
        	</div>
        	
        	<div class='form-group'>
        		<label for='dob' class='col-sm-2 control-label'>Date of Birth</label>
        		<div class='col-sm-2'>
        			<select class='form-control' name='month'>
        				$month:{n|
        					<option value='$n.item$'>$n.item$</option>
        				}$
        			</select>
        		</div>
        		
        		<div class='col-sm-2'>
        			<select class='form-control' name='day'>
        				$day:{n|
        					<option value='$n.item$'>$n.item$</option>
        				}$
        			</select>
        		</div>
        		
        		<div class='col-sm-2'>
        			<select class='form-control' name='year'>
        				$year:{n|
        					<option value='$n.item$'>$n.item$</option>
        				}$
        			</select>
        		</div>
        	</div>
        	
        	<div class='form-group'>
        		<label for='gender' class='col-sm-2 control-label'>Gender</label>
        			<div class='col-sm-1'>
	        			<div class='radio'>
			        		<label>
			        			<input type='radio' name='gender' id='genderMale' value='m' checked>Male
			        		</lable>
			        	</div>
			        </div>
			        <div class='col-sm-1'>
	        			<div class='radio'>
			        		<label>
			        			<input type='radio' name='gender' id='genderFemale' value='f'>Female
			        		</lable>
			        	</div>
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
</div>
";