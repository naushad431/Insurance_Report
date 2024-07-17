<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Generator</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>


	<div class="container">
		<h1 class="text-center pb-3 pt-3">Report Generator :</h1>


		<form:form action="search" modelAttribute="search" method="POST">

			<table>
				<tr>
					<td>Plan Name :</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${plans}" />
						</form:select></td>
					<td class="pt-3">Plan Status</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}" />
						</form:select></td>

					<td>Gender :</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="FeMale">Female</form:option>
						</form:select></td>

				</tr>

				<tr>
					<td>Start Date</td>
					<td><form:input type="date" path="startDate" /></td>
					<td>End Date</td>
					<td><form:input type="date" path="endDate" /></td>
				</tr>

				<tr>

					<td><input type="submit" value="Search"
						class="btn btn-primary" /></td>
						<td><input type="reset" value="Reset"
						class="btn btn-secondary"/></td>
				</tr>
			</table>
		</form:form>

		<hr />
		<hr />

		<table class="table table-striped-column">

			<thead>
				<tr>

					<th>ID</th>
					<th>HOLER NAME</th>
					<th>GENDER</th>
					<th>PLAN NAME</th>
					<th>PLAN STATUS</th>
					<th>START DATE</th>
					<th>END DATE</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach items="${plan}" var="plan" varStatus="index">

					<tr>

						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						
					</tr>

				</c:forEach>
				
				<tr>
				
				<c:if test="${empty plan}">
				
				<td colspan="8" style="text-align: center">No Record Found</td>
				
				</c:if>
				
				</tr>

			</tbody>
		</table>

		Export : <a href="excel">Excel</a> <a href="pdf">Pdf</a>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>