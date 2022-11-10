<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Student Management Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container p-3 my-3 bg-success text-white">

		<h1 class="text-warning" style="text-align: center;">Shashankshekhar Singh</h1>
		<hr class="text-warning" style="background-color: orange; hight: 6px;">
		<p class="text-warning"
			style="text-align: center; font-size: 20px; hight: 2px;">
			The List of All Student</p>
		<hr class="text-warning" style="background-color: orange; hight: 6px;">
		<a href="ShowCustomerForm" class="btn btn-warning"
			role="button">Add Student</a> <a href="redirect:/Customer/List" class="btn btn-warning" role="button">
			All Students</a>

	</div>

	<div class="container">

		<table class="table">

			<thead>
				<tr class="table-dark text-dark">
					<th>Student Id</th>
					<th> First Name</th>
					<th>Last Name</th>
					<th>Course</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="proper" items="${customers}" varStatus="c">
				<tbody>
					<tr>
					<td class="table-warning">${c.count}</td>
						<td class="table-warning">${proper.firstName}</td>
						<td class="table-active">${proper.lastName}</td>
						<td class="table-secondary">${proper.course}</td>
						<td class="table-secondary">${proper.country}</td>
						<td class="table-danger"><a href="Update?id=${proper.id}"
							class="btn btn-warning">Update</a> | <a
							href="Delete?id=${proper.id}" class="btn btn-danger" >Delete</a></td>

					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>