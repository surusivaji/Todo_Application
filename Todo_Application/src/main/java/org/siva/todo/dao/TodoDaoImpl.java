package org.siva.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.siva.todo.entities.Todo;

public class TodoDaoImpl implements TodoDao {
	
	public final String url = "jdbc:mysql://localhost:3306/teca55";
	public final String username = "root";
	public final String password = "Siva@2805";
	public final String insertTodo = "insert into todo (description, status) values (?, ?)";
	public final String selectAllTodos = "select * from todo";
	public final String selectTodo = "select * from todo where id=?";
	public final String updateTodo = "update todo set description=?, status=? where id=?";
	public final String deleteTodo = "delete from todo where id=?";
	
	@Override
	public int saveTodo(Todo todo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(insertTodo);
			preparedStatement.setString(1, todo.getDescription());
			preparedStatement.setString(2, todo.getStatus());
			int executeUpdate = preparedStatement.executeUpdate();
			if (executeUpdate!=0) {
				return executeUpdate;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Todo> getAllTodos() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(selectAllTodos);
			ResultSet rs = preparedStatement.executeQuery();
			List<Todo> todos = new ArrayList<Todo>();
			while (rs.next()) {
				Todo todo = new Todo();
				todo.setId(rs.getInt(1));
				todo.setDescription(rs.getString(2));
				todo.setStatus(rs.getString(3));
				todos.add(todo);
			}
			return todos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Todo getTodo(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(selectTodo);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Todo todo = new Todo();
				todo.setId(rs.getInt(1));
				todo.setDescription(rs.getString(2));
				todo.setStatus(rs.getString(3));
				return todo;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateTodo(String description, String status, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(updateTodo);
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, status);
			preparedStatement.setInt(3, id);
			int result = preparedStatement.executeUpdate();
			if (result!=0) {
				return result;
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int deleteTodo(int id) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(deleteTodo);
			preparedStatement.setInt(1, id);
			int update = preparedStatement.executeUpdate();
			if (update!=0) {
				return update;
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	
	
}
