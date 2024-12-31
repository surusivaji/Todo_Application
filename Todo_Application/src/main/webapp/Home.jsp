<%@page import="org.siva.todo.entities.Todo"%>
<%@page import="java.util.List"%>
<%@page import="org.siva.todo.dao.TodoDaoImpl"%>
<%@page import="org.siva.todo.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Todo Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="bg-dark">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="card mt-3">
				<div class="col-md-12">
					<h1 class="text-danger fw-bold fs-1 text-center" style="text-shadow:2px 1px #000">Todo
						Application</h1>
				</div>
				<div class="col-md-12 mt-2">
					<a href="AddTodo.jsp" class="btn btn-primary mb-2">Add Todo</a>
					<%
					String addSuccess = (String) session.getAttribute("addSuccess");
					if (addSuccess != null) {
					%>
					<div class="alert alert-success text-center m-2">
						<%=addSuccess%>
					</div>
					<%
						session.removeAttribute("addSuccess");
					}
					String deleteInfo = (String) session.getAttribute("deleteInfo");
					if (deleteInfo != null) {
					%>
					<div class="alert alert-danger text-center m-2">
						<%=deleteInfo%>
					</div>
					<%
						session.removeAttribute("deleteInfo");
					}
					%>
					<table class="table table-hover table-bordered">
						<thead class="bg-info text-light">
							<tr>
								<th>SI.No.</th>
								<th>Description</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
							TodoDao dao = new TodoDaoImpl();
							List<Todo> todos = dao.getAllTodos();
							for (Todo todo : todos) {
							%>
							<tr>
								<td><%=todo.getId()%></td>
								<td><%=todo.getDescription()%></td>
								<td>
									<% 
										if (todo.getStatus().equals("Completed"))
										{%>
											<span class="btn btn-info btn-sm"><%=todo.getStatus() %></span>
										<%}
										else if (todo.getStatus().equals("Pending")) 
										{%>
											<span class="btn btn-warning btn-sm"><%= todo.getStatus() %></span>	
										<%}
									%>
								</td>
								<td><a href="EditTodo.jsp?id=<%=todo.getId()%>"
									class="btn btn-success btn-sm me-2">Edit</a> 
									<a href="deleteTodo?id=<%=todo.getId() %>"
									class="btn btn-danger btn-sm">Remove</a></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
