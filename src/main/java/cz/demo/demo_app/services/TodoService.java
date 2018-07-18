package cz.demo.demo_app.services;

import java.util.Set;

import cz.demo.demo_app.todo.domain.Todo;

public interface TodoService {
	public Set<Todo> getAllTodos();
	public Todo findById(Long Id);
	public void deleteTodo(Long Id);
	public void addTodo(String desc);
}
