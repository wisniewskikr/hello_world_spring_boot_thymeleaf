package pl.kwi.springboot.commands;

import java.io.Serializable;

import pl.kwi.springboot.enums.ConfirmationEnum;

public class ConfirmationCommand implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private ConfirmationEnum confirmationEnum;
	private String message;


	public ConfirmationEnum getConfirmationEnum() {
		return confirmationEnum;
	}
	public void setConfirmationEnum(ConfirmationEnum confirmationEnum) {
		this.confirmationEnum = confirmationEnum;
	}
	
	public String getMessage() {
		message = confirmationEnum.getMessage();
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
