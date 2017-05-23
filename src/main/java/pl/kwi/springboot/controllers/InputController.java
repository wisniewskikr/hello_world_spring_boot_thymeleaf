package pl.kwi.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.controllers.abstr.AbstractController;
import pl.kwi.springboot.daos.Language;
import pl.kwi.springboot.services.MessageService;
import pl.kwi.springboot.services.NameService;

@Controller
public class InputController extends AbstractController {
	
	private static final String POLISH_VALUE = "input.language.polish.value";
	private static final String POLISH_KEY = "input.language.polish.key";
	private static final String ENGLISH_VALUE = "input.language.english.value";
	private static final String ENGLISH_KEY = "input.language.english.key";

	@Autowired
	private NameService nameService;
	
	@Autowired
	private MessageService messageServiece;

	@RequestMapping(value="/input")
	public String displayPage(
			@ModelAttribute("command")InputCommand command,
			Model model) {
		
		model.addAttribute("command", command);
		return "input";
	}
	
	@RequestMapping(value="/input/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")InputCommand command,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "input";
		}
		
		nameService.save(command.getName());
		return "redirect:/" + command.getLoc() + "/output";
		
	}
	
	@RequestMapping(value="/input/handle-language-change", method=RequestMethod.POST)
	public String handleLanguageChange(
			@ModelAttribute("language")String language) {	
		return "redirect:/" + language + "/input";
		
	}
	
	@ModelAttribute("languages")
	public List<Language> populateLanguages(@ModelAttribute("loc")String loc) {	
	    List<Language> languages = new ArrayList<Language>();
	    languages.add(new Language(messageServiece.getMessage(ENGLISH_KEY, loc), messageServiece.getMessage(ENGLISH_VALUE, loc)));
	    languages.add(new Language(messageServiece.getMessage(POLISH_KEY, loc), messageServiece.getMessage(POLISH_VALUE, loc)));
	    return languages;
	}

}