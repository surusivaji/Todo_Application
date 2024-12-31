package org.siva.todo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.siva.todo.dao.TodoDao;
import org.siva.todo.dao.TodoDaoImpl;
import org.siva.todo.entities.Todo;

@WebServlet("/saveTodo")
public class SaveTodo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		
		Todo todo = new Todo();
		todo.setDescription(description);
		todo.setStatus(status);
		
		HttpSession session = request.getSession();
		
		TodoDao dao = new TodoDaoImpl();
		int saveTodo = dao.saveTodo(todo);
		if (saveTodo!=0) {
			session.setAttribute("addSuccess", "Todo added successfully completed");
			response.sendRedirect("Home.jsp");
		} else {
			session.setAttribute("addFail", "Something went wrong on the server");
			response.sendRedirect("AddTodo.jsp");
		}
		
	}

}
