package cz.demo.demo_app.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cz.demo.demo_app.services.TodoService;

@Controller
public class MainController {
	
	private final TodoService todoService;
	
	public MainController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model)
	{
		model.addAttribute("todos",todoService.getAllTodos());
		return "index";
	}
	
	@RequestMapping(value="/index/new")
	public String getNewTodoPage(Model model)
	{
		return "newTodo";
	}
	
	@PostMapping(value="/index", params= "description")
	public String postNewTodo(Model model, @RequestParam String description)
	{
		todoService.addTodo(description);
		return "index";
	}
	
}

