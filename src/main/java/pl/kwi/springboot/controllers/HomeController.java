package pl.kwi.springboot.controllers;

import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String index() {
		return "redirect:en_US/input";
	}
	
	@RequestMapping(value="/{loc}")
	public String indexWithLocale(
			@PathVariable(name = "loc") String loc) {
		
		if (!isLocale(loc)) {
			throw new IllegalStateException("Wrong path");
		}
		
		return "redirect:/" + loc +"/input";
		
	}
	
	private boolean isLocale(String locale) {
        //validate the string here against an accepted list of locales or whatever
        try {
            Locale parsedLocale = LocaleUtils.toLocale(locale);
            return LocaleUtils.isAvailableLocale(parsedLocale);
        } catch (IllegalArgumentException e) {
        }
        return false;
    }
	
}