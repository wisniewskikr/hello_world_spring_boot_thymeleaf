package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.services.NameService;

@Controller
@RequestMapping(value="/input")
public class InputController {
	
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NameService nameService;
	

	@RequestMapping
	public String displayPage() {
		LOG.debug("displayPage()");
		return "input";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")InputCommand command) {
		LOG.debug("handleButtonOk()");
		nameService.save(command.getName());
		return "redirect:/output";
	}

}