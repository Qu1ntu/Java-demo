package cz.demoapp.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import cz.demoapp.mappers.TodoMapper;
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
	//private final TodoRepository todoRepository;
	private SqlSessionFactory factory;
	/**
	 * Constructor
	 * factory - created by builer from xml.
	 */
	public TodoServiceImpl() {
		SqlSessionFactory sqlSessionFactory = null;
		
		InputStream inputStream;
		try
		{
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (IOException e)
		{
			
		}
		this.factory = sqlSessionFactory;
		//this.todoRepository = todoRepository;
	}

	private SqlSession openSqlSession()
	{
		return factory.openSession();
	}
	
	@Override
	public Set<Todo> getAllTodos()
	{
		SqlSession sqlSession = openSqlSession();
		try {
			TodoMapper todoMapper = sqlSession.getMapper(TodoMapper.class);
			return todoMapper.findAllTodos();
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public void addTodo(String desc)
	{
		SqlSession sqlSession = openSqlSession();
		try {
			TodoMapper todoMapper = sqlSession.getMapper(TodoMapper.class);
			todoMapper.insertTodo(desc);
			sqlSession.commit();
			
		} finally {
			sqlSession.close();
		}
	}
	
	/*
	 * Return Set of all Todos in db.
	 */
	/*
	@Override
	public Set<Todo> getAllTodos() {
		Set<Todo> result = new HashSet<Todo>();
		Iterator<Todo> it = todoRepository.findAll().iterator();
		while(it.hasNext()){
			result.add(it.next());
		}
		return result;
	}*/
	
	/*
	 * Get Todo with specific id.
	 */
	/*
	@Override
	public Todo findById(Long Id) {
		return todoRepository.findById(Id).get();
	}*/

	/*
	 * Delete Todo with specific id.
	 */
	/*
	@Override
	public void deleteTodo(Long id) {
		todoRepository.delete(findById(id));
		
	}*/
	
	/*
	 * Create Todo and persist it in db.
	 */
	/*
	@Override
	public void addTodo(String desc){
		todoRepository.save(new Todo(desc));
	}*/
	
}
