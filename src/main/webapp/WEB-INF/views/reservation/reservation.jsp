<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body>
	<pre>
	<span> Airlines : ${flight.operatingAirlines }</span>
	<span> Departure City : ${flight.departureCity }</span>
	<span> Arrival City : ${flight.arrivalCity }</span>
	<span> Departure Time : ${flight.estimatedDepartureTime }</span>
 <form action="reservation" method="post">
	<input type="hidden" name="flightId" value="${flight.id }">
	<h3>Passenger details</h3>
	<label for="firstName">First Name  </label>
	<input id="firstName" type="text" name="firstName">
	<label for="lastName">Last Name</label>
	<input id="lastName" type="text" name="lastName">
	<label for="email">Email</label>
	<input id="email" type="text" name="email">
	<label for="phone">Phone</label>
	<input id="phone" type="text" name="phone">
	<input type="submit" value="Confirm">
  </form>
</pre>
</body>
</html>