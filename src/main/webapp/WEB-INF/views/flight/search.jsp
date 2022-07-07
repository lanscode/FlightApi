<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search flight</title>
</head>
<body>
<form action="flighs" method="post">
<pre>
<label for="departureCity">From  </label>
<input id="departureCity" type="text" name="departureCity">
<label for="arrivalCity">To</label>
<input id="arrivalCity" type="text" name="arrivalCity">
<label for="dateOfDeparture">Departure Date</label>
<input id="dateOfDeparture" type="text" name="dateOfDeparture">
<input type="submit" name="Search"/>
</pre>
</form>
</body>
</html>