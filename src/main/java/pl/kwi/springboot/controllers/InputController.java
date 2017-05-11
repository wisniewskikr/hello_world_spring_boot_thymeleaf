package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;

@Controller
@RequestMapping(value="/input")
public class InputController {

	@RequestMapping
	public String displayPage() {
		return "input";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")InputCommand command) {
		System.out.println("name: " + command.getName());
		return "input";
	}

}