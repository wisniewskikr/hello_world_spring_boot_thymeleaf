package pl.kwi.springboot.controllers;

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
		
		return "redirect:/" + loc +"/input";
		
	}
	
}