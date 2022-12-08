<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Toastmasters</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		
		
		<nav class="navbar navbar-expand-md navbar-dark bg-gradient text-white" style="background-color: #13133a"> 
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <img class="navbar-brand" alt="icon" src="https://i.ibb.co/RBBrcy1/toastmasters-logo2x.png">
      <a class="navbar-brand" href="#">Toasmasters Application</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Meetings</a>
        </li>
      </ul>
       &nbsp;&nbsp;&nbsp;&nbsp;
      <form method="post" action="search" class="d-flex navbar-nav me-auto mb-2 mb-lg-0 w-50">
        <input class="form-control me-2" type="search" placeholder="Search" name="search"  value="${search}" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a class="d-flex navbar-nav me-auto mb-2 mb-lg-0">${username}</a>
      &nbsp;&nbsp;&nbsp;
       <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/registeredmeetings">Registered Meetings</a>
        </li> 	
       <li class="nav-item">
          <a class="nav-link" href="https://www.toastmasters.org/resources/meeting-roles-and-responsibilities">Roles</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/logout"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Log Out</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
		
		
		
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Meetings</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Meeting</a>
			</div>
			<br>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Location</th>
						<th>Date</th>
						<th>Start</th>
						<th>End</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="meeting" items="${listMeeting}">

						<tr>
							<td><c:out value="${meeting.id}" /></td>
							<td><c:out value="${meeting.name}"/></td>
							<td><c:out value="${meeting.location}" /></td>
							<td><c:out value="${meeting.date}" /></td>
							<td><c:out value="${meeting.start}" /></td>
							<td><c:out value="${meeting.end}" /></td>
							<td> <c:if test="${ID == '1'}">
							<a class = "btn btn-secondary" href="edit?id=<c:out value='${meeting.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a class = "btn btn-danger"
								href="delete?id=<c:out value='${meeting.id}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<a class = "btn btn-primary"
								href="meeting?id=<c:out value='${meeting.id}' />">Register</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>