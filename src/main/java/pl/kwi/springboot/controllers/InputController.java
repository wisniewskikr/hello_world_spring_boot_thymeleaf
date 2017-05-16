package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.services.NameService;

@Controller
@RequestMapping(value="/input")
public class InputController {
	
	@Autowired
	private NameService nameService;

	@RequestMapping
	public String displayPage(Model model) {
		InputCommand command = new InputCommand();
		model.addAttribute("command", command);
		return "input";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")InputCommand command, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "input";
		}
		
		nameService.save(command.getName());
		return "redirect:/output";
	}

}