<%@page import="org.siva.todo.entities.Todo"%>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
  	<%
  		String tempId = request.getParameter("id");
  		Integer id = Integer.parseInt(tempId);
  		TodoDao dao = new TodoDaoImpl();
  		Todo todo = dao.getTodo(id);
  	%>
  	<div class="container">
  		<div class="row d-flex justify-content-center vh-100 align-items-center">
  			<div class="col-md-6">
  				<div class="card">
  					<div class="card-head bg-success text-light p-3">
	  					<h2 class="text-center fw-bold" style="text-shadow:2px 2px #000">EDIT TODO</h2>
	  				</div>
	  				<div class="card-body">
	  					<form method="post" action="updateTodo">
	  						<div class="form-group mt-3">
	  							<label for="description">Description</label>
	  							<input type="text" name="id" class="form-control" value="<%= todo.getId() %>" autocomplete="off" hidden="true" required>
	  							<input type="text" name="description" class="form-control" value="<%= todo.getDescription() %>" autocomplete="off" required>
	  						</div>
	  					<div class="form-group mt-3">
						   <label for="status">Status</label>
						   <select name="status" id="status" class="form-select" aria-label="Default select example" required>
						      <option value="<%= todo.getStatus() != null ? todo.getStatus() : "" %>"><%= todo.getStatus() != null ? todo.getStatus() : "Select Status" %></option>
						      <option value="Pending">Pending</option>
						      <option value="Completed">Completed</option>
						   </select>
						</div>

	  						<div class="form-group mt-3 mb-1">
	  							<input type="submit" value="update todo" class="btn btn-primary form-control">
	  						</div>
	  					</form>
	  				</div>
  				</div>
  			</div>
  		</div>
  	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>