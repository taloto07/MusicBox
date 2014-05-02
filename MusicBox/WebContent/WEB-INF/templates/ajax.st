ajax(contextPath)::="
<div class='simplicity'>
 	<div class='container'>
    	<h1>AJAX</h1>
    	<form id='ajaxForm'>
	    	<div class='form-group'>
		    	<label>
		        	User name:
		        	<input type='text' id='txtUsername' name='txtUsername' class='form-control' />
		        	<input type='button' value='Search' id='btnSearch' class='btn btn-default' /> 
		        </label>
	        
	        </div>
        </form>
        
        <div id='displayInfo'>
        	User info
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