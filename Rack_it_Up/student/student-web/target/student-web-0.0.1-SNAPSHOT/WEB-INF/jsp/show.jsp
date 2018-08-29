<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.Cookie" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sutent Information System</title>
</head>
<body>
<h3>Student Information System</h3>
<%
	Cookie []cookies = request.getCookies();
	String name="";
			for(Cookie cookie:cookies)
				if(cookie.getName().equalsIgnoreCase("UNAME")){
					name=cookie.getValue();
				}

 %>
 <h4>Hi <%=name%></h4>
<form action="/student-web-0.0.1-SNAPSHOT/signout">
<table border="2" width="70%" cellpadding="2">
   <tr><th>Id</th><th>Name</th><th>Age</th><th>Gender</th><th>Class and Section</th></tr>  
   <c:forEach var="student" items="${list}">   
   <tr>  
   <td>${student.id}</td>  
   <td>${student.name}</td>  
   <td>${student.age}</td>  
   <td>${student.gender}</td>
   <td>${student.classandsec}</td>
   </tr>  
   </c:forEach>  
</table>
<input type="Submit" value = "Signout">
<form>
<a href="/student-web-0.0.1-SNAPSHOT/delete">Delete and Signout</a>
</body>
</html>