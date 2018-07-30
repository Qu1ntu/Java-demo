package cz.demoapp.repositories;

import org.springframework.data.repository.CrudRepository;

import cz.demoapp.todo.domain.Todo;

/**
 * 
 * @author Quintus
 *
 * <p>Interface that makes it possible to make CRUD operations on type Todo in db (all work is done by framework). (Long is the type of ID)</p>
 */

public interface TodoRepository extends CrudRepository<Todo, Long>{

}
