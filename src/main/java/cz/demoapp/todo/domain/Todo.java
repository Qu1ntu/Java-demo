package cz.demoapp.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Quintus
 *
 * <p>Class that defines what shall be persisted in db - db schema. The state of Todo objects is the Model of MVC.</p>
 */

@Data
@Entity
@Table(name="TODOS")
public class Todo {
	/**
	 * unique identifier
	 */
	@Id
	@GeneratedValue
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
	
	@Override
	public String toString(){
		return this.description;
	}
	
}
