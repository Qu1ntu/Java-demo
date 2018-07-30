package cz.demoapp.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cz.demoapp.services.TodoService;

/**
 * 
 * @author Quintus
 *
 * Class that is responsible for mapping Thymeleaf templates to URL. Important part of Spring MVC.
 * Thymeleaf templates are the View.
 */

@Controller
public class MainController {

	private final TodoService todoService;
	
	/**
	 * Constructor CDI
	 * @param todoService	IoC - Service instance created by container for us.
	 */
	public MainController(TodoService todoService) {
		this.todoService = todoService;
	}

	/**
	 * Method for returning main page with Todos.
	 * @param model	
	 * @return	returns name of the coresponding template
	 */
	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model)
	{
		model.addAttribute("todos",todoService.getAllTodos());
		return "index";
	}
	
	/**
	 * Page with form for creating new Todo.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index/new")
	public String getNewTodoPage(Model model)
	{
		return "newTodo";
	}
	
	/**
	 * After submitting new Todo add it to collection of all Todos and go back to main page.
	 * @param model
	 * @param description	content of new Todo
	 * @return
	 */
	@PostMapping(value="/index", params= "description")
	public String postNewTodo(Model model, @RequestParam String description)
	{
		todoService.addTodo(description);
		return "redirect:index";
	}
	
}

