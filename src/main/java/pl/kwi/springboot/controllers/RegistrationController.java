package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kwi.springboot.commands.RegistrationCommand;

@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
	
	@RequestMapping
	public String displayPage() {
		return "registration";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")RegistrationCommand command) {
		return "redirect:/confirmation";
	}

}