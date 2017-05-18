package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.controllers.abstr.AbstractController;
import pl.kwi.springboot.services.NameService;

@Controller
public class InputController extends AbstractController {
	
	@Autowired
	private NameService nameService;

	@RequestMapping(value="/input")
	public String displayPage(
			@ModelAttribute("command")InputCommand command,
			Model model) {
		
		System.out.println("loc: " + command.getLoc());
		model.addAttribute("command", command);
		return "input";
	}
	
	@RequestMapping(value="/input/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")InputCommand command) {
		
		nameService.save(command.getName());
		return "redirect:/" + command.getLoc() + "/output";
		
	}

}