package pl.kwi.springboot.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringSecurityController {
	
	@RequestMapping(value="/login")
	public String login() {
		return "security/login";
	}
	
	@RequestMapping(value="/error403")
	public String error403() {
		return "security/error403";
	}
	
	@RequestMapping(value="/error403/handle-button-back", method=RequestMethod.POST)
	public String handleButtonBack(){
		return "redirect:/";
	}

}