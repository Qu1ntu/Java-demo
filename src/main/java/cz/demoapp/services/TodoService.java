package cz.demoapp.services;

import java.util.Set;

import cz.demoapp.todo.domain.Todo;

/**
 * 
 * @author Quintus
 *
 * Service Interface
 */
public interface TodoService {
	public Set<Todo> getAllTodos();
	public Todo findById(Long Id);
	public void deleteTodo(Long Id);
	public void addTodo(String desc);
}
