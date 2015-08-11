<%@page import="com.tutorialspoint.Student"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
   <table>
   <tr>
        <td>Name</td>
    </tr>
    <tr>
        <td>Age</td>
    </tr>
    <tr>
        <td>ID</td>
    </tr>
 <c:forEach begin="0" end="${fn:length(students) -1}" var="index">
   	 <tr>
      <td><c:out value="${students[index].name}" /></td>
    </tr>
    <tr>
      <td><c:out value="${students[index].age}" /></td>
    </tr>
    <tr>
      <td><c:out value="${students[index].id}" /></td>
    </tr>
  </c:forEach>
</table>  
</body>
</html>