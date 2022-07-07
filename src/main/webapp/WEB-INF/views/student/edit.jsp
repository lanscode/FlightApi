<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student creation</title>
</head>
<body>
<form action="updated" method="post">
<pre>
<label for="name">Name  </label>
<input id="name" type="text" name="name" value="${student.name }">
<label for="select">Gender  </label>
<select id="select" name="gender">
	<option value="male" ${student.gender=='male'?'selected':''}> Male</option>
	<option value="female" ${student.gender=='female'?'selected':''}> Female</option>
	</select><br/>	
<label for="course">Course</label>
<input id="course" type="text" name="course" value="${student.course }">
<label for="fee">Fees</label>
<input id="fee" type="number" name="fee" value="${student.fee }">
<input id="id" type="hidden" name="id" value="${student.id }">
<input type="submit" name="Save"/>
</pre>
</form>
<span>${msg}</span><br>
<a href="index">View All</a>
</body>
</html>