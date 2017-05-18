package pl.kwi.springboot.commands;

import pl.kwi.springboot.commands.abstr.AbstractCommand;


public class OutputCommand extends AbstractCommand {
	

	private String name;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
}
