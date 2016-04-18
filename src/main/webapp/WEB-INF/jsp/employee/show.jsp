<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkTo[EmployeeController].save}" method="post">
		FirstName: <br/>
		<input type="text" name="employee.firstname"/><br/>
		
		Department: <br/>
		<input type="text" name="employee.department"/> <br/>

		--------------------- <br/>
		
		Customer FirstName <br/>
		<input type="text" name="customer.firstName"/><br/>
		
		Customer LastName <br/>
		<input type="text" name="customer.lastName"/><br/>
		
		<input type="submit" value="Save Both"/>
	</form>
</body>
</html>