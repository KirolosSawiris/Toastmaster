

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Toastmasters Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.toastmasters.org/" class="navbar-brand"> Toastmasters Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Meetings</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${meeting != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${meeting == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${meeting != null}">
            			Edit User
            		</c:if>
						<c:if test="${meeting == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${meeting != null}">
					<input type="hidden" name="id" value="<c:out value='${meeting.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Meeting Name</label> <input type="text"
						value="<c:out value='${meeting.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Meeting Location</label> <input type="text"
						value="<c:out value='${meeting.location}' />" class="form-control"
						name="location">
				</fieldset>

				<fieldset class="form-group">
					<label>Meeting Date</label> <input type="text"
						value="<c:out value='${meeting.date}' />" class="form-control"
						name="date">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Meeting start</label> <input type="text"
						value="<c:out value='${meeting.start}' />" class="form-control"
						name="start">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Meeting end</label> <input type="text"
						value="<c:out value='${meeting.end}' />" class="form-control"
						name="end">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>