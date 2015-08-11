<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
<a href="/HelloMaven/addnewstudent">new student</a>
   <table class="table table-condensed">
   <tr>
   	<td>Name</td>
   	<td>Age</td>
   	<td>ID</td>
   </tr>
 <c:forEach begin="0" end="${fn:length(students) -1}" var="index">
 <tr>
      <td><c:out value="${students[index].name}" /></td>
      <td><c:out value="${students[index].age}" /></td>
      <td><c:out value="${students[index].id}" /></td>
      <td>
      	<a href="/HelloMaven/deleteStudent?id=<c:out value="${students[index].id }"/>">
      	<input type="button" value="Delete" class="btn btn-warning"/>
      	</a>
      	<a href="/HelloMaven/updating?id=<c:out value ="${students[index].id }"/>&name=<c:out value= "${students[index].name }"/>&age=<c:out value= "${students[index].age }"/>">
      	<input type="button" value="Update" class="btn btn-infor"/>
      	</a>
      </td>
      </tr>
  </c:forEach>
</table>  
</body>
</html>