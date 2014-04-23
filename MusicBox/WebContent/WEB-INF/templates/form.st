form(contextPath) ::= "
	<div class='simplicity'>
		<div class='container'>
			<div class='col-xs-6'>
				<form name='upload_file_form' method='post' action='UploadFile' enctype='multipart/form-data' role='form'>
					<div class='form-group'>
						<label>
							<input type='checkbox' name='vehicle' value='Bike'>I have a bike
						</label>
						<label>
							<input type='checkbox' name='vehicle' value='Car'>I have a car
						</label>
					</div>
					<div class='form-group'>
						<label>
							<input type='radio' name='sex' value='male'>Male<br>
						</label>
						<label>
							<input type='radio' name='sex' value='female'>Female<br>
						</label>
					</div>
					<div class='form-group'>
						<label>Text Area</label>
						<textarea class='form-control' rows='3' name='comment'></textarea>
					</div>
					<div class='form-group'>
						<label>Uploader Name</label> 
						<input type='text' class='form-control' name='uploaderName' />
					</div>
					<div class='form-group'>
						<label>File</label>
						<input type='file' name='file' />
					</div>
					<button type='submit' class='btn btn-default'>Upload</button>
				</form>
			</div>
		</div>
	</div>
";