package pl.kwi.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/input")
public class InputController {

	@RequestMapping
	public String displayPage() {
		return "input";
	}

}