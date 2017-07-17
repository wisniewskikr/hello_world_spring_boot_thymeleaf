package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.ConfirmationCommand;

@Controller
@RequestMapping(value="/confirmation")
public class ConfirmationController {
	
	@RequestMapping
	public String displayPage() {
		return "confirmation";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")ConfirmationCommand command) {
		return "redirect:/input";
	}

}