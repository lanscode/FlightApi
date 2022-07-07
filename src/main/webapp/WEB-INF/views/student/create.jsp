<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student creation</title>
</head>
<body>
<form action="create" method="post">
<pre>
<label for="name">Name  </label>
<input id="name" type="text" name="name">
<label for="select">Gender  </label>
<select id="select" name="gender">
	<option value="male"> Male</option>
	<option value="female"> Female</option>
	</select><br/>	
<label for="course">Course</label>
<input id="course" type="text" name="course">
<label for="fee">Fees</label>
<input id="fee" type="number" name="fee">
<input type="submit" name="Save"/>
</pre>
</form>
<span>${msg}</span><br>
<a href="index">View All</a>
</body>
</html>