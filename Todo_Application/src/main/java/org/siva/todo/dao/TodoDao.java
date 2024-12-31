package org.siva.todo.dao;

import java.util.List;

import org.siva.todo.entities.Todo;

public interface TodoDao {
	int saveTodo(Todo todo);
	List<Todo> getAllTodos();
	Todo getTodo(int id);
	int updateTodo(String description, String status, int id);
	int deleteTodo(int id);
}
