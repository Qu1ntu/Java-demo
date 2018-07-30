package cz.demo.demo_app.repositories;

import org.springframework.data.repository.CrudRepository;

import cz.demo.demo_app.todo.domain.Todo;


public interface TodoRepository extends CrudRepository<Todo, Long>{

}
