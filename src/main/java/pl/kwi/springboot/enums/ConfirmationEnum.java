package pl.kwi.springboot.enums;

public enum ConfirmationEnum {
	
	
	REGISTRATION("You have been registered successfully."), 
	RESET_EMAIL("Email with reset password link was sent on your email account.");
	
	private String message;
	
	
	ConfirmationEnum(String message) {
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
