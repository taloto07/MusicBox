ajax(contextPath)::="
<div class='simplicity'>
 	<div class='container'>
    	<h1>AJAX Demo</h1>
    	<form id='ajaxForm' role='form' class='form-inline'>
	    	<div class='form-group'>
		    	<label>User name:</label>
		        <input type='text' id='txtUsername' name='txtUsername' class='form-control' />
		        <input type='button' id='btnSearch' name='btnSearch' value='Search' class='btn btn-default' />
	        </div>
        </form>
        
        <div id='displayInfo'>
        	Information replace here.
        </div>    
    </div>
</div>

<script>
	\$(document).ready(function(){
		\$('#btnSearch').click(function(){
			\$.ajax({
				url: 'ajaxrequest',
				type: 'POST',
				datatype: 'json',
				data: \$('#ajaxForm').serialize(),
				success: function(data){
					if (data.isValid){
						\$('#displayInfo').html('First name: ' + data.firstName + '<br/>');
						\$('#displayInfo').append('Last name: ' + data.lastName + '<br/>');
						\$('#displayInfo').append('Email: ' + data.email + '<br/>');
					}else{
						\$('#displayInfo').html(\$('#txtUsername').val() + ' not found.');
					}
				}
			});
		});
	});		     	   
</script>
 ";