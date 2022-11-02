<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-10">Registration Form</h2>
			<h5 class="col-2 text-right">
				<a href="/DebateRegistration/logout">Logout</a>
			</h5>
		</div>
		<hr>
		<form action="/DebateRegistration/registration/register" method="POST">
			<div class="form-row">
				<input type="hidden" name="studentId" id="studentId"
					value="${student.studentId}">
				<div class="form-group col-md-4">
					<label for="name">Name</label> <input type="text"
						class="form-control" name="name" id="name" placeholder="Full Name"
						value="${student.name}" required>
				</div>
				<div class="form-group col-md-4 mt-2">
					<label for="department">Department</label> <input type="text"
						class="form-control" name="department" id="department"
						placeholder="Course Name" value="${student.department}" required>
				</div>
				<div class="form-group col-md-4 mt-2">
					<label for="country">Country</label> <input type="text"
						class="form-control" name="country" id="country"
						placeholder="Country Name" value="${student.country}" required>
				</div>
			</div>
			<input type="submit" class="btn btn-primary mt-2" value="Save" /> <input
				type="reset" class="btn btn-secondary mt-2" value="Clear" /> <a
				href="/DebateRegistration/registration/registrations"
				class="btn btn-warning mt-2">Registration List</a>
		</form>
	</div>


</body>
</html>