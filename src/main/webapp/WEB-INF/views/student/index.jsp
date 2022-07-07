<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student creation</title>
</head>
<body>
<table>
<tr>
 <th>Name</th>
  <th>Gender</th>
  <th>Course</th>
  <th>Fees</th>
</tr>
<c:forEach items="${students }" var = "student">
<tr>
  <td>${student.name }</td>
  <td>${student.gender }</td>
  <td>${student.course }</td>
  <td>${student.fee }</td>
    <td><a href= "updateForm?id=${student.id }">Update</a></td>
 </tr>
</c:forEach>
</table>
<br>
<a href="create">Add new</a>
</body>
</html>