<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User login</title>
</head>
<body>
<form action="auth" method="post">
<pre>
<label for="email">Email  </label>
<input id="email" type="text" name="email">

<label for="password">Password</label>
<input id="password" type="password" name="password">

<input type="submit" name="Save"/>
</pre>
</form>
<span>${errorMsg}</span>
</body>
</html>