<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrations</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-10">Registrations</h2>
			<h5 class="col-2 text-right">
				<a href="/DebateRegistration/logout">Logout</a>
			</h5>
		</div>
		<hr>
		<a href="/DebateRegistration/registration/registration-form"
			class="btn btn-success btn-sm">Register</a>
		<div class="mt-3 table-responsive">
			<c:choose>
				<c:when test="${Registrations.size() > 0}">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th scope="col">Student Id</th>
								<th scope="col">Name</th>
								<th scope="col">Department</th>
								<th scope="col">Country</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${Registrations}" var="registration">
								<tr>
									<td><c:out value="${registration.studentId}" /></td>
									<td><c:out value="${registration.name}" /></td>
									<td><c:out value="${registration.department}" /></td>
									<td><c:out value="${registration.country}" /></td>
									<td><a class="btn btn-sm btn-primary"
										href="/DebateRegistration/registration/update-registration-form?studentId=${registration.studentId}">Update</a>&nbsp;|&nbsp;<a
										class="btn btn-sm btn-danger"
										href="/DebateRegistration/registration/delete-registration?studentId=${registration.studentId}"
										onclick="return confirm('Are you sure you want to delete student registration - ${registration.name}?')">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<h4 style="color: #383CC1">Click on Registration Button for
						Registration</h4>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>