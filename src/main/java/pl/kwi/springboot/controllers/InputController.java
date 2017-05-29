package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.services.IdService;
import pl.kwi.springboot.services.UserService;

@Controller
@RequestMapping(value="/input")
public class InputController {
	
	@Autowired
	private IdService idService;
	
	@Autowired
	private UserService userService;

	@RequestMapping
	public String displayPage() {
		return "input";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")InputCommand command) {
		
		long id = userService.createUserWithName(command.getName());
		idService.save(String.valueOf(id));
		return "redirect:/output";
	}

}