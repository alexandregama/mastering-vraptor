<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="js/jquery.ui.widget.js"></script>
	<script src="js/jquery.iframe-transport.js"></script>
	<script src="js/jquery.fileupload.js"></script>
	<script src="js/upload-file.js"></script>
	
</head>
<body>
	<div>
		${uploadSuccess}
	</div>
	
	Upload a file in a simple form <br>
	<form action="${linkTo[ImageUploadController].upload}" enctype="multipart/form-data" method="post">
		<input type="file" name="image"/><br/><br/>
		
		<input type="submit" value="Upload this File"/>
	</form>
	
	------------------------------------------------- <br/><br/>
	
	Upload a file using Ajax <br>
	<form enctype="multipart/form-data" method="post">
		<input id="fileupload" type="file" name="image" data-url="images/upload/ajax" multiple>
	</form>
	<img id="image-uploaded" src=""><br/>
	
	------------------------------------------------- <br/><br/>
	
	Upload a file using Ajax and sending to S3 <br>
	<form enctype="multipart/form-data" method="post">
		<input id="fileupload-ajax-s3" type="file" name="image" data-url="images/upload/ajax/s3" multiple>
	</form>
	<img id="image-uploaded-to-s3" src=""><br/>
</body>
</html>