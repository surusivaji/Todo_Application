package org.siva.todo.entities;

public class Todo {
	
	private int id;
	private String description;
	private String status;
	
	public Todo() {
		
	}

	public Todo(int id, String description, String status) {
		this.id = id;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", status=" + status + "]";
	}

}
