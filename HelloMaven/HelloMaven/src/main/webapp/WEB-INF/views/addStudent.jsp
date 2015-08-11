<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new student</title>
</head>
<h2>Student information</h2>
<body>
<form:form method="POST" action="/HelloMaven/addingStudent" modelAttribute="student">
	<table>
		<tr>
			<td>
				<form:label path="name">Name</form:label>
			</td>
			<td>
				<form:input path="name"></form:input>			
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="age">Age</form:label>
				
			</td>
			<td>
				<form:input path="age"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="submit"/>
			</td>
		</tr>	
	</table>
</form:form>
</body>
</html>