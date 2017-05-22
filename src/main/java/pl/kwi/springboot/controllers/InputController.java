package pl.kwi.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.controllers.abstr.AbstractController;
import pl.kwi.springboot.daos.Language;
import pl.kwi.springboot.services.NameService;

@Controller
public class InputController extends AbstractController {
	
	@Autowired
	private NameService nameService;

	@RequestMapping(value="/input")
	public String displayPage(
			@ModelAttribute("command")InputCommand command,
			Model model) {
		
		model.addAttribute("command", command);
		return "input";
	}
	
	@RequestMapping(value="/input/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")InputCommand command) {
		
		nameService.save(command.getName());
		return "redirect:/" + command.getLoc() + "/output";
		
	}
	
	@RequestMapping(value="/input/handle-language-change", method=RequestMethod.POST)
	public String handleLanguageChange(
			@ModelAttribute("language")String language) {	
		return "redirect:/" + language + "/input";
		
	}
	
	@ModelAttribute("languages")
	public List<Language> populateLanguages() {		
	    List<Language> languages = new ArrayList<Language>();
	    languages.add(new Language("en_US", "English"));
	    languages.add(new Language("pl_PL", "Polski"));
	    return languages;
	}

}