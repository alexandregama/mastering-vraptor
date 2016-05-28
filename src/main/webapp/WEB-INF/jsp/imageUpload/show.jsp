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
	
	<p>
	Upload a file in a simple form <br>
	<form action="${linkTo[ImageUploadController].upload}" enctype="multipart/form-data" method="post">
		<input type="file" name="image"/><br/><br/>
		
		<input type="submit" value="Upload this File"/>
	</form>
	<p>
	
	------------------------------------------------- <br/>
	
	<p>
	Upload a file in a simple form <br>
	<form enctype="multipart/form-data" method="post">
		<input id="fileupload" type="file" name="image" data-url="images/upload/ajax" multiple>
	</form>
	</p>
</body>
</html>