package cz.demoapp.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

import cz.demoapp.repositories.TodoRepository;
import cz.demoapp.todo.domain.Todo;

/**
 * 
 * @author Quintus
 * 
 * <p>Implementation of Service layer used in MainController class. Provides methods on repository.</p>
 */
@Service
public class TodoServiceImpl implements TodoService{
	private final TodoRepository todoRepository;
	
	/**
	 * Constructor CDI
	 * @param todoRepository  Autowired repository - created by container.
	 */
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	/**
	 * Return Set of all Todos in db.
	 */
	@Override
	public Set<Todo> getAllTodos() {
		Set<Todo> result = new HashSet<Todo>();
		Iterator<Todo> it = todoRepository.findAll().iterator();
		while(it.hasNext()){
			result.add(it.next());
		}
		return result;
	}
	
	/**
	 * Get Todo with specific id.
	 */
	@Override
	public Todo findById(Long Id) {
		return todoRepository.findById(Id).get();
	}

	/**
	 * Delete Todo with specific id.
	 */
	@Override
	public void deleteTodo(Long id) {
		todoRepository.delete(findById(id));
		
	}
	
	/**
	 * Create Todo and persist it in db.
	 */
	@Override
	public void addTodo(String desc){
		todoRepository.save(new Todo(desc));
	}
	
}
