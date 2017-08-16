package pl.kwi.springboot.reset.commands;

import java.io.Serializable;

public class ResetChangeCommand implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String token;
	private String password;
	private String confirmPassword;
	
	
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
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
