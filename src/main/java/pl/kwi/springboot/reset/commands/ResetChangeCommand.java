package pl.kwi.springboot.reset.commands;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

public class ResetChangeCommand implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String token;
	@NotBlank(message="Field 'Password' can not be blank")
	private String password;
	@NotBlank(message="Field 'Confirm Password' can not be blank")
	private String passwordConfirmation;	
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}		
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	@AssertTrue(message="Passwords does not match")
	public boolean isPasswordsMatch() {
		if (StringUtils.isBlank(password) || StringUtils.isBlank(passwordConfirmation)) {
			return true;
		}
		return password.equals(passwordConfirmation);
	}
		
}
