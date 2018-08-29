<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
<script type="text/javascript">
function clear(){
	document.getElementbyId("name").value="";
	document.getElementbyId("id").value="";
	document.getElementbyId("age").value="";
	document.getElementbyId("gender").value="";
	document.getElementbyId("class").value="";
	document.getElementbyId("password").value="";
}
</script>
</head>
<body>
<h3>Signup</h3>
<form method="post" action="/student-web-0.0.1-SNAPSHOT/addme">
<table border="1">
<tr><th>Name</th><td><input type="text" name="name" id="name"></td></tr>
<tr><th>Id</th><td><input type="text" name="id" id="id"></td></tr>
<tr><th>Age</th><td><input type="text" name="age" id="age"></td></tr>
<tr><th>Gender</th><td><input type="text" name="gender" id="gender"></td></tr>
<tr><th>Class and Section</th><td><input type="text" name="classandsec" id="class"></td></tr>
<tr><th>Password</th><td><input type="password" name="password" id="password"></td></tr>
<tr><td><input type="submit" value="Submit"></td><td><input type="button" onclick="clear();" value="Clear"></td></tr>
</table>
</form>
</body>
</html>