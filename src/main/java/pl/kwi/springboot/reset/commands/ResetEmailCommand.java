package pl.kwi.springboot.reset.commands;

import java.io.Serializable;

public class ResetEmailCommand implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String email;
			
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
