package cz.demoapp.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * 
 * @author Quintus
 *
 * <p>Class that defines what shall be persisted in db - db schema. The state of Todo objects is the Model of MVC.</p>
 */

@Data
@Entity
public class Todo {
	/**
	 * unique identifier
	 */
	@Id
	@SequenceGenerator(name = "todo_generator", sequenceName = "todo_sequence", allocationSize = 1)
	@GeneratedValue(generator = "todo_generator")
	Long Id;
	
	/**
	 * Content, can be longer than 255 characters.
	 */
	@Lob
	private String description;

	public Todo(String description) {
		this.description = description;
	}
	
	public Todo(){
		
	}
	
	
}
