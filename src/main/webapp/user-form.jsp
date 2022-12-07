

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
        <input class="form-control me-2" type="search" placeholder="Search" name="search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a class="d-flex navbar-nav me-auto mb-2 mb-lg-0">${username}</a>
      &nbsp;&nbsp;&nbsp;
       <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/">registered meeting</a>
        </li>
       <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/">about us</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/logout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
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
					<label>Meeting Date</label> <input type="date"
						value="<c:out value='${meeting.date}' />" class="form-control"
						name="date">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Meeting start</label> <input type="time"
						value="<c:out value='${meeting.start}' />" class="form-control"
						name="start">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Meeting end</label> <input type="time"
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