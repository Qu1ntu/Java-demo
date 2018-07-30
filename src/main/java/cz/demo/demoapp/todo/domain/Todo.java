package cz.demo.demo_app.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	Long id;
	
	@Lob
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Todo(String description) {
		this.description = description;
	}
	
	public Todo(){
		
	}
	
	
}
