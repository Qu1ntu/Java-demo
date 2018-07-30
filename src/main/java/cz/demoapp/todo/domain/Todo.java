package cz.demoapp.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

/**
 * 
 * @author Quintus
 *
 * Class that defines what shall be persisted in db - db schema. The state of Todo objects is the Model of MVC.
 */

@Data
@Entity
public class Todo {
	/**
	 * unique identifier
	 */
	@Id
	@GeneratedValue
	Long id;
	
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
