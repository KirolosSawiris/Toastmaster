<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
	<div class="row justify-content-center container-fluid ml-5 pl-5 mt-4">
    <div class="col-md-10">
	<table class="table table-bordered w-75 ">
  <thead>
   <tr>
      <th class = "col-md-2 scope=col">Meeting ID:</th>
      <th colspan="3">${meeting.id}</th>
    </tr>
    <tr>
      <th class = "col-md-2 scope=col">Meeting Name:</th>
      <th colspan="3">${meeting.name}</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">location</th>
      <td colspan="3">${meeting.location}</td>
    </tr>
    <tr>
      <th scope="row">Date</th>
      <td colspan="3">${meeting.date}</td>
    </tr>
     <tr>
      <th class="col-md-2"scope="row">From</th>
      <td class="col-md-4">${meeting.start}</td>
      <td class="font-weight-bold col-md-2">To</td>
      <td class="col-md-4">${meeting.end}</td>
    </tr>
    <tr>
      <td class = "font-weight-bold text-center"scope= "row"colspan="4">Meeting Participants</td>
    </tr>
    <tr>
      <th scope="row">Speaker</th>
      <td colspan="2">${meeting.speaker}</td>
     <td><a href="speaker?id=<c:out value='${meeting.id}' />" class= "btn btn-success w-40">Register</a> <a class= "btn btn-danger w-40">Drop</a></td>
    </tr>
    <tr>
      <th scope="row">Toastmaster</th>
      <td colspan="2">${meeting.toastmaster}</td>
     <td><a class= "btn btn-success w-40">Register</a> <a class= "btn btn-danger w-40">Drop</a></td>
    </tr>
    <tr>
      <th scope="row">AhCounter</th>
      <td colspan="2">${meeting.ahCounter}</td>
     <td><a class= "btn btn-success w-40">Register</a> <a class= "btn btn-danger w-40">Drop</a></td>
    </tr>
    <tr>
      <th scope="row">Grammarian</th>
      <td colspan="2">${meeting.grammarian}</td>
      <td><a class= "btn btn-success w-49">Register</a> <a class= "btn btn-danger w-49">Drop</a></td>
    </tr>
    <tr>
      <th scope="row">Evaluator</th>
      <td colspan="2">${meeting.evaluator}</td>
      <td><a class= "btn btn-success w-40">Register</a> <a class= "btn btn-danger w-40">Drop</a></td>
    </tr>
    <tr>
      <th scope="row">Timer</th>
      <td colspan="2">${meeting.timer}</td>
      <td><a class= "btn btn-success w-40">Register</a> <a class= "btn btn-danger w-40">Drop</a></td>
    </tr>
  </tbody>
</table>
</div>
</div>
	
</body>
</html>