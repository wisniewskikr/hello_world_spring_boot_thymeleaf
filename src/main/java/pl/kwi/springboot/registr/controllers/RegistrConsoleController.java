package pl.kwi.springboot.registr.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.kwi.springboot.registr.commands.RegistrConsoleCommand;
import pl.kwi.springboot.services.UserService;

@Controller
@RequestMapping(value="/registrationConsole")
public class RegistrConsoleController {
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping
	public String displayPage(@ModelAttribute("command")RegistrConsoleCommand command) {
		command.setUsers(userService.getUsersToApprove());
		return "registr/registrConsole";
	}
	
	@RequestMapping(value="/handle-button-approve", method=RequestMethod.POST)
	public String handleButtonApprove (
			@Valid @ModelAttribute("command")RegistrConsoleCommand command,
			RedirectAttributes redirectAttributes) {
		
		return "redirect:/login";
	}

}