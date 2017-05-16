package pl.kwi.springboot.commands;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class InputCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Please fill this field")
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
}
