package cz.demo.demo_app.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

import cz.demo.demo_app.repositories.TodoRepository;
import cz.demo.demo_app.todo.domain.Todo;

@Service
public class TodoServiceImpl implements TodoService{
	private final TodoRepository todoRepository;
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public Set<Todo> getAllTodos() {
		Set<Todo> result = new HashSet<Todo>();
		Iterator<Todo> it = todoRepository.findAll().iterator();
		while(it.hasNext()){
			result.add(it.next());
		}
		return result;
	}
	
	@Override
	public Todo findById(Long Id) {
		return todoRepository.findById(Id).get();
	}

	@Override
	public void deleteTodo(Long id) {
		todoRepository.delete(findById(id));
		
	}
	
	@Override
	public void addTodo(String desc){
		todoRepository.save(new Todo(desc));
	}
	
}
