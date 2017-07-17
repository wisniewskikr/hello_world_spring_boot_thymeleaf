package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kwi.springboot.commands.RegistrationCommand;
import pl.kwi.springboot.services.UserService;

@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping
	public String displayPage() {
		return "registration";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")RegistrationCommand command) {
		userService.registerUser(command.getLogin(), command.getPassword());
		return "redirect:/confirmation";
	}

}