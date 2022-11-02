<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1 class="display-4" style="color: #B4161B">
				<b>Error</b>
			</h1>
			<p class="lead text-danger">
				<b>${msg}</b>
			</p>
			<hr class="my-4">
			<p class="lead">
				<a class="btn btn-warning btn-md"
					href="/DebateRegistration/registration/registrations" role="button">Back
					to List</a>
			</p>
		</div>
	</div>
</body>
</html>