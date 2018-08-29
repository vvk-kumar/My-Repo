<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function fun(){
	document.loginform.action="/student-web-0.0.1-SNAPSHOT/signup";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information System</title>
</head>
<body>
<form name="loginform" method="post" action="/student-web-0.0.1-SNAPSHOT/signin">
<h3>Login</h1>
<table border="3" bordercolor="bule">
<th>UserName</th>
<tr><td><input type="text" name="uname"/></td></tr>
<th>Password</th>
</tr><td><input type="password" name="password"/></td></tr>
</table>
<input type="submit" value="login">
<input type="submit" onclick="fun();" value="signup">
</form>

</body>
</html>