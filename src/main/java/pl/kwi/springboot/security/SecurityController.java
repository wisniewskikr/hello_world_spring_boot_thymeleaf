package pl.kwi.springboot.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "redirect:/";
	}
	
}