package cz.demoapp.mappers;

import java.util.Set;

import cz.demoapp.todo.domain.Todo;

public interface TodoMapper {
	public Set<Todo> findAllTodos();
	public void insertTodo(String description);
}
