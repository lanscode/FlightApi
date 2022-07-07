<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User registration</title>
</head>
<body>
<form action="registerUser" method="post">
<pre>
<label for="firstName">First Name  </label>
<input id="firstName" type="text" name="firstName">

<label for="lastName">Last Name  </label>
<input id="lastName" type="text" name="lastName">

<label for="email">Email  </label>
<input id="email" type="text" name="email">

<label for="password">Password</label>
<input id="password" type="password" name="password">


<input type="submit" name="Save"/>
</pre>
</form>
</body>
</html>