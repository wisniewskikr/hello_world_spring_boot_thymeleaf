package pl.kwi.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.daos.Language;
import pl.kwi.springboot.services.MessageService;
import pl.kwi.springboot.services.NameService;

@Controller
public class InputController {
	
	private static final String POLISH_VALUE = "input.language.polish.value";
	private static final String POLISH_KEY = "input.language.polish.key";
	private static final String ENGLISH_VALUE = "input.language.english.value";
	private static final String ENGLISH_KEY = "input.language.english.key";

	@Autowired
	private NameService nameService;
	
	@Autowired
	private MessageService messageServiece;
	
	@Autowired
	LocaleResolver localeResolver;

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
		return "redirect:/output";
		
	}
	
	@RequestMapping(value="/input/handle-language-change", method=RequestMethod.POST)
	public String handleLanguageChange(
			HttpServletRequest request, 
			HttpServletResponse response,
			@ModelAttribute("language")String language) {
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(language));
		return "redirect:/input";
		
	}
	
	@ModelAttribute("languages")
	public List<Language> populateLanguages(HttpServletRequest request) {	
		
		Locale loc = localeResolver.resolveLocale(request);
		
	    List<Language> languages = new ArrayList<Language>();
	    languages.add(new Language(messageServiece.getMessage(ENGLISH_KEY, loc.toString()), messageServiece.getMessage(ENGLISH_VALUE, loc.toString())));
	    languages.add(new Language(messageServiece.getMessage(POLISH_KEY, loc.toString()), messageServiece.getMessage(POLISH_VALUE, loc.toString())));
	    return languages;
	}
	
	@ModelAttribute("currentLanguage")
	public String populateCurrentLanguage(HttpServletRequest request) {
		return localeResolver.resolveLocale(request).toString();
	}

}