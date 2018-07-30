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
	/**
	 * Return Set of all Todos in db.
	 */
	public Set<Todo> getAllTodos();
	/**
	 * Get Todo with specific id.
	 */
	public Todo findById(Long Id);
	/**
	 * Delete Todo with specific id.
	 */
	public void deleteTodo(Long Id);
	/**
	 * Create Todo and persist it in db.
	 */
	public void addTodo(String desc);
}
