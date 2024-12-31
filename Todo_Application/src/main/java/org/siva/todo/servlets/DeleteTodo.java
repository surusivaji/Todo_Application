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

@WebServlet("/deleteTodo")
public class DeleteTodo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempId = request.getParameter("id");
		Integer id = Integer.parseInt(tempId);
		HttpSession session = request.getSession();
		TodoDao dao = new TodoDaoImpl();
		int deleteTodo = dao.deleteTodo(id);
		if (deleteTodo!=0) {
			session.setAttribute("deleteInfo", "User Information Successfully Deleted");
			response.sendRedirect("Home.jsp");
		}
		else {
			session.setAttribute("deleteInfo", "Something Went Wrong On The Server");
			response.sendRedirect("Home.jsp");
		}
	}

}
