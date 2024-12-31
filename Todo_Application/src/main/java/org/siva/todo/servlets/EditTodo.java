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

@WebServlet("/updateTodo")
public class EditTodo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tempId =  request.getParameter("id");
		int id = Integer.parseInt(tempId);
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		TodoDao dao = new TodoDaoImpl();
		int updateTodo = dao.updateTodo(description, status, id);
		if (updateTodo!=0) {
			session.setAttribute("addSuccess", "todo updated successfully");
			response.sendRedirect("Home.jsp");
		}
		else {
			session.setAttribute("deleteInfo", "something went wrong on the server");
			response.sendRedirect("EditTodo.jsp");
		}
	}

}
