package pl.kwi.springboot.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.services.CsvService;
import pl.kwi.springboot.services.NameService;

@Controller
@RequestMapping(value="/input")
public class InputController {
	
	@Autowired
	private NameService nameService;
	
	@Autowired
	private CsvService csvService;

	@RequestMapping
	public String displayPage() {
		return "input";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(@ModelAttribute("command")InputCommand command) throws IOException {
		
		List<String[]> csvList = csvService.readLinesFromFile(command.getFile().getInputStream());
		
		String name = csvList.get(0)[0];
		nameService.save(name);
		return "redirect:/output";
		
	}

}