package pl.kwi.springboot.enums;

public enum ConfirmationEnum {
	
	
	REGISTRATION("Email with your registration request was sent to administrator. Please wait for his approval."), 
	RESET_EMAIL("Email with reset password link was sent on your email account."),
	RESET_CHANGE("Your password has been changed."),
	NOT_VALID_TOKEN("Token is not valid.");
	
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
