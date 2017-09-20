package pl.kwi.springboot.security;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	// This is for logout purpose
	@RequestMapping(value="/login")
	public String login() throws ServletException {
		return "redirect:/";
	}
	
}
